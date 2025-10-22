package com.pluralsight;

public class Room {

    // The Room class is responsible for knowing everything related to a hotel room. A
    //room is only available if it is clean and not currently occupied.

    private int numberOfBeds;
    private double price;
    private boolean occupied;
    private boolean dirty;

    public Room(int numberOfBeds, double price, boolean occupied, boolean dirty) {
        this.numberOfBeds = numberOfBeds;
        this.price = price;
        this.occupied = occupied;
        this.dirty = dirty;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public double getPrice() {
        return price;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public boolean isDirty() {
        return dirty;
    }

    // Derived getter - true is room is not occupied and not dirty
    public boolean isAvailable() {
        return !occupied && !dirty;
    }

    public void checkIn(){
        if (isAvailable()){
            occupied = true;
            dirty = true;
            System.out.println("Guest has checked in. Room is now occupied and dirty.");
        }else{
            System.out.println("Check in Error. Room is unavailable.");
        }
    }

    public void checkOut(){
        if (occupied){
            occupied = false;
            System.out.println("Guest has checked out. Room must be cleaned before next check-in.");
        }else{
            System.out.println("Check out error. Room is not occupied.");
        }
    }

    public void cleanRooom(){
        if(!occupied && dirty){
            dirty = false;
            System.out.println("Rooms has been cleaned and is now available.");
        }else if(occupied){
            System.out.println("Room is occupied.");
        }else{
            System.out.println("Room has already been cleaned.");
        }
    }
}
