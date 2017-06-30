package System;

import java.util.ArrayList;

/**
 * Created by Michael on 23.06.2017.
 */
public class BookingSystem {
    private ArrayList<Show> shows;
    private ArrayList<Theatre> theatres;

    public Movie[] getAllCurrentMovies() {
        ArrayList<Movie> movies = new ArrayList<Movie>();
        for (Show s : shows) {
            if (movies.size() == 0)
                movies.add(s.getMovie());
            else if (!movies.contains(s.getMovie()))
                movies.add(s.getMovie());
        }

        return (Movie[]) movies.toArray();
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
            if (s.getClient().getPhonenumber() == phonenumber)
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
        for (Show show : shows) {
            for (Seat seat : show.getTheatre().getSeats()) {
                if(showsToReturn.contains(show) && seat.getClient().getPhonenumber() == phonenumber)
                    showsToReturn.add(show);
            }
        }
        return showsToReturn;
    }

    public ArrayList<Show> getReservations(Client client) {
        return getReservations(client.getPhonenumber());
    }

    public Client getClient(String firstName, String lastName) {
        Client client = null;
        for (Show show : shows) {
            for (Seat seat : show.getTheatre().getSeats()) {
                if(client == null && seat.getClient().getFirstname() == firstName && seat.getClient().getLastname() == lastName)
                    client = seat.getClient();
            }
        }
        return client;
    }
}
