package com.parkinglot.systemdesign;

public class ParkingSpot {

    private String spotNumber;
    private Vehicle parkedVehicle;

    public ParkingSpot(String spotNumber) {
        this.spotNumber = spotNumber;
        this.parkedVehicle = null;
    }

    public boolean isOccupied(){
        return parkedVehicle!=null;
    }

    public void parkedVehicle(Vehicle vehicle){
        if(!isOccupied()){
             parkedVehicle = vehicle;
            System.out.println("Vehicle with number " + vehicle.getVehicleNumber() + " is parked at spot "+ spotNumber);
            System.out.println("<<<<<------------------>>>>>");
        }else{
            System.out.println("Spot number " + spotNumber+ " is already occupied. ");
            System.out.println("<<<<<------------------>>>>>");
        }
    }

    public void removedVehicle(){
        if(isOccupied()){
            System.out.println("Vehicle with number "+ parkedVehicle.getVehicleNumber() + " is removed from spot " + spotNumber);
            System.out.println("<<<<<------------------>>>>>");
            parkedVehicle = null;
        }else{
            System.out.println("Spot number "+ spotNumber + " is vacant");
            System.out.println("<<<<<------------------>>>>>");
        }
    }


}
