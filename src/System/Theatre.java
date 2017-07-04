package System;

import java.io.Serializable;

/**
 * Created by Michael on 23.06.2017.
 */
public class Theatre implements Serializable {
    private String theatrenumber;

    private Seat[] seats;

    public String getTheatrenumber() {
        return theatrenumber;
    }

    public void setTheatrenumber(String theatrenumber) {
        this.theatrenumber = theatrenumber;
    }

    public Seat[] getSeats() {
        return seats;
    }

    public void setSeats(Seat[] seats) {
        this.seats = seats;
    }

    public Theatre copy(){
        Theatre copy = new Theatre();
        copy.setTheatrenumber(this.theatrenumber);
        Seat[] copySeats = new Seat[seats.length];
        for (int i = 0; i < copySeats.length; i++) {
            copySeats[i] = seats[i].copy();
        }
        copy.setSeats(copySeats);
        return null;
    }

    public Theatre(){
        theatrenumber = "";
        seats = new Seat[0];
    }

    public Theatre(String theatrenumberToSet, Seat[] seatsToSet){
        theatrenumber = theatrenumberToSet;
        seats = seatsToSet;
    }
}

