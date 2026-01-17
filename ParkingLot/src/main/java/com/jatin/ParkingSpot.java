package com.jatin;

public class ParkingSpot {
    private int spotSize;
    private int id;

    public ParkingSpot(int id,int spotSize){
        this.id=id;
        this.spotSize=spotSize;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSpotSize() {
        return spotSize;
    }

    public void setSpotSize(int spotSize) {
        this.spotSize = spotSize;
    }

    public void occupy(Vehicle vehicle){

    }
    public void vacate(int id){

    }
}
