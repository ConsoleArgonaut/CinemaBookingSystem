package System;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Created by Michael on 23.06.2017.
 */
public class BookingSystem {
    /*Properties*/
    private ArrayList<Show> shows = new ArrayList<Show>();
    private ArrayList<Theatre> theatres = new ArrayList<Theatre>();

    /*Gets all movies from the different shows*/
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

    /*Books a seat for a client*/
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

    /*Cancels a reservation by searching for the phone number*/
    public void cancelReservation(String phonenumber, Show show) {
        for (Seat s : show.getTheatre().getSeats()) {
            if (s.getClient() != null && s.getClient().getPhonenumber().trim().equals(phonenumber))
                s.setClient(null);
        }
    }

    /*Adds a show*/
    public void addShow(Show show) {
        shows.add(show);
    }

    /*Setter for shows*/
    public void setShows(ArrayList<Show> shows) {
        this.shows = shows;
    }

    /*Getter for shows*/
    public ArrayList<Show> getShows() {
        return shows;
    }

    /*Getter for theatres*/
    public ArrayList<Theatre> getTheatres() {
        return theatres;
    }

    /*Setter for theatres*/
    public void setTheatres(ArrayList<Theatre> theatres) {
        this.theatres = theatres;
    }

    /*Returns all shows with a seat booked with a specific phone number*/
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

    /*Returns all shows with a seat booked with a specific client*/
    public ArrayList<Show> getReservations(Client client) {
        return getReservations(client.getPhonenumber());
    }

    /*Returns all shows with a seat booked with a specific first and last name*/
    public ArrayList<Show> getReservations(String firstName, String lastName) {
        return getReservations(getClient(firstName, lastName));
    }

    /*Returns a client (if existing), searches for it with a specific first and last name*/
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

    /*Returns a client (if existing), searches for it with a specific phone number*/
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

    /*Saves the current data*/
    public void save(){
        FileWriter writer = new FileWriter();
        writer.serializeCinema(shows, theatres);
    }

    /*Loads the current data*/
    public void load(){
        FileWriter writer = new FileWriter();
        SavingObject savObject = writer.deserialzeCinema();
        shows = savObject.shows;
        theatres = savObject.theatres;
    }

    /*Returns all reservations of a show as a String*/
    public String getReservations(Show show){
        String returnValue = "Reservations:";

        for (Seat s:show.getTheatre().getSeats()) {
            if(s.getClient() != null)
                returnValue = returnValue + "\n" + String.valueOf(s.getRownumber()) + "-" + String.valueOf(s.getSeatnumber()) + ": " + s.getClient().getPhonenumber() + ", " + s.getClient().getFirstname() + " " + s.getClient().getLastname();
        }

        return returnValue;
    }
}
