package org.example;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//Class admin responsible for admin functions such as adding parking
//spots or customers , also it extends to the abstract class PERSON


public class Admin extends Person implements AccountMethods {
    private String Password;

    //Constructors for admin
    public Admin(int ID, String Name, String Username,String pass) {
        super(ID, Name, Username);
        this.Password=pass;
    }
    public Admin (String username,String Pass){
        super(username);
        this.Password=Pass;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getPassword() {
        return Password;
    }



    //Method for adding new parking spots
    public void addParkingSpot(ParkingSpot ParkingSpot) {
        FileHandler createSpot = new FileHandler("ParkingSpots//"+ParkingSpot.getSpotName()+".txt");
        if(createSpot.createFile()) {
            createSpot.writeToFile("\n" + ParkingSpot.getOccupied());
        }
    }


    //Method that allows the admin to view all spots that were added by them
    public void viewAllSpots() {
        FileHandler viewer=new FileHandler("none");
        viewer.printGarageFiles();
    }


    //Method addCustomers allows the admin to add new Customers to the System
    public void addCustomer(Customer Customer) {
        FileHandler addCustomer= new FileHandler("Customer//"+Customer.getID()+".txt");
        if(addCustomer.createFile()) {
            addCustomer.writeToFile("\n" + Customer.getID());
            addCustomer.writeToFile("\n" + Customer.getName());
            addCustomer.writeToFile("\n" + Customer.getCarModel());
            addCustomer.writeToFile("\n" + Customer.getPlateNumber());
        }
    }


    //Method updateCustomer Allows the admin to Update a user's info
    public void updateCustomer(Customer Customer) {
        FileHandler updateUser = new FileHandler("Customer//"+Customer.getID()+".txt");
        updateUser.deleteFile();
        updateUser.writeToFile("\n"+Customer.getID());
        updateUser.writeToFile("\n"+Customer.getName());
        updateUser.writeToFile("\n"+Customer.getCarModel());
        updateUser.writeToFile("\n"+Customer.getPlateNumber());
    }


    //Allows admin to delete a customer from the system
    public void deleteCustomer(int ID) {
        FileHandler deleteUser = new FileHandler("Customer//"+ID+".txt");
        deleteUser.deleteFile();
    }


    //Allows the admin to add new Employee for the position  (Entry Operator)
    public void addEntryOperator(EntryStation operator){
        FileHandler addOperator = new FileHandler("Operator//EntryStation//"+operator.getUsername()+".txt");
        if(addOperator.createFile()) {
            addOperator.writeToFile("\n" + operator.getID());
            addOperator.writeToFile("\n" + operator.getName());
            addOperator.writeToFile("\n" + operator.getUsername());
            addOperator.writeToFile("\n" + operator.getPassword());
            addOperator.writeToFile("\n" + operator.getShifts());
            addOperator.writeToFile("\n" + operator.getSalary());
        }
    }


    // allows admin to update an operators info
    public void updateEntryOperator(EntryStation operator) {
        FileHandler updateOperator = new FileHandler("Operator//EntryStation//"+operator.getUsername()+".txt");
        updateOperator.deleteFile();
        updateOperator.writeToFile("\n"+operator.getID());
        updateOperator.writeToFile("\n"+operator.getName());
        updateOperator.writeToFile("\n"+operator.getUsername());
        updateOperator.writeToFile("\n"+operator.getPassword());
        updateOperator.writeToFile("\n"+operator.getShifts());
        updateOperator.writeToFile("\n"+operator.getSalary());
    }


    // allows admin to  delete  an Entry operator
    public void deleteEntryOperator(String Username) {
        FileHandler deleteUser = new FileHandler("Operator//EntryStation//"+Username+".txt");
        deleteUser.deleteFile();
    }


    //Allows the admin to add new Employee for the position  (Exit Operator)
    public void addExitOperator(ExitStation operator){
        FileHandler addOperator = new FileHandler("Operator//ExitStation//"+operator.getUsername()+".txt");
        if(addOperator.createFile()) {
            addOperator.writeToFile("\n" + operator.getID());
            addOperator.writeToFile("\n" + operator.getName());
            addOperator.writeToFile("\n" + operator.getUsername());
            addOperator.writeToFile("\n" + operator.getPassword());
            addOperator.writeToFile("\n" + operator.getShifts());
            addOperator.writeToFile("\n" + operator.getSalary());
        }
    }


    //allows admin to update an Exit operator
    public void updateExitOperator(ExitStation operator) {
        FileHandler updateOperator = new FileHandler("Operator//ExitStation//"+operator.getUsername()+".txt");
        updateOperator.deleteFile();
        updateOperator.writeToFile("\n"+operator.getID());
        updateOperator.writeToFile("\n"+operator.getName());
        updateOperator.writeToFile("\n"+operator.getUsername());
        updateOperator.writeToFile("\n"+operator.getPassword());
        updateOperator.writeToFile("\n"+operator.getShifts());
        updateOperator.writeToFile("\n"+operator.getSalary());
    }


    // allows admin to  delete  an Exit operator
    public void deleteExitOperator(String Username) {
        FileHandler deleteUser = new FileHandler("Operator//ExitStation//"+Username+".txt");
        deleteUser.deleteFile();
    }


    // Generates a shift report for the admin to see the NAME ,SHIFT HOURS,and SALARY
    public void generateShiftsReport() {
        File[]EntryPaths=new File("Operator//EntryStation").listFiles();
        for (int i=0;i<EntryPaths.length;i++){
            File file=new File(EntryPaths[i].getPath());
            Scanner fr= null;
            try {
                fr = new Scanner(file);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            fr.nextLine();
            fr.nextLine();
            System.out.println("Name: "+fr.nextLine());
            fr.nextLine();
            fr.nextLine();
            System.out.println("Shift Hours: "+fr.nextLine());
            System.out.println("Salary: "+fr.nextLine());
            fr.close();
        }
        File[]ExitPaths=new File("Operator//ExitStation").listFiles();
        for (int i=0;i<ExitPaths.length;i++){
            File file=new File(ExitPaths[i].getPath());
            Scanner fr= null;
            try {
                fr = new Scanner(file);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            fr.nextLine();
            fr.nextLine();
            System.out.println("Name: "+fr.nextLine());
            fr.nextLine();
            fr.nextLine();
            System.out.println("Shift Hours: "+fr.nextLine());
            System.out.println("Salary: "+fr.nextLine());
            fr.close();
        }
    }


    //generates a report for a  parked car that shows ENTRY ID,CAR PLATE NUMBER, TIME OF ENTRANCE ADVISED PARKING SPOT, CAR MODEL
    public void generateParkedCarsReport() {
        File[]paths=new File("ActiveTickets").listFiles();
        for (int i=0;i<paths.length;i++){
            File file=new File(paths[i].getPath());
            Scanner fr= null;
            try {
                fr = new Scanner(file);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            fr.nextLine();
            System.out.println("Entry ID: " + fr.nextLine());
            System.out.println("Car Plate Number: " + fr.nextLine());
            System.out.println("Time Of Entrance: " + fr.nextLine());
            System.out.println("Advised Parking Spot: " + fr.nextLine());
            System.out.println("Car Model: "+fr.nextLine());
        }
    }


    //This method implements the Interface class [AccountMethods]
    //It  allows the admin to log in with there account
    @Override
    public boolean login(String Username, String Password) {
        File file=new File("Admin//"+Username+".txt");
        if (file.exists()){
                Scanner fr= null;
            try {
                fr = new Scanner(file);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            fr.nextLine();
            fr.nextLine();
            fr.nextLine();
            fr.nextLine();
            if(Password.equals(fr.nextLine())){
                return true;
            }
        }
        return false;
    }
}
