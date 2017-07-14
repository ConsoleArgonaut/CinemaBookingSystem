package System;

import java.io.Serializable;

/**
 * Created by Michael on 23.06.2017.
 */
public class Movie implements Serializable {
    /*Properties*/
    public String title;
    public String description;
    public String trailer;
    public int length;

    public Movie(){
        title = "";
        description = "";
        trailer = "";
        length = 0;
    }

    public Movie(String movieTitle, String movieDescription, int movieLength, String movieTrailer){
        title = movieTitle;
        description = movieDescription;
        trailer = movieTrailer;
        length = movieLength;
    }

    @Override
    /*Returns movie title if toString is executed*/
    public String toString() {
        return title;
    }
}
