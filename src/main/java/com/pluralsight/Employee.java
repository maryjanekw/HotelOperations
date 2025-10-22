package com.pluralsight;

public class Employee {

    // The Employee class is used to store and calculate payroll information about and
    //employee


    // Employee information
    private String employeeId;
    private  String name;
    private String department;
    private double payRate; // hourly pay rate
    private double hoursWorked; // accumulated hours worked

    public Employee(String employeeId, String name, String department, double payRate, double hoursWorked) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getPayRate() {
        return payRate;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getRegularHours(){
        return Math.min(hoursWorked, 40);
    }

    public double getOvertimeHours(){
        return Math.max(0, hoursWorked - 40);
    }

    public double getTotalPay(){
        return (getRegularHours() * payRate) + (getOvertimeHours() * payRate * 1.5);
    }

    // Employee time tracker
    private boolean isPunchedIn = false;
    private double punchInTime;

    public void punchTimeCard(double time) {
        if (!isPunchedIn) {
            punchInTime = time;
            isPunchedIn = true;
            System.out.println(name + " punched in at " + time);
        } else {
            double hours = time - punchInTime;
            hoursWorked += hours;
            isPunchedIn = false;
            System.out.println(name + " punched out at " + time + " (worked " + hours + " hrs)");
        }
    }
}
