package Strategy.RateLimiter.entity;

public class User {
    public String userId;
    public UserEnum userEnum;

    public User( String id , UserEnum userEnum )
    {
        this.userEnum=userEnum;
        this.userId=id;
    }
}
