package System;

import java.util.ArrayList;

/**
 * Created by Michael on 04.07.2017.
 */
public class SavingObject {
    public ArrayList<Show> shows;
    public ArrayList<Theatre> theatres;

    public SavingObject(ArrayList<Show> showsToSet, ArrayList<Theatre> theatresToSet){
        shows = showsToSet;
        theatres = theatresToSet;
    }
}
