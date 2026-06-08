package Strategy.RateLimiter.entity;

public class User {
    public String userId;
    public UserTypeEnum userTypeEnum;

    public User( String id , UserTypeEnum userTypeEnum)
    {
        this.userTypeEnum = userTypeEnum;
        this.userId=id;
    }
}
