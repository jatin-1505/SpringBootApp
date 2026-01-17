package com.jatin;

public class Ticket {
    private static int counter = 0;
    private final int id;
    private final long startTime;
    private long endTime;
    private final Vehicle vehicle;
    private final ParkingSpot parkingSpot;


    public Ticket(Vehicle vehicle, ParkingSpot parkingSpot){
        counter++;
        this.id=counter;
        this.parkingSpot =parkingSpot;
        this.vehicle=vehicle;
        this.startTime=System.currentTimeMillis();
    }
    public int getId() {
        return id;
    }
    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }


    public long getStartTime() {
        return startTime;
    }


    public long getEndTime() {
        return endTime;
    }


    public Vehicle getVehicle() {
        return vehicle;
    }

}
