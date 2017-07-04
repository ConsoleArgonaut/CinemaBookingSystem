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
        return copy;
    }

    public Theatre(){
        theatrenumber = "";
        seats = new Seat[0];
    }

    public Theatre(String theatrenumberToSet, Seat[] seatsToSet){
        theatrenumber = theatrenumberToSet;
        seats = seatsToSet;
    }

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
}

