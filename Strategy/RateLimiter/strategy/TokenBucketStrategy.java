package Strategy.RateLimiter.strategy;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

public class TokenBucketStrategy implements RateLimiterStrategy{

    // since bucket so we must have --- token per user , maxTokenLimit , refill rate of the tokens

    double refillRate;  // tokens/s should be refilled

    Map<String , Integer> tokensPerUserId;

    Map<String, LocalDateTime> lastRefilled;

    Integer maxTokenPerUser;


    public TokenBucketStrategy(  Map<String , Integer> tokensPerUserId, double refillRate , Integer maxTokenPerUser )
    {
        this.refillRate =refillRate;
        this.tokensPerUserId = tokensPerUserId;
        this.lastRefilled = new HashMap<>();
        this.maxTokenPerUser = maxTokenPerUser;
    }

    public boolean allowRequest( String userId)
    {
        LocalDateTime now = LocalDateTime.now();

        // setting the hashmaps if userid new
        lastRefilled.putIfAbsent(userId,now);

        // before token consumption , refill based on the refill rate * elaspedtime
        double elapsedTime = Duration.between(lastRefilled.get(userId) ,now ).toSeconds();
        int oldTokens = tokensPerUserId.get(userId);

        tokensPerUserId.put(userId , Math.min(maxTokenPerUser , oldTokens+(int)(elapsedTime*refillRate) ) );
        lastRefilled.put(userId , LocalDateTime.now());

        if(tokensPerUserId.get(userId) >0 )
        {
            tokensPerUserId.put(userId , tokensPerUserId.get(userId)-1);
            return true;
        }

        return false;

    }




}
