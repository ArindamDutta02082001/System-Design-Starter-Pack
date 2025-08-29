package Car_Rental_Zoom_Car.Entities;

import java.util.List;

public class Store {

    public int UUID;
    public String name ;
    public String location;
    public List<Vehicle> listOfVehicle;

    public Store(String name, int uUID, String location, List<Vehicle> listOfVehicle) {
        this.name = name;
        UUID = uUID;
        this.location = location;
        this.listOfVehicle = listOfVehicle;
    }

    
}
