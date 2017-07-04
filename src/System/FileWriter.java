package System;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Michael on 04.07.2017.
 */
public class FileWriter {

    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public FileWriter(){
        path = "C:\\temp\\cinema.ser";
    }

    public FileWriter(String outputPath){
        path = outputPath;
    }

    public void serializeCinema(ArrayList<Show> shows, ArrayList<Theatre> theatres) {
        SavingObject savObject = new SavingObject(shows, theatres);
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(savObject);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

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
