package System;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Michael on 23.06.2017.
 */
public class Show implements Serializable {
    /*Properties*/
    private Movie movie;
    private Date startTime;
    private Theatre theatre;

    /*Getter for movie*/
    public Movie getMovie() {
        return movie;
    }

    /*Setter for movie*/
    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    /*Getter for startTime*/
    public Date getStartTime() {
        return startTime;
    }

    /*Setter for startTime*/
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /*Getter for theatre*/
    public Theatre getTheatre() {
        return theatre;
    }

    /*Setter for theatre*/
    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
    }

    public Show(){
        movie = null;
        startTime = null;
        theatre = null;
    }

    public Show(Movie showMovie, Date showStartTime, Theatre showTheatre){
        movie = showMovie;
        startTime = showStartTime;
        theatre = showTheatre;
    }

    @Override
    /*Returns the time, movie title and theatre number if toString is executed*/
    public String toString() {
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        return df.format(this.startTime) + " | " + this.movie.title + " | " + this.theatre.getTheatrenumber();
    }
}
