package com.jatin;

public class Vehicle {
    private String plateNum;
    private int vehicleSize;
    public Vehicle(String plateNum,int vehicleSize){
        this.plateNum=plateNum;
        this.vehicleSize=vehicleSize;
    }
    public int getVehicleSize() {
        return vehicleSize;
    }

    public void setVehicleSize(int vehicleSize) {
        this.vehicleSize = vehicleSize;
    }

    public String getPlateNum() {
        return plateNum;
    }

    public void setPlateNum(String plateNum) {
        this.plateNum = plateNum;
    }


}
