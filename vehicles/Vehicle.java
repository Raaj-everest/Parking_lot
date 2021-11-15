package vehicles;
import vehicles.attributes.*;

public  class Vehicle {
   private String rigistration_number;
   private String colour;
   private String typeOfVehicle;
  
   public Vehicle (type Type,String rigistration_numbeString,String Colour ){
    this.rigistration_number=rigistration_numbeString;
    this.colour = Colour;
    this.typeOfVehicle=Type.toString();
}
public String getcolour() {
    return colour;
}
public String getRigistration_number() {
    return rigistration_number;
}
public String getTypeOfVehicle() {
    return typeOfVehicle;
}
}