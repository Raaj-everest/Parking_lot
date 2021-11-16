
import java.util.Scanner;

import ParkingLot.ParkingLot;



public class app {


    public static void main(String[] args) {

        boolean exitstatus = false;
        String quit = "exit";
        ParkingLot.help();
        System.out.print("start the program by cerating a new parking_lot ");
        System.out.println("\n");
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
                    if(ParkingLot.getParkinglot_instance()!=null){

                    switch (newStr[1]) {

                    case "FREE_COUNT":
                
                        if (newStr[2].equals("BIKE")) {
                           ParkingLot.display_free_count_bike();

                        }
                        if (newStr[2].equals("CAR")) {
                         
                            ParkingLot.display_free_count_car();

                        }
                        if (newStr[2].equals("TRUCK") ){
                           ParkingLot.display_free_count_truck();

                        }

                        break;

                    case "FREE_SLOTS":

                        if (newStr[2].equals("BIKE")) {
                            ParkingLot.display_free_slots_bike();
                        }
                        if (newStr[2].equals("CAR")) {
                           ParkingLot.display_free_slots_cars();
                        }
                        if (newStr[2].equals("TRUCK") ){
                           ParkingLot.display_free_slots_truck();
                        }
                        
                        break;

                    case "OCCUPIED_SLOTS":
                        if (newStr[2] == "BIKE") {
                           ParkingLot.display_occupied_slots_bike();
                        }
                        if (newStr[2] == "CAR") {
                            ParkingLot.display_occupied_slots_cars();
                        }
                        if (newStr[2] == "TRUCK") {
                            ParkingLot.display_occupied_slots_truck();
                        }
                        System.out.println("OCCUPIED");
                        break;

                    }
                } else{
                    System.out.println("you need to create a parking lot first..");
                    System.out.println("for any help enter 'help' ");
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
                case "EXIT":
                System.out.println("you terminated the program");
                break;

            default:
            System.out.println("oops you made an error in typing........");
            System.out.println("for any help enter 'help' ");
        
                break;

            }
        } while (exitstatus == false);
         
    }




}
