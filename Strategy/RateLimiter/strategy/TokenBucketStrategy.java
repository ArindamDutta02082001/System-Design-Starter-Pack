package Strategy.RateLimiter.strategy;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

public class TokenBucketStrategy implements RateLimiterStrategy{

    // since bucket so we must have --- token per user , maxTokenLimit , refill rate of the tokens

    double refillRate;  // tokens/s should be refilled

    int maxTokenPerUser;
    Map<String , Integer> tokens;

    Map<String, LocalDateTime> lastRefilled;


    public TokenBucketStrategy(  int token , double refillRate  )
    {
        this.refillRate =refillRate;
        this.maxTokenPerUser=token;
        tokens = new HashMap<>();
        lastRefilled = new HashMap<>();
    }
    public boolean allowRequest( String userId)
    {
        LocalDateTime curr = LocalDateTime.now();

        // setting the hashmaps if userid new
        tokens.putIfAbsent(userId,maxTokenPerUser);
        lastRefilled.putIfAbsent(userId,curr);

        // before token consumption , refill
        double elapsedTime = Duration.between(lastRefilled.get(userId) ,curr ).toSeconds();
        int oldTokens = tokens.get(userId);
        tokens.put(userId , Math.min(maxTokenPerUser , oldTokens+(int)(elapsedTime*refillRate) ) );
        lastRefilled.put(userId , LocalDateTime.now());

        if(tokens.get(userId) >0 )
        {
            tokens.put(userId , tokens.get(userId)-1);
            return true;
        }

        return false;

    }




}
