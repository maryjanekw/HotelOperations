package com.pluralsight;

public class Hotel {

    private String name;
    private int numberOfSuites;
    private int numberOfRooms;
    private int bookedSuites;
    private int bookedBasicRooms;

    // Constructor 1- booked default = 0
    public Hotel(String name, int numberOfSuites, int numberOfRooms) {
        this(name, numberOfSuites, numberOfRooms, 0, 0);
    }

    // Constructor 2- specify # of booked rooms/suite
    public Hotel(String name, int numberOfSuites, int numberOfRooms, int bookedBasicRooms, int bookedSuites) {
        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
        this.bookedBasicRooms = bookedBasicRooms;
        this.bookedSuites = bookedSuites;
    }

    // Derived Getter-calculate # of available rooms/suites
    public int getAvailableSuites(){
        return numberOfSuites - bookedSuites;
    }

    public int  getAvailableRooms(){
        return numberOfRooms - bookedBasicRooms;
    }

    // Book a room
    public boolean bookRoom(int numberOfRoomsRequested, boolean isSuite){
        if(isSuite){
            if (numberOfRoomsRequested <= getAvailableSuites()){
                bookedSuites += numberOfRoomsRequested;
                System.out.println(numberOfRoomsRequested + " suite(s) successfully booked.");
                return true;
            }else {
                System.out.println("Requested number of suites not available.");
                return false;
            }
        }else{
            if (numberOfRoomsRequested <= getAvailableRooms()){
                bookedBasicRooms += numberOfRoomsRequested;
                System.out.println(numberOfRoomsRequested + " basic room(s) successfully booked.");
                return true;
            }else{
                System.out.println("Requested number of rooms not available.");
                return false;
            }
        }
    }

    // Guest booking statement
    public void printStatus() {
        System.out.println("\n Hotel: " + name);
        System.out.println("Available Suites: " + getAvailableSuites());
        System.out.println("Available Basic Rooms: " + getAvailableRooms());
        System.out.println("-----------------------------");
    }
}
