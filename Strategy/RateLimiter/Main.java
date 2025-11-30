package Strategy.RateLimiter;

import Strategy.RateLimiter.entity.User;
import Strategy.RateLimiter.entity.UserEnum;

public class Main {

    public static void main( String args[] ) throws InterruptedException {
        // setting the actors

        // USERS
        User freeUser = new User("Arindam" , UserEnum.FREE);
        User premiumUser = new User("Ayush" , UserEnum.PREMIUM);

        RateManager rm = new RateManager();
        rm.registerUser(freeUser);
        rm.registerUser(premiumUser);

        // actions


        // free user --> 3 req/sec
        // premium --> 5 req/5sec (sliding)  /  3 req/5sec after each 5sec 1 token is refilled as rate is 2/10

        // free user
        for( int i=0;i<6;i++)
        {
            System.out.println( "Free user hitting req"+(i+1)+" is "+rm.hit(freeUser.userId));
        }
        // intitiating the rest of 2sec
        Thread.sleep(2000);
        for( int i=6;i<12;i++)
        {
            System.out.println( "Free user hitting req"+(i+1)+" is "+rm.hit(freeUser.userId));
        }

        // premium user
        for( int i=0;i<6;i++)
        {
            System.out.println( "Prem user hitting req"+(i+1)+" is "+rm.hit(premiumUser.userId));
        }
        // intitiating the rest of 5sec
        Thread.sleep(5000);
        for( int i=6;i<12;i++)
        {
            System.out.println( "Prem user hitting req"+(i+1)+" is "+rm.hit(premiumUser.userId));
        }



    }
}
