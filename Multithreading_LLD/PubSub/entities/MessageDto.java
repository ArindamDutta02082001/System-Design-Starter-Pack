package ObserverPattern.PubSub.entities;

import java.time.Instant;

public class MessageDto {
    
    public String messageString;
    public Instant timeStamp;

    public MessageDto(String messageString , Instant timeStamp)
    {
        this.messageString = messageString;
        this.timeStamp = timeStamp;
    }

}
