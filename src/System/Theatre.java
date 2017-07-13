package System;

import java.io.Serializable;

/**
 * Created by Michael on 23.06.2017.
 */
public class Theatre implements Serializable {
    /* The number of the theatre */
    private String theatrenumber;

    /* The seats located in the theatre */
    private Seat[] seats;

    /* Getter for the theatrenumber  */
    public String getTheatrenumber() {
        return theatrenumber;
    }

    /* Setter for the theatrenumber  */
    public void setTheatrenumber(String theatrenumber) {
        this.theatrenumber = theatrenumber;
    }

    /* Getter for the seats  */
    public Seat[] getSeats() {
        return seats;
    }

    /* Setter for the seats  */
    public void setSeats(Seat[] seats) {
        this.seats = seats;
    }

    /* Creates a copy of the current theatre */
    public Theatre copy(){
        Theatre copy = new Theatre();
        copy.setTheatrenumber(this.theatrenumber);
        Seat[] copySeats = new Seat[seats.length];
        for (int i = 0; i < copySeats.length; i++) {
            copySeats[i] = seats[i].copy();
        }
        copy.setSeats(copySeats);
        return copy;
    }

    /* Constructor */
    public Theatre(){
        theatrenumber = "";
        seats = new Seat[0];
    }

    /* Constructor */
    public Theatre(String theatrenumberToSet, Seat[] seatsToSet){
        theatrenumber = theatrenumberToSet;
        seats = seatsToSet;
    }

    /* Returns all Seats that were not taken by a client yet */
    public String getAllOpenSeats(){
        String openSeats = "";

        boolean rowPrinted = false;

        for (int rowNumber = 0; rowNumber < 100; rowNumber++) {
            for (int seatNumber = 0; seatNumber < 100; seatNumber++) {
                for (Seat seat:seats) {
                    if(seat.getRownumber() == rowNumber && seat.getSeatnumber() == seatNumber && seat.getClient() == null){
                        if(rowPrinted)
                            openSeats = openSeats + ", " + String.valueOf(seatNumber);
                        else
                            openSeats = openSeats + "Row " + String.valueOf(rowNumber) + ": " + String.valueOf(seatNumber);
                        rowPrinted = true;
                    }
                }
            }
            if(rowPrinted)
                openSeats = openSeats + "\n";
            rowPrinted = false;
        }

        return openSeats;
    }

    @Override
    public String toString() {
        return theatrenumber + " (Seats: " + String.valueOf(getSeats().length) + ")";
    }
}

