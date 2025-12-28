package com.lld.notification.entities;

import com.lld.notification.entities.enums.MESSAGE_TYPE;
import com.lld.notification.entities.enums.TOPIC_ENUMS;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class  Publisher {

    // list of topics
    List<Topic> topicList = new ArrayList<>();

    // **vvi identify the subject properly
    // List of observers --> No , it is said each topic should have own subscribers
    // "Subscribers should be able to subscribe to topics of interest and receive messages published to those topics"
    // so instead of storing the subs here we have to store in topic as topic is the subject

    //  List<Observerr> subscriberList;



    // publisher fn
    public void publishToTopic(TOPIC_ENUMS TOPICENUMS, String message , MESSAGE_TYPE messageType)
    {
        // forming the MessageDto
        MessageDto newMessageDto = new MessageDto(message, Instant.now(), messageType );

        for( Topic t : topicList )
        {
            if(t.TOPICENUMS.equals(TOPICENUMS) )            {
                System.out.println(TOPICENUMS +" "+message+" published");
                t.addMessageToTopic(newMessageDto);  // add message + trigger notifyObserver

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
