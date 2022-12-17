package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.*;
import java.util.Date;
import java.util.Scanner;
import java.util.TimeZone;

public class ExitStation extends Operator implements AccountMethods{
    //Class Exit station responsible for function calculating parking hours
    //also it extends the abstract class PERSON

    //constructors For exitStation class
    public ExitStation(int ID, String Name, String Username, String Password, String Shifts, Double Salary) {
        super(ID, Name, Username, Password, Shifts, Salary);
    }

    public ExitStation(String Username,String Password){
        super(Username,Password);
    }

    public static double calculateParkingHours(int ID){
        String path="ActiveTickets//"+ID+".txt";
        File pathToTicket=new File(path);
        Scanner fr=null;
        try {
            fr = new Scanner(pathToTicket);
        }catch (Exception e){

        }
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm");
        fr.nextLine();
        fr.nextLine();
        fr.nextLine();
        Date EntranceDate = null;
        try {
            EntranceDate = format.parse(fr.nextLine());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        fr.close();

        Date current=new Date();
        double difference=current.getTime()-EntranceDate.getTime();
        double hours = difference / (1000 * 60 * 60);
        System.out.println("Hours spent: "+hours);
        return hours;
    }

    //This method implements the Interface class [AccountMethods]
    //It  allows the exit station employee to log in with there account
    @Override
    public boolean login(String Username, String Password) {
        File file=new File("Operator//ExitStation//"+Username+".txt");
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
