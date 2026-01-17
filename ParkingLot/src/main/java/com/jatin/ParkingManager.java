package com.jatin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingManager {
    ParkingSpot[] parkingSpots=new ParkingSpot[30];
    Map<Integer, List<ParkingSpot>> availableSpots=new HashMap<>();
    ParkingLot parkingLot;
    public ParkingManager(){
        for(int i=0;i<30;i++){
            parkingSpots[i]=new ParkingSpot(i,(int)i/10);
            availableSpots.computeIfAbsent(i,k->new ArrayList<>()).add(parkingSpots[i]);
        }
        parkingLot=new ParkingLot(availableSpots);
    }
    public String parkVehicle(Vehicle vehicle){
        return parkingLot.entryVehicle(vehicle);
    }
    public long exitVehicle(Vehicle vehicle){
        return parkingLot.exitVehicle(vehicle);
    }
}
