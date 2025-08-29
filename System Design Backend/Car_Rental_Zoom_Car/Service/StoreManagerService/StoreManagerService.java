package Car_Rental_Zoom_Car.Service.StoreManagerService;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import Car_Rental_Zoom_Car.Entities.Store;
import Car_Rental_Zoom_Car.Entities.Vehicle;

public class StoreManagerService {

    List<Store> listOfStores;


    // add stores
    int createStore( String name, String location, List<Vehicle> listOfVehicle )
    {
        int newStoreID = listOfStores.size()+1;
        Store newStore = new Store( name, listOfStores.size()+1, location, listOfVehicle );

        listOfStores.add(newStore);

        return newStoreID;
    }

    // remove stores
    Store removeStore( int ID )
    {
        listOfStores = listOfStores.stream().filter(e->e.UUID != ID).collect(Collectors.toList());
        Store storeRemoved = listOfStores.stream().filter(e->e.UUID == ID).collect(Collectors.toList()).get(0);
        return storeRemoved ;
    }

    Store getStore( int ID )
    {
        return  listOfStores.stream().filter(e->e.UUID == ID).collect(Collectors.toList()).get(0);
    }
    
}
