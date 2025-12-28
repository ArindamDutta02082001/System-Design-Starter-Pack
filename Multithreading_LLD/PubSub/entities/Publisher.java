package ObserverPattern.PubSub.entities;

import java.time.Instant;
import java.util.*;

import ObserverPattern.PubSub.PubSubManager;
import ObserverPattern.PubSub.entities.enums.TOPIC_ENUM;

public class  Publisher {


    PubSubManager pubSubManager;
    public Publisher(PubSubManager pubSubManager)
    {
        this.pubSubManager = pubSubManager;
    }


    // publisher fn
    public void publishToTopic(TOPIC_ENUM TOPICENUM, String message )
    {
        // forming the MessageDto
        MessageDto newMessageDto = new MessageDto(message, Instant.now());

        for( TOPIC_ENUM t : pubSubManager.topicMap.keySet() )
        {
            if(t.equals(TOPICENUM) )            {
                pubSubManager.getTopic(TOPICENUM).addMessageToTopic(newMessageDto);  // add message + trigger notifyObserver
                System.out.println(TOPICENUM +" "+message+" published");
                return;
            }
        }
        System.out.println(" No topic found to broadcast your message !!");

    }








    
}
