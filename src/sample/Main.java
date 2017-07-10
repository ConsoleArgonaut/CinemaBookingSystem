package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import System.*;

import java.sql.Date;

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

        system.getTheatres().add(new Theatre("Theatre 1", new Seat[] {new Seat(1, 1), new Seat(1, 2), new Seat(1, 3), new Seat(2, 1), new Seat(2, 2), new Seat(2, 3)}));
        system.getTheatres().add(new Theatre("Theatre 2", new Seat[] {new Seat(1, 1), new Seat(1, 2), new Seat(1, 3), new Seat(2, 1), new Seat(2, 2), new Seat(2, 3)}));
        system.getTheatres().add(new Theatre("Theatre 3 - Kids", new Seat[] {new Seat(1, 1), new Seat(1, 2), new Seat(1, 3)}));
        system.getShows().add(new Show(new Movie("RoboCop", "Der Polizist Alex Murphy wird bei einem Einsatz brutal ermordet und erwacht im Körper eines Roboters zu neuem Leben.", 103, "https://www.youtube.com/watch?v=zbCbwP6ibR4"), Date.valueOf("2018-08-25"), system.getTheatres().get(0).copy()));
        system.getShows().add(new Show(new Movie("Die Hochzeits-Crasher", "Die Hochzeits-Crasher ist eine Filmkomödie des Regisseurs David Dobkin aus dem Jahre 2005 mit Owen Wilson und Vince Vaughn.", 123, "https://www.youtube.com/watch?v=pMmz4IZTjq8"), Date.valueOf("2018-12-07"), system.getTheatres().get(1).copy()));
        system.getShows().add(new Show(new Movie("High School Musical", "High School Musical ist ein US-amerikanischer Musical-Fernsehfilm der Walt Disney Company aus dem Jahr 2006.", 98, "https://www.youtube.com/watch?v=ukDLkkvZYFk"), Date.valueOf("2018-02-13"), system.getTheatres().get(2).copy()));

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
    @FXML private TextField addshow_description = new TextField();
    @FXML private TextField addshow_duration = new TextField();
    @FXML private TextField addshow_trailer = new TextField();

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
    public void addshow_save(Event arg0){}

    @FXML
    public void bookseats_select(Event arg0){}

    @FXML
    public void bookseats_submit(Event arg0){}

    @FXML
    public void cancelreservation_submit(Event arg0){}

    @FXML
    public void cancelreservation_cancel(Event arg0){}

    @FXML
    private void initialize(){
        if(isFirstInitialize)
            isFirstInitialize = false;
        else{
            if(bookseats_openRows != null)
                bookseats_openRows.setText(String.valueOf("Row 1: x"));
            if(bookseats_shows != null){
                bookseats_shows.setItems(FXCollections.observableArrayList(system.getShows()));
                bookseats_shows.setValue(system.getShows().get(0));
            }
        }
    }
}
