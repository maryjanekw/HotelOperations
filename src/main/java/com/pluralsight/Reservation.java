package com.pluralsight;

public class Reservation {

    // The Reservation class is responsible for storing information related to a guest
    //stay.

    private String roomType;  // King or Double
    private int numberOfNights;
    private boolean weekend;

    public Reservation(String roomType, int numberOfNights, boolean weekend) {
        this.roomType = roomType;
        this.numberOfNights = numberOfNights;
        this.weekend = weekend;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public boolean isWeekend() {
        return weekend;
    }

    public void setWeekend(boolean weekend) {
        this.weekend = weekend;
    }

    public double getPrice(){
        double baseRate = roomType.equalsIgnoreCase("king") ? 139.00f : 124.00f;
        if (weekend){
            baseRate *= 1.10f; // weekends rate 10% more
        }
        return baseRate;
    }

    public double getReservationTotal(){
        return getPrice() * numberOfNights;
    }
}
