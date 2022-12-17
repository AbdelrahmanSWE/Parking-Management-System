package org.example;

import javax.naming.Name;
import java.net.IDN;


//an abstract class that deals with all persons in the system it  extended by:..
//Admin-Entry station -Exit station- Operator and others
//and its main function is to deal with a personal info of a user like his name and such...
abstract class Person {
    private int ID;
    private String Name;
    private String Username;


    //constructors for the persson class
    public Person(int ID,String Name, String Username) {

        this.ID= ID;
        this.Name= Name;
        this.Username=Username;
    }

    public Person(String Username){
        this.Username=Username;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getUsername() {
        return Username;
    }
}
