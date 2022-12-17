package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


// a class that is resposiable for dealing with the operators (ENTRY && EXIT)
public class Operator extends Person{
    private String password;
    private String shifts;
    private double Salary;


    //constructors for the Operator class
    public Operator(int ID, String Name, String Username, String Password, String Shifts, Double Salary){
        super(ID,Name,Username);
        this.password=Password;
        this.shifts=Shifts;
        this.Salary=Salary;
    }
    public Operator(String Username,String password){
        super(Username);
        this.password=password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setSalary(double salary) {
        this.Salary = salary;
    }

    public double getSalary() {
        return Salary;
    }

    public String getShifts() {
        return shifts;
    }

    public void setShifts(String shifts) {
        this.shifts = shifts;
    }





}
