package Car_Rental_Zoom_Car.Service;

import java.util.*;

import Car_Rental_Zoom_Car.Entities.*;

public class CarRentalMainService {


    
    

        // class members
        List<Vehicle> vehicleList = new ArrayList<>();
        

        // singleton instance of the service
        private static volatile CarRentalMainService carRentalService = null; 

        private CarRentalMainService()
        {

        }

        public static CarRentalMainService getInstance()
        {
            if( carRentalService == null)
            {
            synchronized( CarRentalMainService.class )
            {
                if( carRentalService == null )
                    carRentalService = new CarRentalMainService();
            }
            }

            return carRentalService;
        }




}
