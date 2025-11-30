package Strategy.RateLimiter.strategy;

public interface RateLimiterStrategy {

    public abstract boolean allowRequest( String userId);
}
