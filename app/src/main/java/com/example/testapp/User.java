package com.example.testapp;

public class User {

    private int ID;
    private String FirstName;
    private String LastName;
    private String Email;



    public User(int fID, String fName, String lName, String fEmail){
        ID = fID;
        FirstName = fName;
        LastName = lName;
        Email = fEmail;
    }

    public int getID() {
        return ID;
    }

    public String getFirstName() {
        return FirstName;
    }


    public String getLastName() {
        return LastName;
    }


    public String getEmail() {
        return Email;
    }

}
