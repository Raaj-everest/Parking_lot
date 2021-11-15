
import java.util.Scanner;

import ParkingLot.ParkingLot;



public class input {


    public static void main(String[] args) {
        boolean exitstatus = false;
        String quit = "exit";
        help();
        System.out.print("Enter the commands ");
        do {
            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();
            if (str.equalsIgnoreCase(quit)) {
                exitstatus = true;
                sc.close();
            }
            str = str.toUpperCase();
            str = str.trim();
            String[] newStr = str.split("\\s+");

            switch (newStr[0]) {
            case "DISPLAY":
                try {

                    switch (newStr[1]) {

                    case "FREE_COUNT":
                        System.out.println("HELLO");
                        if (newStr[2] == "BIKE") {
                         

                        }
                        if (newStr[2] == "CAR") {
                         
                            

                        }
                        if (newStr[2] == "TRUCK") {
                     

                        }

                        break;

                    case "FREE_SLOTS":

                        if (newStr[2] == "BIKE") {

                        }
                        if (newStr[2] == "CAR") {

                        }
                        if (newStr[2] == "TRUCK") {

                        }
                        System.out.println("FREE");
                        break;

                    case "OCCUPIED_SLOTS":
                        if (newStr[2] == "BIKE") {

                        }
                        if (newStr[2] == "CAR") {

                        }
                        if (newStr[2] == "TRUCK") {

                        }
                        System.out.println("OCCUPIED");
                        break;

                    }

                } catch (Exception ex) {
                    ex.getStackTrace();
                }

                break;
            case "CREATE_PARKING_LOT":
                try {
                    String id = newStr[1];
                    int number1 = Integer.parseInt(newStr[2]);
                    int number2 = Integer.parseInt(newStr[3]);

                    ParkingLot.CreateParkingLot(id, number1, number2);

                } catch (Exception ex) {
                    ex.printStackTrace();

                }

                break;

            case "PARK_VEHICLE":
                try {
                          ParkingLot.ParkVehicle(newStr[1], newStr[2], newStr[3]);
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            case "UNPARK_VEHICLE":
            String[] parts = str.split("_");
                try {
                     int number1=  Integer.parseInt(parts[2]);
                     int number2=  Integer.parseInt(parts[3]);
                     ParkingLot.unParkVehicle(number1,number2);
                } catch (Exception w) {
                    w.printStackTrace();
                }

                break;

            default:
            System.out.println("oops you made an error in typing........");
            System.out.println("please follow the instruction as mentioned below");
                help();
                break;

            }
        } while (exitstatus == false);
         
    }


    public static void help() {
        System.out.println("\n");
        System.out.println("this is a plafrom for maintaining parking lot");
        System.out.println("you can Manage the parking lot by following commands");
        System.out.println("create_parking_lot <Building_ID> <Number_Of_floors> <Number_of_slots>");
        System.out.println("park_vehicle <rigistration_number> <colour>");
        System.out.println("unpark_vehicle <rigistration_number> <colour>");
        System.out.println("display free_count <vehicle_type>");
        System.out.println("display free_slots <vehicle_type>");
        System.out.println("display occupied_slots <vehicle_type>");
        System.out.println("exit");
        System.out.println("\n\n");
    }

}
