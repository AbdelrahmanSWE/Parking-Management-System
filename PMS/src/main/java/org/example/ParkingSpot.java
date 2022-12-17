package org.example;


//this class is responsable for dealing with the parking spots such as geting and setting there names
//or their occupience status
public class ParkingSpot {
    private String SpotName;
    private boolean Occupied=false;


    //constructor for the Parking spot class
    public  ParkingSpot(String SpotName){

        this.SpotName=SpotName;
    }

    public String getSpotName() {
        return SpotName;
    }

    public void setSpotName(String spotName) {
        this.SpotName = spotName;
    }

    public boolean getOccupied() {
        return Occupied;
    }

    public void setOccupied(boolean occupied) {
        this.Occupied = occupied;
    }
}

