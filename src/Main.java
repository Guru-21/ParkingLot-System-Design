import com.parkinglot.systemdesign.ParkingLot;
import com.parkinglot.systemdesign.Vehicle;

import javax.swing.text.html.parser.Parser;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome ParkingLot App");
        System.out.println("----------------------------------");

        Scanner scn = new Scanner(System.in);
        System.out.print("Please Enter Parking Name : ");
        String name = scn.nextLine();
        System.out.print("Please Enter capacity: ");
        int capacity = Integer.parseInt(scn.nextLine());
        ParkingLot parkingLot = new ParkingLot(name, capacity);
        System.out.println("<<<<<------------------>>>>>");

        while(true){
            System.out.println("Please Enter the choice : ");
            System.out.println("Press - 1 Vehicle Parked ");
            System.out.println("Press - 2 Remove Parked ");
            System.out.println("Press - 3 display Parking Lot ");
            System.out.println("Press - 4 for Exit ");
            System.out.println("<<<<<------------------>>>>>");


            int choice = Integer.parseInt(scn.nextLine());

            switch (choice){
                case 1:
                    if(parkingLot.isFull()){
                        System.out.println("Parking space is Full yoy cannot parked more vehicle");
                        break;
                    }

                    System.out.print("Please Enter Vehicle Type (Car,Bike, Van, etc.) : ");
                    String type =  scn.nextLine();
                    System.out.print("Please Enter Vehicle Number : ");
                    String number =  scn.nextLine();
                    System.out.print("Please Enter Spot Number : ");
                    String spotNumber =  scn.nextLine();

                    Vehicle vehicle = new Vehicle(number, type);
                    parkingLot.parkedVehicle(vehicle,spotNumber);
                    break;

                case 2:
                    System.out.print("Please Enter Spot Number : ");
                    spotNumber =  scn.nextLine();
                    parkingLot.removeVehicle(spotNumber);
                    break;

                case 3:
                    parkingLot.displayParkingLot();
                    break;


                case 4:
                    System.out.println("Thank you ! Visit Again 🙏");
                    scn.close();
                    System.exit(0);

                default:
                    System.out.println("Please Enter a valid Input, Try again.");
            }

        }
    }
}