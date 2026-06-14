package Car_Rental_Zoom_Car.Entities;

public abstract class Vehicle {

    public int registrationNumber;
    public String color;
    public VehicleStatusEnum status;
    public Double basePrice;
    public VehicleEnum vehicleType ;

    public Vehicle(int registrationNumber, String color, VehicleStatusEnum status, Double basePrice,
            VehicleEnum vehicleType) {

        this.registrationNumber = registrationNumber;
        this.color = color;
        this.status = status;
        this.basePrice = basePrice;
        this.vehicleType = vehicleType;
    } 

    public abstract  int calcBasePrice( int days );
    
}
