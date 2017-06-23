package System;

/**
 * Created by Michael on 23.06.2017.
 */
public class Seat {
    private int seatnumber;

    private int rownumber;

    private Client client;

    public int getSeatnumber() {
        return seatnumber;
    }

    public void setSeatnumber(int seatnumber) {
        this.seatnumber = seatnumber;
    }

    public int getRownumber() {
        return rownumber;
    }

    public void setRownumber(int rownumber) {
        this.rownumber = rownumber;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
