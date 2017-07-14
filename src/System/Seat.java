package System;

import java.io.Serializable;

/**
 * Created by Michael on 23.06.2017.
 */
public class Seat implements Serializable {
    /*Properties*/
    private int seatnumber;
    private int rownumber;
    private Client client;

    /*Getter for seatnumber*/
    public int getSeatnumber() {
        return seatnumber;
    }

    /*Setter for seatnumber*/
    public void setSeatnumber(int seatnumber) {
        this.seatnumber = seatnumber;
    }

    /*Getter for rownumber*/
    public int getRownumber() {
        return rownumber;
    }

    /*Setter for rownumber*/
    public void setRownumber(int rownumber) {
        this.rownumber = rownumber;
    }

    /*Getter for client*/
    public Client getClient() {
        return client;
    }

    /*Setter for client*/
    public void setClient(Client client) {
        this.client = client;
    }

    /*Returns a new seat with the same seat and row number*/
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
