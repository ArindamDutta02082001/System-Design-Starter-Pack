package ObserverPattern.PubSub.entities;

import ObserverPattern.PubSub.observer.publisher.Subject;
import ObserverPattern.PubSub.observer.subscriber.Observerr;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class Topic  implements Subject  {


    public TopicEnum topicEnum;



    // list of subscribers
    List<Observerr> subscriberList;

    // to store the messages per Topic  , for no loss of messages
    // a  topic is just a queue
    List<MessageDto> messageList;
    Map<Observerr,Integer> subscriberOffset;

    public Topic( TopicEnum topicEnum)
    {
        this.topicEnum = topicEnum;
        // queue = new ConcurrentLinkedQueue<>();
        subscriberList = new ArrayList<>();
        subscriberOffset = new ConcurrentHashMap<>();
    }



    // subscribe and unsubscribe from a topic

    @Override
    public void registerObserver( Observerr s)
    {
        subscriberList.add(s);
        subscriberOffset.put(s,0);
        System.out.println(s.name+ " Subscribed to : "+topicEnum.toString());
    }

    @Override
    public void unregisterObserver( Observerr s)
    {
        subscriberList.remove(s);
        subscriberOffset.remove(s);
        System.out.println(s.name+ " Unsubscribed to : "+topicEnum.toString());
    }


    // THIS DONT HAPPEN in PUB-SUB , in pub sub no publisher calls update
    // instead subscriber polls

//    @Override
    public void  notifyObservers( MessageDto message )
    {
//        for( Observerr s : subscriberList )  {
//            s.update(message, topicEnum);
//        }
    }

    public void addMessageToTopic( MessageDto messageDto )
    {
        messageList.add(messageDto);
//        notifyObservers(messageDto);
    }

    // additional functionality to replay message
    public void replay(Observerr observerr , Integer offset )
    {
        for( MessageDto m : messageList.subList(offset,messageList.size()) )
            System.out.println("[REPLAYED] - "+observerr.name+" - "+m.messageString );
    }

    
}
