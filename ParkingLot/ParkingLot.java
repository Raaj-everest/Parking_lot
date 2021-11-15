package ParkingLot;

import vehicles.Vehicle;
import vehicles.types.*;

//singelton class
public class ParkingLot {
    private static ParkingLot parkinglot_instance = null;
    private static String parkinglot_id;
    private static int Number_of_floors;
    private static int Number_of_slots;

    private static Vehicle[][] floors;

    private ParkingLot(String id, int Number_of_floors, int Number_of_slots) {
        ParkingLot.parkinglot_id = id;
        ParkingLot.Number_of_floors = Number_of_floors;
        ParkingLot.Number_of_slots = Number_of_slots;
        ParkingLot.floors = new Vehicle[Number_of_floors][Number_of_slots];

    }

    public static ParkingLot CreateParkingLot(String id, int Number_of_floors, int Number_of_slots) {
        if (parkinglot_instance == null) {
            parkinglot_instance = new ParkingLot(id, Number_of_floors, Number_of_slots);
            System.out.println("\n\n");
            System.out.println("=====================================================================");
            System.out.println("===================      EVEREST PARKING LOT     ====================");
            System.out.println("=====================================================================");
            System.out.println("Created parking lot with " + Number_of_floors + " floors having " + Number_of_slots
                    + " slots per floor");
        }
        if (parkinglot_instance != null) {
            System.out.println("parking lot is already created..");
        }

        return parkinglot_instance;
    }

    private static String getParkinglot_id() {
        return parkinglot_id;
    }

    public static void ParkVehicle(String vehicle_type, String rigistration_number, String newStr) {
        boolean flag = false;
        for (int i = 0; i < Number_of_floors; i++) {
            if (flag == false) {
                for (int j = 0; j < Number_of_slots; j++) {
                    if (vehicle_type.equals("truck") && j == 0) {
                        if (floors[i][j] == null) {
                            floors[i][j] = new Truck(rigistration_number, newStr);

                            flag = true;
                            genereateTicket(i, j);
                            break;
                        } else if (i == 1) {
                            System.out.println("Parking lot full for the trucks");
                        }

                    } else if (vehicle_type.equals("bike") && j > 0 && j < 3) {
                        if (floors[i][j] == null) {
                            floors[i][j] = new Bike(rigistration_number, newStr);

                            flag = true;

                            genereateTicket(i, j);
                            break;
                        } else if (i == 2) {
                            System.out.println("Parking lot full for the bikes");
                        }

                    } else

                    if (vehicle_type.equals("car")) {
                        if (floors[i][j] == null) {
                            floors[i][j] = new Car(rigistration_number, newStr);

                            flag = true;
                            genereateTicket(i, j);
                            break;
                        } else if (i == Number_of_slots - 1) {
                            System.out.println("parking lot is full for the cars");
                        }
                    }

                }
            }

        }
    }

    public static void unParkVehicle(int floor, int slot) {
        if (floors[floor][slot] != null) {
            floors[floor][slot].getRigistration_number();
            floors[floor][slot].getcolour();
            System.out.println("unparked vehicle with rigistration number: "
                    + floors[floor][slot].getRigistration_number() + "and" + floors[floor][slot].getcolour());
            floors[floor][slot] = null;
        } else if (floors[floor][slot] == null) {
            System.out.println("invalid ticket");
        }
    }

    private static String genereateTicket(int a, int b) {
        String ticket = getParkinglot_id() + "_" + a + "_" + b;
        System.out.println("parked Vehicle. ticket ID: " + ticket);
        return ticket;
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
