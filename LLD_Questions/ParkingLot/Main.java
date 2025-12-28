package ParkingLot;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import ParkingLot.Entities.Floor;
import ParkingLot.Entities.ParkingSpot;
import ParkingLot.Entities.Ticket;
import ParkingLot.Entities.User;
import ParkingLot.factory.Vehicle;
import ParkingLot.factory.VehicleFactory;
import ParkingLot.factory.VehicleTypeEnum;
import ParkingLot.observer.subscriber.EmailChannel;
import ParkingLot.observer.subscriber.SMSChannel;
import ParkingLot.observer.subscriber.ChannelInterface;
import ParkingLot.strategy.parkingfee.PremiumMinuteFeeStrategy;
import ParkingLot.strategy.payments.CreditCardPaymentStrategy;
import ParkingLot.strategy.payments.UPIPaymentStrategy;
import ParkingLot.strategy.spotfinder.FirstSpotStrategy;

public class Main {

    public static void main( String args[] )
    {
        System.out.println(" ***************************** Parking Lot Design ******************************* ");

        // ================== setting the actors of the parking lot ======================

        ParkingLotManager parkingLot = ParkingLotManager.getInstance();

        // setting the fee + spot finder strategy  --> yb admin
        parkingLot.setParkingFeeStrategy( new PremiumMinuteFeeStrategy());
        parkingLot.setSpotFinderStrategy( new FirstSpotStrategy() );


        // creating 4 Parking Spots , per floor
        ParkingSpot spot1 = new ParkingSpot( "1-1" , VehicleTypeEnum.CAR );
        ParkingSpot spot2 = new ParkingSpot( "1-2" , VehicleTypeEnum.TWOWHEELER );
        ParkingSpot spot3 = new ParkingSpot( "1-3" , VehicleTypeEnum.AUTO );
        ParkingSpot spot4 = new ParkingSpot( "1-4" , VehicleTypeEnum.CAR );

        
        ParkingSpot spot5 = new ParkingSpot( "2-1" , VehicleTypeEnum.TRUCK );    
        ParkingSpot spot6 = new ParkingSpot( "2-2" , VehicleTypeEnum.TWOWHEELER );
        ParkingSpot spot7 = new ParkingSpot( "2-3" , VehicleTypeEnum.AUTO );
        ParkingSpot spot8 = new ParkingSpot( "2-4" , VehicleTypeEnum.CAR );

        // add parking spots to parking floor  2 floors for now
        List<ParkingSpot> floor1Spots = new ArrayList<>();
        floor1Spots.add( spot1 );
        floor1Spots.add( spot2 );
        floor1Spots.add( spot3 );
        floor1Spots.add( spot4 );

         List<ParkingSpot> floor2Spots = new ArrayList<>();
        floor2Spots.add( spot5 );
        floor2Spots.add( spot6 );
        floor2Spots.add( spot7 );
        floor2Spots.add( spot8 );

        // creating parking floors
        Floor floor1 = new Floor( 1 , floor1Spots);
        Floor floor2 = new Floor( 2 , floor2Spots);         // floor with spots created


        // adding floors to parking lot
        parkingLot.setFloor( 1, floor1 );
        parkingLot.setFloor( 2, floor2 );



        // create 2 users with their vehicles  + creating subscribers for notification
        User user1 = new User( 1 ,"User1" , "9999999999" , "user1@mail.com");

        // user1 wants SMS notification + email notification
        ChannelInterface channel1  = new SMSChannel();
        ChannelInterface channel2  = new EmailChannel();
        user1.addPreferredChannel(channel1);
        user1.addPreferredChannel(channel2);

        // user1 subscribed to parking lot manager
        parkingLot.subscribe( user1 );

        User user2 = new User( 2 ,"User2" , "99876756" , "user2@mail.com");

        // user2 wants only email notification
        ChannelInterface channel3  = new EmailChannel( );
        user2.addPreferredChannel(channel3);

        // user2 subscribed to parking lot manager
        parkingLot.subscribe( user2 );

        // mapping the userid : user object
        parkingLot.setUsers( user1.id , user1 );
        parkingLot.setUsers( user2.id , user2 );
    


        // creating the vehicles + purchasing the tickets for parking
        Vehicle vehicle1 = VehicleFactory.createVehicle( UUID.randomUUID().toString(), VehicleTypeEnum.CAR );  // uer 1 vehicle
        Vehicle vehicle2 = VehicleFactory.createVehicle( UUID.randomUUID().toString(), VehicleTypeEnum.TRUCK ); // user 2 vehicle
        

        // purchase parking pass for user1 and user2
        Ticket ticket1 = parkingLot.purchaseParkingPass( user1 , vehicle1 );
        Ticket ticket2 = parkingLot.purchaseParkingPass( user2 , vehicle2 );


        // ==================  ACTIONS ======================

        parkingLot.parkVehicle(user1, ticket1);
        parkingLot.parkVehicle(user2, ticket2);

        
        // before unparking setting the payment strategy for users
        user1.setPaymentStrategy(new CreditCardPaymentStrategy());
        user2.setPaymentStrategy(new UPIPaymentStrategy());

        // unparking the vehicles
        Double cost1 = parkingLot.unparkVehicle( ticket1 );
        Double cost2 = parkingLot.unparkVehicle( ticket2 );

        // finally pay the amounts
        user1.payParkingFee( cost1 );
        user2.payParkingFee( cost2 );


       

        
    }
    
}
