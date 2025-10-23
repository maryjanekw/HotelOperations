package com.pluralsight;

public class Testing {
    public static void main(String[] args) throws InterruptedException {

        Reservation r1 = new Reservation("double" , 3, true);
        System.out.println(r1.getReservationTotal());

        Employee emp1 = new Employee("111", "Lilia", "Front Desk", 20.0, 0);
        emp1.punchIn();
        Thread.sleep(2000);
        emp1.punchOut();
        emp1.printEmployeeSummary();


        Room room1 = new Room(2, 150, false, false);
        room1.checkIn();
        room1.checkOut();
        room1.cleanRooom();

        Hotel hotel = new Hotel("Sunset Inn", 5, 10);
        hotel.printStatus();

        hotel.bookRoom(2, true);   // Book 2 suites
        hotel.bookRoom(3, false);  // Book 3 basic rooms
        hotel.bookRoom(6, true);   // Try to overbook suites
        hotel.printStatus();


    }
}
