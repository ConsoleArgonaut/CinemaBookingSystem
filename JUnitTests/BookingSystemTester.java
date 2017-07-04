import org.junit.Assert;
import org.junit.Test;
import System.*;

import java.sql.Date;

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
        //Gets Default System
        BookingSystem system = createDefaultCinema();

        //Saves
        system.save();

        //Loads
        BookingSystem systemLoaded = new BookingSystem();
        systemLoaded.load();

        //Checks some values to see if saving was successful
        Assert.assertEquals(systemLoaded.getShows().get(0).getMovie().title, system.getShows().get(0).getMovie().title);
        Assert.assertEquals(systemLoaded.getShows().get(1).getStartTime(), system.getShows().get(1).getStartTime());
        Assert.assertEquals(systemLoaded.getTheatres().get(0).getSeats().length, system.getTheatres().get(0).getSeats().length);
    }

    private BookingSystem createDefaultCinema(){
        BookingSystem cinema = new BookingSystem();
        cinema.getTheatres().add(new Theatre("Theatre 1", new Seat[] {new Seat(1, 1), new Seat(1, 2), new Seat(1, 3), new Seat(2, 1), new Seat(2, 2), new Seat(2, 3)}));
        cinema.getTheatres().add(new Theatre("Theatre 2", new Seat[] {new Seat(1, 1), new Seat(1, 2), new Seat(1, 3), new Seat(2, 1), new Seat(2, 2), new Seat(2, 3)}));
        cinema.getTheatres().add(new Theatre("Theatre 3 - Kids", new Seat[] {new Seat(1, 1), new Seat(1, 2), new Seat(1, 3)}));
        cinema.getShows().add(new Show(new Movie("RoboCop", "Der Polizist Alex Murphy wird bei einem Einsatz brutal ermordet und erwacht im Körper eines Roboters zu neuem Leben.", 103, "https://www.youtube.com/watch?v=zbCbwP6ibR4"), Date.valueOf("2018-08-25"), cinema.getTheatres().get(0).copy()));
        cinema.getShows().add(new Show(new Movie("Die Hochzeits-Crasher", "Die Hochzeits-Crasher ist eine Filmkomödie des Regisseurs David Dobkin aus dem Jahre 2005 mit Owen Wilson und Vince Vaughn.", 123, "https://www.youtube.com/watch?v=pMmz4IZTjq8"), Date.valueOf("2018-12-07"), cinema.getTheatres().get(1).copy()));
        cinema.getShows().add(new Show(new Movie("High School Musical", "High School Musical ist ein US-amerikanischer Musical-Fernsehfilm der Walt Disney Company aus dem Jahr 2006.", 98, "https://www.youtube.com/watch?v=ukDLkkvZYFk"), Date.valueOf("2018-02-13"), cinema.getTheatres().get(2).copy()));
        return cinema;
    }
}