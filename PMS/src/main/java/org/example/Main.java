package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        FileHandler launchApp=new FileHandler("ParkingSpot");

        ParkingSpot[]Garage=launchApp.retrieveGarageFiles();
        Scanner input=new Scanner(System.in);

        System.out.println("Choose your account Type \n1.Admin\n2.Entry Station Operator\n3.Exit Station Operator\n4.Customer");
        int loginChoice=input.nextInt();
        switch (loginChoice){
            case 1:
            {
                System.out.println("Enter username");
                String Username = input.next();
                System.out.println("Enter Password");
                String pass = input.next();
                Admin admin1 = new Admin(Username, pass);
                if (!admin1.login(Username, pass)) {
                    System.out.println("Wrong Username or password");
                    break;
                }
                FileHandler getData=new FileHandler("Admin//"+Username+".txt");
                admin1=getData.retrieveFromFile(Username,1);
                System.out.println("Welcome " + admin1.getName() + " Choose your Operation:\n1.Add Parking Spot\n2.View all parking spots\n3.Add new customer\n4.update existing customer" +
                        "\n5.remove a customer\n6.add a new entry operator\n7.update existing entry operator\n8.remove an entry operator\n9.add a new exit operator\n10.update an exit operator" +
                        "\n11.remove an exit operator\n12.generate salary report\n13.generate a report about cars currently parked");
                int operationNumber = input.nextInt();
                switch (operationNumber) {
                    case 1:
                        System.out.println("Enter the spot Name example(A1)");
                        admin1.addParkingSpot(new ParkingSpot(input.next()));
                        break;
                    case 2:
                        admin1.viewAllSpots();
                        break;
                    case 3: {
                        System.out.println("Enter a unique ID");
                        int ID = input.nextInt();
                        System.out.println("Enter the name(no spaces)");
                        String name = input.next();
                        System.out.println("Enter the username(no spaces)");
                        String username = input.next();
                        System.out.println("Enter Car Model");
                        String carModel = input.next();
                        System.out.println("Plate Number");
                        String plateNumber = input.next();
                        admin1.addCustomer(new Customer(ID, name, username, carModel, plateNumber));
                        break;
                    }
                    case 4: {
                        System.out.println("Enter Customer ID");
                        int ID = input.nextInt();
                        System.out.println("Enter the name(no spaces)");
                        String name = input.next();
                        System.out.println("Enter the username(no spaces)");
                        String username = input.next();
                        System.out.println("Enter Car Model");
                        String carModel = input.next();
                        System.out.println("Plate Number");
                        String plateNumber = input.next();
                        admin1.updateCustomer(new Customer(ID, name, username, carModel, plateNumber));
                        break;
                    }
                    case 5: {
                        System.out.println("Enter customer ID to delete");
                        admin1.deleteCustomer(input.nextInt());
                        break;
                    }
                    case 6: {
                        System.out.println("Enter a unique ID");
                        int ID = input.nextInt();
                        System.out.println("Enter the name(no spaces)");
                        String name = input.next();
                        System.out.println("Enter the username(no spaces)");
                        String username = input.next();
                        System.out.println("Enter Password");
                        String newPassword = input.next();
                        System.out.println("Enter shifts in this format example: (mon:1pm-9pm,tue:2pm-10pm)");
                        input.nextLine();
                        String shifts = input.nextLine();
                        System.out.println("Enter Salary");
                        double salary = input.nextDouble();
                        admin1.addEntryOperator(new EntryStation(ID, name, username, newPassword, shifts, salary));
                        break;
                    }
                    case 7: {
                        System.out.println("Enter a unique ID");
                        int ID = input.nextInt();
                        System.out.println("Enter the name(no spaces)");
                        String name = input.next();
                        System.out.println("Enter the username(no spaces)");
                        String username = input.next();
                        System.out.println("Enter Password");
                        String newPassword = input.next();
                        System.out.println("Enter shifts in this format example: (mon:1pm-9pm,tue:2pm-10pm)");
                        input.nextLine();
                        String shifts = input.nextLine();
                        System.out.println("Enter Salary");
                        double salary = input.nextDouble();
                        admin1.updateEntryOperator(new EntryStation(ID, name, username, newPassword, shifts, salary));
                        break;
                    }
                    case 8: {
                        System.out.println("Enter Entry operator to delete");
                        admin1.deleteEntryOperator(input.next());
                        break;
                    }
                    case 9: {
                        System.out.println("Enter a unique ID");
                        int ID = input.nextInt();
                        System.out.println("Enter the name(no spaces)");
                        String name = input.next();
                        System.out.println("Enter the username(no spaces)");
                        String username = input.next();
                        System.out.println("Enter Password");
                        String newPassword = input.next();
                        System.out.println("Enter shifts in this format example: (mon:1pm-9pm,tue:2pm-10pm)");
                        input.nextLine();
                        String shifts = input.nextLine();
                        System.out.println("Enter Salary");
                        double salary = input.nextDouble();
                        admin1.addExitOperator(new ExitStation(ID, name, username, newPassword, shifts, salary));
                        break;
                    }
                    case 10: {
                        System.out.println("Enter a unique ID");
                        int ID = input.nextInt();
                        System.out.println("Enter the name(no spaces)");
                        String name = input.next();
                        System.out.println("Enter the username(no spaces)");
                        String username = input.next();
                        System.out.println("Enter Password");
                        String newPassword = input.next();
                        System.out.println("Enter shifts in this format example: (mon:1pm-9pm,tue:2pm-10pm)");
                        input.nextLine();
                        String shifts = input.nextLine();
                        System.out.println("Enter Salary");
                        double salary = input.nextDouble();
                        admin1.updateExitOperator(new ExitStation(ID, name, username, newPassword, shifts, salary));
                        break;
                    }
                    case 11: {
                        System.out.println("Enter Entry operator to delete");
                        admin1.deleteExitOperator(input.next());
                        break;
                    }
                    case 12: {
                        admin1.generateShiftsReport();
                        break;
                    }
                    case 13: {
                        admin1.generateParkedCarsReport();
                        break;
                    }
                    default:
                        System.out.println("Invalid operation, terminating program");
                }
                break;
            }
            case 2:
            {
                System.out.println("Enter Username");
                String Username=input.next();
                System.out.println("Enter Password");
                String pass=input.next();
                EntryStation operator1=new EntryStation(Username,pass);
                if(!operator1.login(Username,pass)){
                    System.out.println("Wrong Username or password");
                    break;
                }
                FileHandler getData=new FileHandler("Operator//EntryStation//"+Username+".txt");
                operator1=getData.retrieveFromFile(Username);
                System.out.println("Welcome Entry operator "+operator1.getName()+" Choose your operation,\n1.To check the free spots\n2.recommend the nearest free spot");
                int operationNumber=input.nextInt();
                switch (operationNumber){
                    case 1:
                    {
                        operator1.checkFreeSpots(Garage);
                        break;
                    }
                    case 2:
                    {
                        operator1.recommendNearestFreeSpot(Garage);
                        break;
                    }
                    default:
                        System.out.println("Invalid operation, terminating program");
                }
                break;
            }
            case 3:
            {
                System.out.println("Enter Username");
                String Username = input.next();
                System.out.println("Enter Password");
                String pass = input.next();
                ExitStation operator1 = new ExitStation(Username, pass);
                if (!operator1.login(Username, pass)) {
                    System.out.println("Wrong Username or password");
                    break;
                }
                FileHandler getData=new FileHandler("Operator//ExitStation//"+Username+".txt");
                operator1=getData.retrieveFromFile(Username,"Exit");
                System.out.println("Welcome Entry operator " + operator1.getName() + " Choose your operation,\n1.Calculate the hours spent for an Active ticket");
                int operationNumber = input.nextInt();
                switch (operationNumber) {
                    case 1:
                    {
                        System.out.println("Enter Ticket ID");
                        operator1.calculateParkingHours(input.nextInt());
                        break;
                    }
                    default:
                        System.out.println("Invalid operation, terminating program");
                }
                break;
            }
            case 4:
            {
                System.out.println("Swipe your subscription card (the barcode contains your ID)");
                int ID=input.nextInt();
                FileHandler findData=new FileHandler("Customer");

                Customer customer1=findData.retrieveFromFile(ID);
                System.out.println("Welcome "+customer1.getUsername());
                if (findData.checkCustomerTicket(ID)){
                    System.out.println("Amount paid for the stay was $"+customer1.payTicket(ExitStation.calculateParkingHours(ID)));
                }
                else{
                    customer1.printTicket(ID,EntryStation.recommendNearestFreeSpot(Garage));
                }
                break;
            }
            default:
                System.out.println("Invalid User Type, terminating program");
        }
        System.out.println("Program is now Exiting");
    }
}