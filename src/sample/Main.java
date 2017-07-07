package sample;

import javafx.application.Application;
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

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("starter.fxml"));
        primaryStage.setTitle("Booking System");
        primaryStage.setScene(new Scene(root, 900, 600));
        primaryStage.setResizable(false);
        primaryStage.show();
        PrimaryStage = primaryStage;
    }

    /*Properties*/
    private static BookingSystem system;

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
        if(bookseats_openRows != null)
            bookseats_openRows.setText(String.valueOf("Row 1: x"));
    }
}
