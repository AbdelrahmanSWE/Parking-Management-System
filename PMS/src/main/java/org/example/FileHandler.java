package org.example;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

//File handler is the class responsable for handling file operations such as creating and deleting files,writing or
//reading from files ,and other methods too

class FileHandler
{
    private String filePath;
    private File file;

    //Constructor for fileHandler class
    public FileHandler(String filePath)
    {
        this.filePath = filePath;
        this.file = new File(filePath);

    }


    //method for Creating a new file
    public boolean createFile()
    {

        try{
            if(file.createNewFile()){
                System.out.println("Entry is Created");
                return true;
            }

            else{
                System.out.println("Entry already Exists");
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return false;
    }


    //method that is used to write data to a file
    public void writeToFile(String data)
    {
        try
        {

            FileWriter fw = new FileWriter(file,true);
            fw.append(data);
            fw.close();

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }


    //method that is used to read data from a file
    public void readFromFile()
    {
        try{
            Scanner fr = new Scanner(file);
            String name;
            while(fr.hasNextLine())
            {
                name = fr.nextLine();
                System.out.println(name);
            }

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }


    //method to delete a file
    public void deleteFile(){
        try{
            if (file.delete()){
                System.out.println("Deleted Entry Successfully");
            }else{
                System.out.println("Failed To Delete Entry");
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    //???????
    public ParkingSpot[] retrieveGarageFiles(){
        File paths=new File("ParkingSpots");
        File[]pathsArr=paths.listFiles();
        ParkingSpot[] ParkingSpots = new ParkingSpot[pathsArr.length];
        for (int i=0;i<pathsArr.length;i++) {
            Scanner fr = null;
            try {
                fr = new Scanner(pathsArr[i]);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            String[] name = pathsArr[i].getName().split("\\.", 2);
            Boolean Occupied = Boolean.parseBoolean(fr.nextLine());
            ParkingSpots[i] = new ParkingSpot(name[0]);
            ParkingSpots[i].setOccupied(Occupied);
        }
        return ParkingSpots;
    }
    public ParkingSpot[] printGarageFiles(){
        File paths=new File("ParkingSpots");
        File[]pathsArr=paths.listFiles();
        ParkingSpot[] ParkingSpots = new ParkingSpot[pathsArr.length];
        for (int i=0;i<pathsArr.length;i++) {
            Scanner fr = null;
            try {
                fr = new Scanner(pathsArr[i]);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            String[] name = pathsArr[i].getName().split("\\.", 2);
            System.out.println(name[0]);
            Boolean Occupied = Boolean.parseBoolean(fr.nextLine());
            System.out.println(Occupied);

            ParkingSpots[i] = new ParkingSpot(name[0]);
            ParkingSpots[i].setOccupied(Occupied);
        }
        return ParkingSpots;
    }
    public Customer retrieveFromFile(int ID){
        File paths=new File("Customer//");
        File[]pathsArr=paths.listFiles();
        for (int i=0;i<pathsArr.length;i++) {
            Scanner fr = null;
            try {
                fr = new Scanner(pathsArr[i]);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            fr.nextLine();
            int FID = fr.nextInt();

            if (ID == FID) {

                return new Customer(FID,fr.nextLine(), fr.nextLine(), fr.nextLine(),fr.nextLine());
            }
        }
        return null;
    }
    public EntryStation retrieveFromFile(String Username){
        File paths=new File("Operator//EntryStation");
        File[]pathsArr=paths.listFiles();
        for (int i=0;i<pathsArr.length;i++) {
            Scanner fr = null;
            try {
                fr = new Scanner(pathsArr[i]);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            fr.nextLine();
            int FID = fr.nextInt();
            String name= fr.nextLine();
            name=fr.nextLine();
            String user= fr.nextLine();
            System.out.println(user);
            if (Username.equals(user)) {
                return new EntryStation(FID,name, user, fr.nextLine(),fr.nextLine(),fr.nextDouble());
            }
        }
        return null;
    }

    public Admin retrieveFromFile(String Username, int AdminType){
        File paths=new File("Admin//");
        File[]pathsArr=paths.listFiles();
        for (int i=0;i<pathsArr.length;i++) {
            Scanner fr = null;
            try {
                fr = new Scanner(pathsArr[i]);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            fr.nextLine();
            int FID = fr.nextInt();
            String name= fr.nextLine();
            name=fr.nextLine();
            String user= fr.nextLine();
            System.out.println(user);
            if (Username.equals(user)) {
                return new Admin(FID,name, user, fr.nextLine());
            }
        }
        return null;
    }
    public ExitStation retrieveFromFile(String Username,String type){
        File paths=new File("Operator//ExitStation");
        File[]pathsArr=paths.listFiles();
        for (int i=0;i<pathsArr.length;i++) {
            Scanner fr = null;
            try {
                fr = new Scanner(pathsArr[i]);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            fr.nextLine();
            int FID = fr.nextInt();
            fr.nextLine();
            String name=fr.nextLine();
            String user= fr.nextLine();
            System.out.println(user);
            if (Username.equals(user)) {
                return new ExitStation(FID,name, user, fr.nextLine(),fr.nextLine(),fr.nextDouble());
            }
        }
        return null;
    }

    public boolean checkCustomerTicket(int ID){
        File paths=new File("ActiveTickets");
        File[]pathsArr=paths.listFiles();
        if (pathsArr==null)
            return false;
        for (int i=0;i<pathsArr.length;i++) {
            Scanner fr = null;
            try {
                fr = new Scanner(pathsArr[i]);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            fr.nextLine();
            int FID = fr.nextInt();
            if (ID == FID) {
                fr.close();
                return true;
            }
        }
        return false;
    }
}


