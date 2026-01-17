package com.jatin;

public class Main {
    public static void main(String[] args) {
        ParkingManager parkingManager=new ParkingManager();
        Vehicle v1=new Vehicle("UP11P9332",0);
        Vehicle v2=new Vehicle("UP11P9456",2);
        Vehicle v3=new Vehicle("UP11P9365",1);
        String result=parkingManager.parkVehicle(v1);
        System.out.println(result);
        result=parkingManager.parkVehicle(v2);
        System.out.println(result);
        result=parkingManager.parkVehicle(v3);
        System.out.println(result);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(parkingManager.exitVehicle(v2));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(parkingManager.exitVehicle(v1));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(parkingManager.exitVehicle(v3));
    }
}