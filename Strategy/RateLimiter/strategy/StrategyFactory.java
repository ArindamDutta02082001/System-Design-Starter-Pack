package Strategy.RateLimiter.strategy;


import Strategy.RateLimiter.entity.UserEnum;

// using a factory pattern
public class StrategyFactory {

    public static  RateLimiterStrategy getRateLimitingStartefy(UserEnum userEnum)
    {
        if( userEnum == UserEnum.FREE )
            return new FixedWindowStrategy( 3 , 1000);
        else if( userEnum == UserEnum.PREMIUM )
            //return  new SlidingWindowStrategy(5 , 3000);
            return  new TokenBucketStrategy(3 , (double) 2 /10);   //1token/10s

        return null;
    }
}
