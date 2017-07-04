package System;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Michael on 23.06.2017.
 */
public class Show implements Serializable {
    private Movie movie;

    private Date startTime;

    private Theatre theatre;

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Theatre getTheatre() {
        return theatre;
    }

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
}
