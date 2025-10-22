package com.pluralsight;

public class Testing {
    public static void main(String[] args){

        Reservation r1 = new Reservation("double" , 3, true);
        System.out.println(r1.getReservationTotal());

        Employee emp1 = new Employee("111", "Lilia", "Front Desk", 20.0, 45 );
        System.out.println(emp1.getName() + "'s total pay: $" + emp1.getTotalPay());

        Room room1 = new Room(2, 150, false, false);
        room1.checkIn();
        room1.checkOut();
        room1.cleanRooom();
    }
}
