package Strategy.RateLimiter.strategy;


import Strategy.RateLimiter.entity.UserTypeEnum;

import java.util.Map;

// using a factory pattern
public class StrategyFactory {

    public static  RateLimiterStrategy getRateLimitingStartefy(UserTypeEnum userTypeEnum ) {
        if (userTypeEnum == UserTypeEnum.FREE) {

            // in fixed SW , we need maxReq , windowSizeinms
            Integer maxReq = 3;
            Integer windowSizeinms = 1000;
            return new FixedWindowStrategy(maxReq, windowSizeinms);
        }
        else if (userTypeEnum == UserTypeEnum.PREMIUM) {


            //return  new SlidingWindowStrategy(5 , 3000);

            // in token bucket we need to have a map of <userid ,maxtokenPeruserId> , maxToken , refillRate ,  Map<String, LocalDateTime> lastRefilled;
            // this will come from some external api

            Map<String, Integer> userIdToUserEnumMap = Map.of("Ayush", 5, "Arindam", 3, "Harsh", 5);
            Integer maxToken = 4;
            double refillRate = (double) 2 / 10;
            return new TokenBucketStrategy(userIdToUserEnumMap, refillRate, maxToken);   //1token/10s
    }

        return null;
    }
}
