package ParkingLot;

import java.util.*;
// import java.util.concurrent.Flow.Subscriber; // Remove this import if you are not using Java's Flow API


import ParkingLot.Entities.ParkingFloor;
import ParkingLot.Entities.ParkingSpot;
import ParkingLot.Entities.Ticket;
import ParkingLot.Entities.User;
import ParkingLot.Entities.Vehicle;
import ParkingLot.Entities.VehicleTypeEnum;
import ParkingLot.Service.ParkingFeeService.BasicMinuteFee;
import ParkingLot.Service.ParkingFeeService.ParkingFeeStrategy;
import ParkingLot.Service.PaymentService.CreditCardPayment;
import ParkingLot.Service.PaymentService.DebitCardPayment;
import ParkingLot.Service.PaymentService.PaymentService;
import ParkingLot.Service.PaymentService.UPIPayment;
import ParkingLot.Service.NotificationService.SMSSubscriber;
import ParkingLot.Service.NotificationService.SubscriberInterface;
import ParkingLot.Service.VehicleService.VehicleFactory;

public class ParkingDemo {

    public static void main( String args[] )
    {
        System.out.println("Parking Lot Design");

        // create parking lot
        ParkingLotMainService parkingLot = ParkingLotMainService.getInstance();


        // creating Parking Spots
        ParkingSpot spot1 = new ParkingSpot( "S1" , VehicleTypeEnum.CAR );
        ParkingSpot spot2 = new ParkingSpot( "S2" , VehicleTypeEnum.TWOWHEELER );
        ParkingSpot spot3 = new ParkingSpot( "S3" , VehicleTypeEnum.AUTO );
        ParkingSpot spot4 = new ParkingSpot( "S4" , VehicleTypeEnum.CAR );
        ParkingSpot spot5 = new ParkingSpot( "S5" , VehicleTypeEnum.TRUCK );    
        ParkingSpot spot6 = new ParkingSpot( "S6" , VehicleTypeEnum.TWOWHEELER );
        ParkingSpot spot7 = new ParkingSpot( "S7" , VehicleTypeEnum.AUTO );
        ParkingSpot spot8 = new ParkingSpot( "S8" , VehicleTypeEnum.CAR );

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
        ParkingFloor floor1 = new ParkingFloor( "F1" , floor1Spots);
        ParkingFloor floor2 = new ParkingFloor( "F2" , floor2Spots);

        // adding floors to parking lot
        parkingLot.setFloor( floor1 );
        parkingLot.setFloor( floor2 );

        ////////////////////////////////// INFRASTRUCTURE DONE ////////////////////////


        // now we will stimulate the activities in the parking lot

        // create 2 users with their vehicles
        User user1 = new User( 1 ,"User1" );
        parkingLot.listOfUser.add(user1);
        Vehicle vehicle1 = VehicleFactory.createVehicle( UUID.randomUUID().toString(), VehicleTypeEnum.CAR , "red" );
        
        User user2 = new User( 2 ,"User2" );
        parkingLot.listOfUser.add(user2);
        Vehicle vehicle2 = VehicleFactory.createVehicle( UUID.randomUUID().toString(), VehicleTypeEnum.TRUCK , "brown" );

        

        // purchase parking pass for user1
        Ticket ticket1 = parkingLot.purchaseParkingPass( user1 , vehicle1 );
        Ticket ticket2 = parkingLot.purchaseParkingPass( user2 , vehicle2 );

        // hardcoding few users as their cars are parked
        parkingLot.parkVehicle(user1, ticket1, 0);
        parkingLot.parkVehicle(user2, ticket2, 1);

        parkingLot.getAvailableSpots();

        ParkingFeeStrategy strategy = new BasicMinuteFee();
        parkingLot.setParkingFeeStrategy( strategy );


        Scanner sc = new Scanner(System.in);
        Character option = 'Y';
     
        
        
        while( option != 'n' && option != 'N' )
        {

            System.out.print("Press A to park , B to unpark and exit !!!");
            Character ch  = Character.toLowerCase(sc.next().charAt(0));

            if( ch == 'a' )
            {
            // input
            System.out.print("Enter the user id and the name");
            int n = sc.nextInt();
            sc.nextLine();              // consume leftover newline
            String name = sc.nextLine();
            
            User newUser = new User( n ,name );
                
            // create subscriber and subscribe the user for notification
                    SubscriberInterface newSubscriber  = new SMSSubscriber(name);
                    parkingLot.subs( newSubscriber );

            if( parkingLot.isUserPresent(newUser))
                System.out.print("No need to register again , purchase ticket !");
            else 
            {
                    parkingLot.listOfUser.add(newUser);
                    System.out.print(" User registered !");
                }
                
                // parking the vehicle
                System.out.println(" On which floor you want to park");
                int floor =  sc.nextInt();
                System.out.println("Enter Vehicle details");
                // hardcoding for now the vehicle details
                Vehicle newVehicle = VehicleFactory.createVehicle( UUID.randomUUID().toString(), VehicleTypeEnum.AUTO , "brown" );


                // purchasing the ticket
                Ticket newTicket = parkingLot.purchaseParkingPass(newUser, newVehicle);

                if( parkingLot.parkVehicle(newUser, newTicket, floor) )
                {
                    System.out.println( newUser.name+" parked the "+vehicle1.vehicleType+" is parked in floor : "+floor);
                }
                else     {
                    System.out.println( "Sorry full !!!");
                }
            }

            else if( ch == 'b')
            {
                
                System.out.println( "How you would like to pay the bill ? 1. Credit Card 2. UPI 3. Debit Card");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1: parkingLot.paymentService = new PaymentService( new CreditCardPayment() ); break;
                    case 2: parkingLot.paymentService = new PaymentService( new UPIPayment() ); break;
                    case 3: parkingLot.paymentService = new PaymentService( new DebitCardPayment() );  break;
                    default: System.out.println("Invalid choice"); return;
                    }
                Double bill = parkingLot.unparkVehicle( ticket1 );
                if( bill != 0 )                {
                    System.out.println( user1.name+" unparked the "+vehicle1.vehicleType);

                    // pay the bill
                    parkingLot.pay(bill);

                    // ntify the user
                   
                }
                else                 {
                    System.out.println( "Some error occured !!!");

                }

                parkingLot.getAvailableSpots();
                
            }
            else if( ch == 'c' )
            {
                System.out.println( "Available spots in parking lot");
                parkingLot.getAvailableSpots();

            }

            
            
            
            
            System.out.println( "Do you want to continue");
            option = sc.next().charAt(0);

        }



        
    }
    
}
