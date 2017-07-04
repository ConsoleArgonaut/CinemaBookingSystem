package System;

import java.io.Serializable;

/**
 * Created by Michael on 23.06.2017.
 */
public class Seat implements Serializable {
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

    public Seat copy(){
        Seat copy = new Seat();
        copy.setRownumber(rownumber);
        copy.setSeatnumber(seatnumber);
        copy.setClient(null);
        return copy;
    }

    public Seat(){
        seatnumber = 0;
        rownumber = 0;
        client = null;
    }

    public Seat(int rownumberToSet, int seatnumberToSet){
        seatnumber = seatnumberToSet;
        rownumber = rownumberToSet;
    }
}
