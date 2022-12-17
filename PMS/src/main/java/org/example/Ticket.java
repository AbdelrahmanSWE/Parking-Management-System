package org.example;
import java.util.Date;

//class Ticket is resposable for dealing the Ticket info (getters and setters)
public class Ticket {
    private int EntryID;
    private String carModel;
    private String PlateNumber;
    private String TransactionDate;
    private ParkingSpot ParkingSpot;
    private static double costPerHour=100;  //<<< it is static so we can easily change the rate every where


    //constructor for the ticket class
    public Ticket(int EntryID,String PlateNumber,String TransactionDate,ParkingSpot ParkingSpot,String carModel){
        this.EntryID=EntryID;
        this.PlateNumber=PlateNumber;
        this.TransactionDate=TransactionDate;
        this.ParkingSpot=ParkingSpot;
        this.carModel=carModel;
    }

    public static double getCostPerHour() {
        return costPerHour;
    }

    public static void setCostPerHour(double costPerHour) {
        Ticket.costPerHour = costPerHour;
    }

    public int getEntryID() {
        return EntryID;
    }

    public void setEntryID(int entryID) {
        this.EntryID = entryID;
    }

    public String getPlateNumber() {
        return PlateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.PlateNumber = plateNumber;
    }

    public String getTransactionDate() {
        return TransactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.TransactionDate = transactionDate;
    }

    public ParkingSpot getParkingSpot() {
        return ParkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.ParkingSpot = parkingSpot;
    }
}
