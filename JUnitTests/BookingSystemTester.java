import org.junit.Assert;
import org.junit.Test;
import System.*;

import java.sql.Date;

import static org.junit.Assert.*;

/**
 * Created by Michael on 04.07.2017.
 */
public class BookingSystemTester {
    @Test
    public void bookSeats() throws Exception {

    }

    @Test
    public void cancelReservation() throws Exception {

    }

    @Test
    public void addShow() throws Exception {

    }

    @Test
    public void getReservations() throws Exception {

    }

    @Test
    public void getReservations1() throws Exception {

    }

    @Test
    public void getReservations2() throws Exception {

    }

    @Test
    public void getClient() throws Exception {

    }

    @Test
    public void saveAndLoad() {
        BookingSystem system = new BookingSystem();
        //Creates a theatre with 2 seats and adds it to the system
        Theatre theatre = new Theatre();
        theatre.setTheatrenumber("123");
        Seat[] seats = new Seat[2];
        seats[0] = new Seat();
        seats[0].setSeatnumber(1);
        seats[0].setRownumber(1);
        seats[1] = new Seat();
        seats[1].setSeatnumber(2);
        seats[1].setRownumber(1);
        theatre.setSeats(seats);
        system.getTheatres().add(theatre);
        //Creates 2 test shows
        Show show1 = new Show();
        Movie movie = new Movie();
        movie.description = "test";
        movie.lenght= 20;
        movie.title = "Testikus";
        show1.setMovie(movie);
        show1.setStartTime(Date.valueOf("2007-12-25"));
        show1.setTheatre(theatre.copy());
        Show show2 = new Show();
        show2.setMovie(movie);
        show2.setStartTime(Date.valueOf("2007-12-26"));
        show2.setTheatre(theatre.copy());
        system.getShows().add(show1);
        system.getShows().add(show2);

        //Saves
        system.save();

        //Loads
        BookingSystem systemLoaded = new BookingSystem();
        systemLoaded.load();
        //Checks some values to see if saving was successful
        Assert.assertEquals(systemLoaded.getShows().get(0).getMovie().title, "Testikus");
        Assert.assertEquals(systemLoaded.getShows().get(1).getStartTime(), Date.valueOf("2007-12-26"));
        Assert.assertEquals(systemLoaded.getTheatres().get(0).getSeats().length, 2);
    }
}