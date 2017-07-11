package System;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Created by Michael on 23.06.2017.
 */
public class BookingSystem {
    private ArrayList<Show> shows = new ArrayList<Show>();
    private ArrayList<Theatre> theatres = new ArrayList<Theatre>();

    public ArrayList<Movie> getAllCurrentMovies() {
        ArrayList<Movie> movies = new ArrayList<Movie>();
        for (Show s : shows) {
            if (movies.size() == 0)
                movies.add(s.getMovie());
            else if (!movies.contains(s.getMovie()))
                movies.add(s.getMovie());
        }

        return movies;
    }

    public void bookSeats(Client client, Show show, int rownumber, int seatnumberFrom, int seatnumberTo) {
        if (!shows.contains(show))
            throw new IllegalArgumentException("Show does not exists");
        else {
            ArrayList<Seat> usedSeats = new ArrayList<Seat>();
            for (Seat s : show.getTheatre().getSeats()) {
                if (s.getRownumber() == rownumber && seatnumberFrom <= s.getSeatnumber() && seatnumberTo >= s.getSeatnumber()) {
                    if (s.getClient() != null)
                        throw new IllegalArgumentException("Some seats already taken");
                    else
                        usedSeats.add(s);
                }
            }
            for (Seat s : usedSeats) {
                s.setClient(client);
            }
        }
    }

    public void cancelReservation(String phonenumber, Show show) {
        for (Seat s : show.getTheatre().getSeats()) {
            if (s.getClient() != null && s.getClient().getPhonenumber().trim().equals(phonenumber))
                s.setClient(null);
        }
    }

    public void addShow(Show show) {
        shows.add(show);
    }

    public void setShows(ArrayList<Show> shows) {
        this.shows = shows;
    }

    public ArrayList<Show> getShows() {
        return shows;
    }

    public ArrayList<Theatre> getTheatres() {
        return theatres;
    }

    public void setTheatres(ArrayList<Theatre> theatres) {
        this.theatres = theatres;
    }

    public ArrayList<Show> getReservations(String phonenumber) {
        ArrayList<Show> showsToReturn = new ArrayList<Show>();
        phonenumber = phonenumber.trim();
        for (Show show : shows) {
            for (Seat seat : show.getTheatre().getSeats()) {
                if(!showsToReturn.contains(show) && seat.getClient() != null && seat.getClient().getPhonenumber().trim().equals(phonenumber))
                    showsToReturn.add(show);
            }
        }
        return showsToReturn;
    }

    public ArrayList<Show> getReservations(Client client) {
        return getReservations(client.getPhonenumber());
    }

    public ArrayList<Show> getReservations(String firstName, String lastName) {
        return getReservations(getClient(firstName, lastName));
    }

    public Client getClient(String firstName, String lastName) {
        Client client = null;
        for (Show show : shows) {
            for (Seat seat : show.getTheatre().getSeats()) {
                if(client == null && seat.getClient() != null && seat.getClient().getFirstname().trim().equals(firstName.trim()) && seat.getClient().getLastname().trim().equals(lastName.trim()))
                    client = seat.getClient();
            }
        }
        return client;
    }

    public Client getClient(String phonenumber) {
        Client client = null;
        for (Show show : shows) {
            for (Seat seat : show.getTheatre().getSeats()) {
                if(client == null && seat.getClient() != null &&  seat.getClient().getPhonenumber().trim().equals(phonenumber.trim()))
                    client = seat.getClient();
            }
        }
        return client;
    }

    public void save(){
        FileWriter writer = new FileWriter();
        writer.serializeCinema(shows, theatres);
    }

    public void load(){
        FileWriter writer = new FileWriter();
        SavingObject savObject = writer.deserialzeCinema();
        shows = savObject.shows;
        theatres = savObject.theatres;
    }

    public String getReservations(Show show){
        String returnValue = "Reservations:";

        for (Seat s:show.getTheatre().getSeats()) {
            if(s.getClient() != null)
                returnValue = returnValue + "\n" + String.valueOf(s.getRownumber()) + "-" + String.valueOf(s.getSeatnumber()) + ": " + s.getClient().getPhonenumber() + ", " + s.getClient().getFirstname() + " " + s.getClient().getLastname();
        }

        return returnValue;
    }
}
