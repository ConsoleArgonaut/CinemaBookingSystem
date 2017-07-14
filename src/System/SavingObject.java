package System;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Michael on 04.07.2017.
 * This class is used for the serialization of the cinema data
 */
public class SavingObject implements Serializable {
    /*Properties*/
    public ArrayList<Show> shows;
    public ArrayList<Theatre> theatres;

    public SavingObject(ArrayList<Show> showsToSet, ArrayList<Theatre> theatresToSet){
        shows = showsToSet;
        theatres = theatresToSet;
    }
}
