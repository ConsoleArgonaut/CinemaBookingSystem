package sample;

import javafx.application.Application;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;

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
    private static Stage PrimaryStage;

    @FXML private Label seatOverview;

    public static void main(String[] args) {
        launch(args);
    }

    @FXML
    /*This sets starter as current scene*/
    public void goToStarter(Event arg0) {
        try{
            PrimaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("race_selection.fxml")), 900, 600));
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
}
