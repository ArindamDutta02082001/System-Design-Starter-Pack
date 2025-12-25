package src.Entities;

public class OfferRide {

    public User user;
    public String source;
    public String destination;

    public Integer avaliable;

    public Vehicle vehicle;

    public OfferRide( User user, String src , String dest , Integer avaliable , Vehicle v)
    {
        this.user = user;
        this.source = src;
        this.destination = dest;
        this.avaliable = avaliable;
        this.vehicle = v;

    }
}
