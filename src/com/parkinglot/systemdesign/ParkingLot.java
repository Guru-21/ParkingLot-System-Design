package com.parkinglot.systemdesign;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ParkingLot {
    private String name;
    private int capacity;
    private Map<String, ParkingSpot> parkingSpotMap;


    public ParkingLot(String name, int capacity){
        this.name = name;
        this.capacity = capacity;
        parkingSpotMap =  new HashMap<>();
        initializingParkingSpot();
    }

    private void initializingParkingSpot(){
        for (int i = 1; i <=capacity ; i++) {
            parkingSpotMap.put(String.valueOf(i), new ParkingSpot(String.valueOf(i)));
        }
    }


    public boolean isFull(){
        return parkingSpotMap.values().stream().allMatch(ParkingSpot :: isOccupied);
    }

    public boolean parkedVehicle(Vehicle vehicle, String spotNumber){
        ParkingSpot parkingSpot = parkingSpotMap.get(spotNumber);

        if(parkingSpot!=null){
            parkingSpot.parkedVehicle(vehicle);
            return true;
        }else{
            System.out.println("Invalid Spot : " + spotNumber);
            System.out.println("<<<<<------------------>>>>>");
            return false;
        }
    }

    public  void removeVehicle(String spotNumber){
        ParkingSpot parkingSpot = parkingSpotMap.get(spotNumber);
        if(parkingSpot!=null){
            parkingSpot.removedVehicle();
        }else{
            System.out.println("Invalid Spot : " + spotNumber);
            System.out.println("<<<<<------------------>>>>>");
        }
    }


    public void displayParkingLot(){
        System.out.println("Parking Name : " + name);
        for (String spotNumber:parkingSpotMap.keySet()){
            ParkingSpot parkingSpot = parkingSpotMap.get(spotNumber);
            System.out.println("Spot Number "+ spotNumber + " : " + (parkingSpot.isOccupied()? "Occupied":"Vacant"));
        }
        System.out.println("<<<<<------------------>>>>>");
    }
}
