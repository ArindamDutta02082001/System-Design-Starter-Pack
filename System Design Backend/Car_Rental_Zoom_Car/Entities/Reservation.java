package Car_Rental_Zoom_Car.Entities;

import java.util.Date;

public class Reservation {

    public Date startDate;
    public Date endDate;
    public String Username;
    public String mobile;
    public Store pickupStore;
    public Store returnStore;
    public Vehicle vehicle;

    ReservationStatusEnum status;

    public Reservation(Date startDate, Date endDate, String username, String mobile, Store pickupStore,
            Store returnStore, ReservationStatusEnum status, Vehicle vehicle) {

        this.startDate = startDate;
        this.endDate = endDate;
        Username = username;
        this.mobile = mobile;
        this.pickupStore = pickupStore;
        this.returnStore = returnStore;
        this.status = status;
        this.vehicle = vehicle;
    }   
    
  
    
}
