package org.example;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

//class Customer is responsible for all functions related to the customer such as
//Printing a ticket ,Paying a ticket , it also extends to the abstract class person
public class Customer extends Person {
    private String CarModel;
    private String PlateNumber;


    public Customer(int ID, String Name, String Username,String carModel,String plateNumber) { //constructor for the Customer class
        super(ID, Name, Username);
        this.CarModel=carModel;
        this.PlateNumber=plateNumber;

    }



    public void setCarModel(String carModel) {
        this.CarModel = carModel;
    }

    public String getCarModel() {
        return CarModel;
    }

    public void setPlateNumber(String plateNumber) {
        this.PlateNumber = plateNumber;
    }

    public String getPlateNumber() {
        return PlateNumber;
    }


    //puts the customer info in its own file for easy access later
    public Ticket printTicket (int EntryID,ParkingSpot ParkingSpot){
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date TransactionDate=new Date();
        Ticket createTicket;
        FileHandler ticketCreation = new FileHandler("ActiveTickets//"+this.getID()+".txt");
        if (ticketCreation.createFile()) {
            createTicket=new Ticket(EntryID,this.PlateNumber,format.format(TransactionDate),ParkingSpot,this.CarModel);
            ticketCreation.writeToFile("\n" + EntryID);
            ticketCreation.writeToFile("\n" + this.PlateNumber);
            System.out.println(format.format(TransactionDate));
            ticketCreation.writeToFile("\n" + format.format(TransactionDate));
            ticketCreation.writeToFile("\n" + ParkingSpot.getSpotName());
            ticketCreation.writeToFile("\n" + this.CarModel);
            return createTicket;
        }
        return null;
    }

    //returns the amount for the customer(payment),by multiplying hours spent which is a static method from the ExitOperator Class, by costPerHour which
    //we get from Ticket Class
    public double payTicket(Double hoursSpent){
        double payment=hoursSpent*Ticket.getCostPerHour();
        String path="ActiveTickets//"+this.getID()+".txt";
        File file=new File(path);
        Scanner fr=null;
        try {
            fr = new Scanner(file);
        }catch (Exception e){

        }
        fr.nextLine();
        fr.nextLine();
        fr.nextLine();
        fr.nextLine();
        String spot=fr.nextLine();
        fr.close();


        File changeOccupied=new File("ParkingSpots//"+spot+".txt");
        if(changeOccupied.exists()) {
            FileWriter fw = null;
            try {
                fw = new FileWriter(changeOccupied);
                fw.write("false");
                fw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        FileHandler ticketPaid=new FileHandler("ActiveTickets//"+this.getID()+".txt");
        ticketPaid.deleteFile();

        return payment;
    }



    //Method for Customer login using his ID
    public boolean login(String ID) {
        File file=new File("Operator//EntryStation//"+ID+".txt");
        if (file.exists()) {
            return true;
        }
        return false;
    }
}
