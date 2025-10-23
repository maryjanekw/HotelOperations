package com.pluralsight;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Employee {

    // The Employee class is used to store and calculate payroll information about and
    //employee


    // Employee information
    private String employeeId;
    private  String name;
    private String department;
    private double payRate; // hourly pay rate
    private double hoursWorked; // accumulated hours worked

    // Employee time tracker
    private boolean isPunchedIn;
    private double punchInTime;

    public Employee(String employeeId, String name, String department, double payRate, double hoursWorked) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = 0;
        this.isPunchedIn = false;
    }

//    public void punchTimeCard(double time) {
//        if (!isPunchedIn) {
//            punchInTime = time;
//            isPunchedIn = true;
//            System.out.println(name + " punched in at " + time);
//        } else {
//            System.out.println(name + "is already punched in!");
//        }
//    }

    public void punchIn(double time) {
        if (!isPunchedIn) {
            punchInTime = time;
            isPunchedIn = true;
            System.out.println(name + " punched in at " + time);
        } else {
            System.out.println(name + " is already punched in!");
        }
    }

    public void punchOut(double time){
        if(isPunchedIn){
            double hours = time - punchInTime;
            hoursWorked += hours;
            isPunchedIn = false;
            System.out.println(name + " punched out at " + time + " (worked " + hours + " hrs)");
        }else{
            System.out.println(name + " cannot punch out before punching in!");
        }
    }

    // Overloaded versions using LocalDateTime
    public void punchIn() {
        LocalDateTime now = LocalDateTime.now();
        double currentTime = now.getHour() + (now.getMinute() / 60.0);

        // time formatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedTime = now.format(formatter);

        punchIn(currentTime);
        System.out.println(name + " punched in at " + formattedTime);
    }

    public void punchOut() {
        LocalDateTime now = LocalDateTime.now();
        double currentTime = now.getHour() + (now.getMinute() / 60.0);

        // time formatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedTime = now.format(formatter);

        punchOut(currentTime);
        System.out.println(name + " punched out at " + formattedTime);
    }

    // payroll logic
    public double getRegularHours(){
        return Math.min(hoursWorked, 40);
    }

    public double getOvertimeHours(){
        return Math.max(0, hoursWorked - 40);
    }

    public double getTotalPay(){
        return (getRegularHours() * payRate) + (getOvertimeHours() * payRate * 1.5);
    }

    // For fun employee summary
    public void printEmployeeSummary() {
        System.out.println("\n--- Employee Summary ---");
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Hours Worked: " + hoursWorked);
        System.out.println("Total Pay: $" + String.format("%.2f", getTotalPay()));
        System.out.println("--------------------------\n");
    }
}
