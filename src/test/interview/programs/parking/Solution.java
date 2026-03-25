package parking;

/*
We are developing a parking lot management system that tracks vehicles, parking sessions, and generates billing reports.

The program includes three classes: `Vehicle`, `ParkingSession`, and `ParkingLot`.

Classes:
* The `Vehicle` class represents a vehicle that parks in the lot.
* The `ParkingSession` class holds information about a single parking session.
* The `ParkingLot` class manages all parking sessions and provides statistical methods.

To begin with, we present you with two tasks:
1-1) Read through and understand the code below. Please take as much time as necessary, and feel free to run the code.
1-2) The test for ParkingLot is not passing due to a bug in the code. Make the necessary changes to ParkingLot to fix the bug.
*/

/*
2) We want to add a new function called "getLongestParkingSession" to the ParkingLot class.
This function finds the parking session with the longest duration and returns an array containing
[licensePlate, durationInMinutes].

For example, if there are sessions:
- "ABC123": 09:00 to 11:30 (150 minutes)
- "XYZ789": 10:00 to 10:45 (45 minutes)
- "DEF456": 14:00 to 18:00 (240 minutes)

The function should return ["DEF456", 240].

Time format is "HH:MM" in 24-hour format.

To assist you in testing this new function, we have provided the testGetLongestParkingSession function.
*/

import java.io.*;
import java.util.*;
import org.junit.*;

class Vehicle {
    /** Data about a vehicle. */
    String licensePlate;
    String vehicleType;  // "Car", "Motorcycle", "Truck", "SUV"
    String color;

    Vehicle(String licensePlate, String vehicleType, String color) {
        this.licensePlate = licensePlate;
        this.vehicleType = vehicleType;
        this.color = color;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Vehicle vehicle = (Vehicle) other;
        return licensePlate.equals(vehicle.licensePlate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(licensePlate);
    }
}

class ParkingSession {
    /** Data about a single parking session. */
    Vehicle vehicle;
    String entryTime;    // Format: "HH:MM"
    String exitTime;     // Format: "HH:MM", null if still parked
    String date;         // Format: "YYYY-MM-DD"
    double hourlyRate;   // Parking fee per hour

    ParkingSession(Vehicle vehicle, String entryTime, String exitTime, String date, double hourlyRate) {
        this.vehicle = vehicle;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
        this.date = date;
        this.hourlyRate = hourlyRate;
    }

    int getDurationMinutes() {
        /** Calculate parking duration in minutes. Returns -1 if still parked. */
        if (exitTime == null) return -1;
        
        String[] entryParts = entryTime.split(":");
        String[] exitParts = exitTime.split(":");
        
        int entryMinutes = Integer.parseInt(entryParts[0]) * 60 + Integer.parseInt(entryParts[1]);
        int exitMinutes = Integer.parseInt(exitParts[0]) * 60 + Integer.parseInt(exitParts[1]);
        
        return exitMinutes - entryMinutes;
    }

    double getFee() {
        /** Calculate parking fee based on duration. Returns 0 if still parked. */
        int duration = getDurationMinutes();
        if (duration < 0) return 0.0;
        
        double hours = duration / 60.0;
        return hours * hourlyRate;
    }
}

class ParkingLot {
    /**
     * Manages all parking sessions and provides analytical methods.
     */
    ArrayList<ParkingSession> sessions = new ArrayList<>();
    String lotName;

    ParkingLot(String lotName) {
        this.lotName = lotName;
    }

    void addSession(ParkingSession session) {
        sessions.add(session);
    }

    int getTotalSessions() {
        return sessions.size();
    }

    int getCurrentlyParkedCount() {
        /** Returns count of vehicles currently parked (no exit time). */
        return (int) sessions.stream()
            .filter(session -> session.exitTime == null)
            .count();
    }

    double getTotalRevenue() {
        /** Returns total revenue from all completed sessions. */
        return sessions.stream()
            .mapToDouble(session -> session.getFee())
            .sum();
    }

    double getAverageParkingDuration() {
        /** 
         * Returns average parking duration in minutes for completed sessions.
         * BUG: This method has a bug - fix it!
         */
        double totalMinutes = sessions.stream()
            .filter(session -> session.exitTime != null)
            .mapToInt(session -> session.getDurationMinutes())
            .sum();
        
        long completedSessions = sessions.stream()
            .filter(session -> session.exitTime != null)
            .count();
        
        return totalMinutes / completedSessions;
    }

    public Object[] getLongestParkingSession() {
        // Write your code here to solve this problem
        return null;
    }
}

public class Solution {
    public static void main(String[] args) {
        testParkingSession();
        testParkingLot();
        testGetLongestParkingSession();
    }

    public static void testParkingSession() {
        System.out.println("Running testParkingSession");
        Vehicle vehicle = new Vehicle("ABC123", "Car", "Blue");
        ParkingSession session = new ParkingSession(vehicle, "09:00", "11:30", "2024-02-01", 5.0);

        Assert.assertEquals(150, session.getDurationMinutes());
        Assert.assertEquals(12.5, session.getFee(), 0.01);
    }

    public static void testParkingLot() {
        System.out.println("Running testParkingLot");
        ParkingLot lot = new ParkingLot("Main Lot");

        Assert.assertEquals(0, lot.getTotalSessions());
        Assert.assertEquals(0, lot.getCurrentlyParkedCount());

        Vehicle v1 = new Vehicle("ABC123", "Car", "Blue");
        Vehicle v2 = new Vehicle("XYZ789", "SUV", "Red");
        Vehicle v3 = new Vehicle("DEF456", "Motorcycle", "Black");

        ParkingSession s1 = new ParkingSession(v1, "09:00", "11:00", "2024-02-01", 5.0);
        ParkingSession s2 = new ParkingSession(v2, "10:00", "12:30", "2024-02-01", 5.0);
        ParkingSession s3 = new ParkingSession(v3, "14:00", null, "2024-02-01", 3.0);

        lot.addSession(s1);
        lot.addSession(s2);
        lot.addSession(s3);

        Assert.assertEquals(3, lot.getTotalSessions());
        Assert.assertEquals(1, lot.getCurrentlyParkedCount());
        Assert.assertEquals(22.5, lot.getTotalRevenue(), 0.01);
        Assert.assertEquals(135.0, lot.getAverageParkingDuration(), 0.01);
    }

    public static void testGetLongestParkingSession() {
        System.out.println("Running testGetLongestParkingSession");
        ParkingLot lot = new ParkingLot("Main Lot");

        Assert.assertNull(lot.getLongestParkingSession());

        Vehicle v1 = new Vehicle("ABC123", "Car", "Blue");
        Vehicle v2 = new Vehicle("XYZ789", "SUV", "Red");
        Vehicle v3 = new Vehicle("DEF456", "Motorcycle", "Black");

        ParkingSession s1 = new ParkingSession(v1, "09:00", "11:30", "2024-02-01", 5.0);
        ParkingSession s2 = new ParkingSession(v2, "10:00", "10:45", "2024-02-01", 5.0);
        ParkingSession s3 = new ParkingSession(v3, "14:00", "18:00", "2024-02-01", 3.0);

        lot.addSession(s1);
        lot.addSession(s2);
        lot.addSession(s3);

        Assert.assertArrayEquals(new Object[] {"DEF456", 240}, lot.getLongestParkingSession());
    }
}
