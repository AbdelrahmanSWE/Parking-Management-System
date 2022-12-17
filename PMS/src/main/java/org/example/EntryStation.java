package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//Class Entry station responsible for functions such as check free spots
//or recommending the nearest free spot , also it extends the abstract class PERSON

public class EntryStation extends Operator implements AccountMethods {


    //Constructor for the entry station class
    public EntryStation(int ID, String Name, String Username, String Password, String Shifts, Double Salary) {
        super(ID, Name, Username, Password, Shifts, Salary);
    }
    public EntryStation(String Username,String Password){
        super(Username,Password);
    }



    //checkFreeSpots is a method that uses a loop that runs through all the spots in the system and checks if they are
    //occupied or not
    public void  checkFreeSpots(ParkingSpot[]Spots){
        for(int i=0;i< Spots.length;i++){
            if (Spots[i].getOccupied()==false) {
                System.out.println("Spot "+Spots[i].getSpotName()+" is empty");
            }
            else System.out.println("Spot "+Spots[i].getSpotName()+" is not empty");
        }
    }

    //method recommendNearestFreeSpot uses the same idea as the later to recommend the nearest free spot

    public static ParkingSpot recommendNearestFreeSpot(ParkingSpot[]Spots){
        for(int i=0;i< Spots.length-1;i++){
            FileHandler viewSpots =new FileHandler("ParkingSpots//"+Spots[i]+".txt");
            if (Spots[i].getOccupied()==false) {
                System.out.println("Nearest free spot is "+Spots[i].getSpotName());
                Spots[i].setOccupied(true);
                File changeOccupied=new File("ParkingSpots//"+Spots[i].getSpotName()+".txt");
                if(changeOccupied.exists()) {
                    FileWriter fw = null;
                    try {
                        fw = new FileWriter(changeOccupied);
                        fw.write("true");
                        fw.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                return Spots[i];
            }
        }
        return null;
    }

    //This method implements the Interface class [AccountMethods]
    //It  allows the entry station employee to log in with there account

    @Override
    public boolean login(String Username, String Password) {
        File file=new File("Operator//EntryStation//"+Username+".txt");
        if (file.exists()) {
            Scanner fr = null;
            try {
                fr = new Scanner(file);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            fr.nextLine();
            fr.nextLine();
            fr.nextLine();
            fr.nextLine();
            if (Password.matches(fr.nextLine())) {
                return true;
            }
        }
        return false;


    }
}
