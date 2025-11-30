package Strategy.RateLimiter.strategy;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

public class FixedWindowStrategy implements RateLimiterStrategy {


    // defining the variables
    long windowSizeinms;

    int maxRequests;

    Map<String,Integer> requestCounts;  // to store the count of request of each user


    // particular to FIXED
    LocalDateTime windowStartTime;

    public FixedWindowStrategy( int maxRequests , long windowSizeinms )
    {
        this.maxRequests =maxRequests;
        this.windowSizeinms =windowSizeinms;
        requestCounts = new HashMap<>();
        windowStartTime = LocalDateTime.now();
    }

    @Override
    public boolean allowRequest( String userId) {

        //  check the time window if it is < windowSizeinms (fixed window)

        LocalDateTime currTime = LocalDateTime.now();
        if( Duration.between(windowStartTime ,currTime).toMillis() > windowSizeinms )
        {
            requestCounts.remove(userId);
            windowStartTime = LocalDateTime.now();
        }

        // and then start a fresh count of the request for the user
        requestCounts.put( userId , requestCounts.getOrDefault(userId , 0)+1);
        return requestCounts.get(userId) <= maxRequests;


    }
}
