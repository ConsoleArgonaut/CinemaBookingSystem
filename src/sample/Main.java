package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import System.*;

import javax.swing.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("starter.fxml"));
        primaryStage.setTitle("Booking System");
        primaryStage.setScene(new Scene(root, 900, 600));
        primaryStage.setResizable(false);
        primaryStage.show();
        PrimaryStage = primaryStage;
        system = new BookingSystem();

        system.load();

        if(system.getShows().size() == 0){
            system.setTheatres(new ArrayList<Theatre>());
            system.getTheatres().add(new Theatre("Theatre 1 ", new Seat[] {
                    new Seat(1, 1), new Seat(1, 2), new Seat(1, 3), new Seat(1, 4), new Seat(1, 5), new Seat(1, 6), new Seat(1, 7), new Seat(1, 8),
                    new Seat(2, 1), new Seat(2, 2), new Seat(2, 3), new Seat(2, 4), new Seat(2, 5), new Seat(2, 6), new Seat(2, 7), new Seat(2, 8),
                    new Seat(3, 1), new Seat(3, 2), new Seat(3, 3), new Seat(3, 4), new Seat(3, 5), new Seat(3, 6), new Seat(3, 7), new Seat(3, 8),
                    new Seat(4, 1), new Seat(4, 2), new Seat(4, 3), new Seat(4, 4), new Seat(4, 5), new Seat(4, 6), new Seat(4, 7), new Seat(4, 8),
                    new Seat(5, 1), new Seat(5, 2), new Seat(5, 3), new Seat(5, 4), new Seat(5, 5), new Seat(5, 6), new Seat(5, 7), new Seat(5, 8),
                    new Seat(6, 1), new Seat(6, 2), new Seat(6, 3), new Seat(6, 4), new Seat(6, 5), new Seat(6, 6), new Seat(6, 7), new Seat(6, 8),
                    new Seat(7, 1), new Seat(7, 2), new Seat(7, 3), new Seat(7, 4), new Seat(7, 5), new Seat(7, 6), new Seat(7, 7), new Seat(7, 8),
                    new Seat(8, 1), new Seat(8, 2), new Seat(8, 3), new Seat(8, 4), new Seat(8, 5), new Seat(8, 6), new Seat(8, 7), new Seat(8, 8)
            }));
            system.getTheatres().add(new Theatre("Theatre 2", new Seat[] {
                    new Seat(1, 1), new Seat(1, 2), new Seat(1, 3), new Seat(1, 4), new Seat(1, 5),
                    new Seat(2, 1), new Seat(2, 2), new Seat(2, 3), new Seat(2, 4), new Seat(2, 5),
                    new Seat(3, 1), new Seat(3, 2), new Seat(3, 3), new Seat(3, 4), new Seat(3, 5),
                    new Seat(4, 1), new Seat(4, 2), new Seat(4, 3), new Seat(4, 4), new Seat(4, 5),
                    new Seat(5, 1), new Seat(5, 2), new Seat(5, 3), new Seat(5, 4), new Seat(5, 5)
            }));
            system.getTheatres().add(new Theatre("Kids Theatre", new Seat[] {
                    new Seat(1, 1), new Seat(1, 2), new Seat(1, 3), new Seat(1, 4),
                    new Seat(2, 1), new Seat(2, 2), new Seat(2, 3), new Seat(2, 4),
                    new Seat(3, 1), new Seat(3, 2), new Seat(3, 3), new Seat(3, 4),
                    new Seat(4, 1), new Seat(4, 2), new Seat(4, 3), new Seat(4, 4)
            }));
            system.getShows().add(new Show(new Movie("RoboCop", "Der Polizist Alex Murphy wird bei einem Einsatz brutal ermordet und erwacht im Körper eines Roboters zu neuem Leben.", 103, "https://www.youtube.com/watch?v=zbCbwP6ibR4"), java.sql.Date.valueOf("2017-08-25"), system.getTheatres().get(0).copy()));
            system.getShows().add(new Show(new Movie("Die Hochzeits-Crasher", "Die Hochzeits-Crasher ist eine Filmkomödie des Regisseurs David Dobkin aus dem Jahre 2005 mit Owen Wilson und Vince Vaughn.", 123, "https://www.youtube.com/watch?v=pMmz4IZTjq8"), java.sql.Date.valueOf("2017-12-07"), system.getTheatres().get(1).copy()));
            system.getShows().add(new Show(new Movie("High School Musical", "High School Musical ist ein US-amerikanischer Musical-Fernsehfilm der Walt Disney Company aus dem Jahr 2006.", 98, "https://www.youtube.com/watch?v=ukDLkkvZYFk"), java.sql.Date.valueOf("2017-12-13"), system.getTheatres().get(2).copy()));
        }

    }

    /*Properties*/
    private static BookingSystem system;
    private static boolean isFirstInitialize = true;


    private static Stage PrimaryStage;

    @FXML private TextField cancelreservation_phoneNumber = new TextField();
    @FXML private TextField cancelreservation_firstName = new TextField();
    @FXML private TextField cancelreservation_lastName = new TextField();
    @FXML private ChoiceBox cancelreservation_bookedMovie = new ChoiceBox();

    @FXML private ChoiceBox bookseats_shows = new ChoiceBox();
    @FXML private TextField bookseats_row = new TextField();
    @FXML private TextField bookseats_seatFrom = new TextField();
    @FXML private TextField bookseats_seatTill = new TextField();
    @FXML private TextField bookseats_phonenumber = new TextField();
    @FXML private TextField bookseats_name = new TextField();
    @FXML private TextField bookseats_firstName = new TextField();
    @FXML private Label bookseats_openRows = new Label();;

    @FXML private ChoiceBox addshow_theatre = new ChoiceBox();
    @FXML private ChoiceBox addshow_film = new ChoiceBox();
    @FXML private TextField addshow_title = new TextField();
    @FXML private TextArea addshow_description = new TextArea();
    @FXML private TextField addshow_duration = new TextField();
    @FXML private TextField addshow_trailer = new TextField();
    @FXML private TextField addshow_date = new TextField();

    @FXML private ChoiceBox manageshows_show = new ChoiceBox();
    @FXML private Label manageshows_reservations = new Label();

    public static void main(String[] args) {
        launch(args);
    }

    @FXML
    /*This sets starter as current scene*/
    public void goToStarter(Event arg0) {
        try{
            PrimaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("starter.fxml")), 900, 600));
        }
        catch (Exception ex){

        }
    }

    @FXML
    /*This sets bookseats as current scene*/
    public void goToBookSeats(Event arg0) {
        try{
            PrimaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("bookseats.fxml")), 900, 600));
        }
        catch (Exception ex){

        }
    }

    @FXML
    /*This sets bookseats as current scene*/
    public void goToManageShows(Event arg0) {
        try{
            PrimaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("manageshows.fxml")), 900, 600));
        }
        catch (Exception ex){

        }
    }

    @FXML
    /*This sets cancelreservation as current scene*/
    public void goToCancelReservation(Event arg0) {
        try{
            PrimaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("cancelreservation.fxml")), 900, 600));
        }
        catch (Exception ex){

        }
    }

    @FXML
    /*This sets addshow as current scene*/
    public void goToAddShow(Event arg0) {
        try{
            PrimaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("addshow.fxml")), 900, 600));
        }
        catch (Exception ex){

        }
    }

    @FXML
    public void addshow_save(Event arg0){
        DateFormat format = new SimpleDateFormat("dd.MM.yyyy hh:ss");
        try{
            java.util.Date dateToSet = format.parse(addshow_date.getText());
            if(addshow_title.getText().trim().equals("")){
                system.addShow(new Show((Movie)addshow_film.getValue(), dateToSet, (Theatre)addshow_theatre.getValue()));
            }
            else{
                Movie movieToSet = new Movie(addshow_title.getText(), addshow_description.getText(), Integer.parseInt(addshow_duration.getText()), addshow_trailer.getText());
                system.addShow(new Show(movieToSet, dateToSet, (Theatre)addshow_theatre.getValue()));
            }
            system.save();
            goToAddShow(null);
        } catch (ParseException ex){
            JOptionPane.showMessageDialog(null, "A value was not formatted the right way", "Failed to save show", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @FXML
    public void bookseats_select(Event arg0){
        bookseats_openRows.setText(((Show)bookseats_shows.getValue()).getTheatre().getAllOpenSeats());
    }

    @FXML
    public void bookseats_submit(Event arg0){
        if(bookseats_row.getText().length() > 0 && bookseats_seatFrom.getText().length() > 0 && bookseats_seatTill.getText().length() > 0 && bookseats_phonenumber.getText().length() > 0){
            try{
                system.bookSeats(new Client(bookseats_firstName.getText(), bookseats_name.getText(), bookseats_phonenumber.getText()), (Show)bookseats_shows.getValue(), Integer.parseInt(bookseats_row.getText()), Integer.parseInt(bookseats_seatFrom.getText()), Integer.parseInt(bookseats_seatTill.getText()));
                system.save();
            }
            catch (Exception ex){
                JOptionPane.showMessageDialog(null, "Seat could not be booked", "Booking failed", JOptionPane.INFORMATION_MESSAGE);
            }
            bookseats_row.setText("");
            bookseats_seatFrom.setText("");
            bookseats_seatTill.setText("");
            bookseats_openRows.setText(((Show)bookseats_shows.getValue()).getTheatre().getAllOpenSeats());
        }
    }

    @FXML
    public void cancelreservation_submit(Event arg0){
        Client client = null;

        if(cancelreservation_phoneNumber.getText().length() > 0){
            client = system.getClient(cancelreservation_phoneNumber.getText());
        }
        else if(cancelreservation_lastName.getText().length() > 0){
            client = system.getClient(cancelreservation_firstName.getText(), cancelreservation_lastName.getText());
        }

        if(client != null){
            cancelreservation_phoneNumber.setText(client.getPhonenumber());
            cancelreservation_firstName.setText(client.getFirstname());
            cancelreservation_lastName.setText(client.getLastname());
            cancelreservation_bookedMovie.setItems(FXCollections.observableArrayList(system.getReservations(client.getPhonenumber())));
            cancelreservation_bookedMovie.setValue(cancelreservation_bookedMovie.getItems().get(0));
        }
        else{
            cancelreservation_bookedMovie.setItems(FXCollections.observableArrayList(new ArrayList<Show>()));
            JOptionPane.showMessageDialog(null, "No client was found", "Wrong name or number", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @FXML
    public void cancelreservation_cancel(Event arg0){
        Client clientToCancel =  system.getClient(cancelreservation_phoneNumber.getText());
        if(clientToCancel != null && cancelreservation_bookedMovie.getItems().size() > 0){
            system.cancelReservation(clientToCancel.getPhonenumber(), (Show)cancelreservation_bookedMovie.getValue());
        }
        cancelreservation_submit(null);
        system.save();
    }

    @FXML
    public void manageshows_delete(Event arg0){
        if(manageshows_show.getItems().size() > 0)
            system.getShows().remove(manageshows_show.getValue());
        system.save();
        goToManageShows(null);
    }

    @FXML
    public void manageshows_getReservations(Event arg0){
        manageshows_reservations.setText(system.getReservations((Show)manageshows_show.getValue()));
    }

    @FXML
    private void initialize(){
        if(isFirstInitialize)
            isFirstInitialize = false;
        else{
            if(bookseats_shows != null){
                //Bookseats
                bookseats_shows.setItems(FXCollections.observableArrayList(system.getShows()));
                bookseats_shows.setValue(bookseats_shows.getItems().get(0));
                bookseats_openRows.setText(((Show)bookseats_shows.getValue()).getTheatre().getAllOpenSeats());
            }
            if(addshow_title != null){
                //Add show
                addshow_theatre.setItems(FXCollections.observableArrayList(system.getTheatres()));
                addshow_theatre.setValue(addshow_theatre.getItems().get(0));
                addshow_film.setItems(FXCollections.observableArrayList(system.getAllCurrentMovies()));
                addshow_film.setValue(addshow_film.getItems().get(0));
            }
            if(manageshows_show != null){
                if(system.getShows().size() > 0) {
                    manageshows_show.setItems(FXCollections.observableArrayList(system.getShows()));
                    manageshows_show.setValue(manageshows_show.getItems().get(0));
                    manageshows_reservations.setText(system.getReservations((Show) manageshows_show.getValue()));
                }
            }
        }
    }
}
