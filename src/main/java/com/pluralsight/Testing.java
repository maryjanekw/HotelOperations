package com.pluralsight;

public class Testing {
    public static void main(String[] args){

        Reservation r1 = new Reservation("double" , 3, true);
        System.out.println(r1.getReservationTotal());
    }
}
