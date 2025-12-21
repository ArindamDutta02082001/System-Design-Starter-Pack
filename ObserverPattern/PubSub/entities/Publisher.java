package ObserverPattern.PubSub.entities;

import java.time.Instant;
import java.util.*;

import ObserverPattern.PubSub.observer.publisher.Subject;

public class  Publisher {

    // list of topics
    List<Topic> topicList = new ArrayList<>();


    // publisher fn
    public void publishToTopic( TopicEnum topicEnum , String message )
    {
        // forming the MessageDto
        MessageDto newMessageDto = new MessageDto(message, Instant.now());

        for( Topic t : topicList )
        {
            if(t.topicEnum.equals(topicEnum) )
            {
                t.notifyObservers(newMessageDto);
                return;
            }
        }
        System.out.println(" No topic found to broadcast your message !!");

    }

    // adding topic 
    public void addTopicInPublisher( Topic topic)
    {
        topicList.add(topic);
    }






    
}
