package System;

import java.io.Serializable;

/**
 * Created by Michael on 23.06.2017.
 */
public class Client implements Serializable {
    private String firstname;

    private String lastname;

    private String phonenumber;

    public Client(){
        firstname = "";
        lastname = "";
        phonenumber = "";
    }

    public Client(String firstnameToSet, String lastnameToSet, String phonenumberToSet){
        firstname = firstnameToSet;
        lastname = lastnameToSet;
        phonenumber = phonenumberToSet;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
}
