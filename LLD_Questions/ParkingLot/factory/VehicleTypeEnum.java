package ParkingLot.factory;

public enum VehicleTypeEnum {

    TWOWHEELER(1),
    BIKE(2),
    AUTO(3),
    CAR(4),
    TRUCK(5);

    private final int priority;

    VehicleTypeEnum(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }
    
}
