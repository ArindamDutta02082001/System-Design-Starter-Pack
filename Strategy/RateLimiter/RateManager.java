package Strategy.RateLimiter;

import Strategy.RateLimiter.entity.User;
import Strategy.RateLimiter.strategy.RateLimiterStrategy;
import Strategy.RateLimiter.strategy.StrategyFactory;

import java.util.HashMap;
import java.util.Map;

public class RateManager {

    //
    Map<String, RateLimiterStrategy> mp = new HashMap<>();

    public void registerUser(User u)
    {
        mp.put(u.userId , StrategyFactory.getRateLimitingStartefy(u.userEnum));
    }

    //
    public boolean hit( String id )
    {
        return mp.get(id).allowRequest(id);
    }

}
