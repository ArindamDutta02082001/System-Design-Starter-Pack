package ObserverPattern.PubSub.entities;

import java.time.Instant;
import java.util.*;

import ObserverPattern.PubSub.observer.publisher.Subject;

public class  Publisher {

    // list of topics
    List<Topic> topicList = new ArrayList<>();

    // **vvi identify the subject properly
    // List of observers --> No , it is said each topic should have own subscribers
    // "Subscribers should be able to subscribe to topics of interest and receive messages published to those topics"
    // so instead of storing the subs here we have to store in topic as topic is the subject

    //  List<Observerr> subscriberList;

    // publisher fn
    public void publishToTopic( TopicEnum topicEnum , String message )
    {
        // forming the MessageDto
        MessageDto newMessageDto = new MessageDto(message, Instant.now());

        for( Topic t : topicList )
        {
            if(t.topicEnum.equals(topicEnum) )            {
                t.addMessageToTopic(newMessageDto);  // add message + trigger notifyObserver
                System.out.println(topicEnum+" "+message+" published");

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
