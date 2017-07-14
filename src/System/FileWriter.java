package System;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Michael on 04.07.2017.
 */
public class FileWriter {

    /*Properties*/
    private String path;

    /*Getter for path*/
    public String getPath() {
        return path;
    }

    /*Setter for path*/
    public void setPath(String path) {
        this.path = path;
    }

    /*Initializes FileWriter with default path*/
    public FileWriter(){
        path = "C:\\temp\\cinema.ser";
    }

    /*Initializes FileWriter with wished path*/
    public FileWriter(String outputPath){
        path = outputPath;
    }

    /*Saves all cinema data to selected path*/
    public void serializeCinema(ArrayList<Show> shows, ArrayList<Theatre> theatres) {
        SavingObject savObject = new SavingObject(shows, theatres);
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(savObject);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /*Loads all cinema data from selected path*/
    public SavingObject deserialzeCinema() {
        SavingObject savObject = null;
        try (ObjectInputStream ois
                     = new ObjectInputStream(new FileInputStream(path))) {
            savObject = (SavingObject) ois.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return savObject;
    }
}
