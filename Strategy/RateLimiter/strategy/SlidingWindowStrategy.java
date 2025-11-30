package Strategy.RateLimiter.strategy;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

public class SlidingWindowStrategy implements RateLimiterStrategy {

    // defining the variables
    Integer maxReq;

    long windowSizems;

    // it will be used as a normal queue here , no use of DQ
    Map<String, Deque<LocalDateTime>> reqCount;  // to store the userid and the list of req timestamp

    public SlidingWindowStrategy( int maxReq , long windowSizems )
    {
        this.maxReq = maxReq;
        this.windowSizems = windowSizems;
        reqCount = new HashMap<>();
    }

    @Override
    public boolean allowRequest(String userId) {


        // setting the hashmaps if userid new
        reqCount.putIfAbsent(userId, new LinkedList<>());

        // check the req that is incoming at this timestamp , is smaller than the
        // top timestamp of the deque of the user
        LocalDateTime currTime = LocalDateTime.now();

        Deque<LocalDateTime> dq = reqCount.get(userId);

        while( !dq.isEmpty() && Duration.between( dq.peek(),currTime ).toMillis() > windowSizems )
        {
            dq.poll();
        }

        if(dq.size() < maxReq )
        {
            dq.add(currTime);
            return true;
        }

        return false;



    }
}
