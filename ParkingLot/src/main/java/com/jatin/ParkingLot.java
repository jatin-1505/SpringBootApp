package com.jatin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {
    Map<Integer, List<ParkingSpot>> available;
    Map<Vehicle, Ticket> vehicleToTicket;

    public ParkingLot(Map<Integer, List<ParkingSpot>> available){
        this.available=available;
        vehicleToTicket=new HashMap<>();
    }
    public String entryVehicle(Vehicle vehicle){
        int vehicleSize=vehicle.getVehicleSize();
        if(available.get(vehicleSize).size()<=0) return "no spot available";
        else{
            ParkingSpot spot=available.get(vehicleSize).remove(available.get(vehicleSize).size()-1);
            Ticket ticket=generateTicket(spot,vehicle);
            vehicleToTicket.put(vehicle,ticket);
            return "vehicle parked";
        }

    }
    public long exitVehicle(Vehicle vehicle){
        Ticket ticket=vehicleToTicket.get(vehicle);
        ParkingSpot spot=ticket.getParkingSpot();
        available.get(spot.getSpotSize()).add(spot);
        long amount=getPrice(spot,ticket);
        vehicleToTicket.remove(vehicle);
        return amount;
    }
    public long getPrice(ParkingSpot spot, Ticket ticket){
        long currTime=System.currentTimeMillis();
        int size=spot.getSpotSize();
        long totalTime=(currTime-ticket.getStartTime())*(size*10+100);
        return totalTime;
    }
    public Ticket generateTicket(ParkingSpot spot, Vehicle vehicle){
        Ticket ticket=new Ticket(vehicle,spot);
        return ticket;
    }
}
