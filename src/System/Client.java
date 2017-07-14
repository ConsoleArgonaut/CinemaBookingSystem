package System;

import java.io.Serializable;

/**
 * Created by Michael on 23.06.2017.
 */
public class Client implements Serializable {
    /*Properties*/
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

    /*Getter for firstname*/
    public String getFirstname() {
        return firstname;
    }

    /*Setter for firstname*/
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /*Getter for lastname*/
    public String getLastname() {
        return lastname;
    }

    /*Setter for lastname*/
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /*Getter for phonenumber*/
    public String getPhonenumber() {
        return phonenumber;
    }

    /*Setter for phonenumber*/
    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
}
