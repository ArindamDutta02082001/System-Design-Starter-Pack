package ObserverPattern.PubSub.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import ObserverPattern.PubSub.subscriber.Subscriber;


public class Topic {


    public TopicEnum topicEnum;

    // a  topic is just a queue
    // ConcurrentLinkedQueue<MessageDto> queue ;

    // list of subscribers
    List<Subscriber> subsList;

    public Topic( TopicEnum topicEnum)
    {
        this.topicEnum = topicEnum;
        // queue = new ConcurrentLinkedQueue<>();
        subsList = new ArrayList<>();
    }



    // queue mei broadcast
    public void publish( MessageDto message )
    {
        // queue.add(message);
        broadcastAll(message);
    }


    // broadcast on reveiving new MessageDto
    void broadcastAll(MessageDto messageDto)
    {
        for( Subscriber s : subsList )
        {
            s.update(messageDto);
        }

    }


    // subsribe and unsubscribe from a topic

    public void subsribe( Subscriber s)
    {
        subsList.add(s);
        System.out.println(s.name+ " Subscribed to : "+topicEnum.toString());
    }
    
    public void unsubsribe( Subscriber s)
    {
        subsList.remove((Subscriber)s);
        System.out.println(s.name+ " Unsubscribed to : "+topicEnum.toString());
    }




    
}
