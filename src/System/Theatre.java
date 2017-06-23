package System;

/**
 * Created by Michael on 23.06.2017.
 */
public class Theatre {
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
}

