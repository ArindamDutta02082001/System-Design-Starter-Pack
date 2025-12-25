package src.Entities;

import src.Entities.enums.VehicleStatus;

public class Vehicle {

    public String vname;
    public String vno;

    public boolean isAvaliable;

    public VehicleStatus vehicleStatus;

    public Vehicle( String vname , String vno )
    {
        this.vname = vname;
        this.vno = vno;
        this.isAvaliable = true;
        vehicleStatus = VehicleStatus.FREE;
    }

}
