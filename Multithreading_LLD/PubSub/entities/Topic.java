package ObserverPattern.PubSub.entities;

import ObserverPattern.PubSub.entities.enums.TOPIC_ENUM;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class Topic  {


    public TOPIC_ENUM TOPICENUM;

    // list of subscribers
    List<Subscriber> subscriberList;

    List<MessageDto> messageList; // to store the messages per Topic  , for no loss of messages
    Map<Subscriber,Integer> subscriberOffset;

    public Topic( TOPIC_ENUM TOPICENUM)
    {
        this.TOPICENUM = TOPICENUM;
        // queue = new ConcurrentLinkedQueue<>();
        this.messageList = new ArrayList<>();
        subscriberList = new ArrayList<>();
        subscriberOffset = new ConcurrentHashMap<>();
    }



    // subscribe and unsubscribe from a topic

    public void registerSubscriber( Subscriber s)
    {
        subscriberList.add(s);
        subscriberOffset.put(s,0);
        System.out.println(s.name+ " Subscribed to : "+ TOPICENUM.toString());
    }


    public void unregisterSubscriber( Subscriber s)
    {
        subscriberList.remove(s);
        subscriberOffset.remove(s);
        System.out.println(s.name+ " Unsubscribed to : "+ TOPICENUM.toString());
    }


    // THIS DONT HAPPEN in PUB-SUB , in pub sub no publisher calls update
    // instead subscriber polls
//
//    @Override
//    public void  notifyObservers( MessageDto message )
//    {
//        for( Observerr s : subscriberList )  {
//            s.update(message, TOPICENUM);
//        }
//    }

    public MessageDto poll(Subscriber subscriber) {
        int offset = subscriberOffset.get(subscriber);

        if (offset >= messageList.size()) {
            return null;
        }

        MessageDto msg = messageList.get(offset);
        subscriberOffset.put(subscriber, offset + 1);
        return msg;
    }


    public int getOffset( Subscriber subscriber) {
        return subscriberOffset.get(subscriber);
    }


    public void addMessageToTopic( MessageDto messageDto )
    {
        messageList.add(messageDto);
    }

    // additional functionality to replay message
    public void replay(Subscriber observerr , Integer offset )
    {
        for( MessageDto m : messageList.subList(offset,messageList.size()) )
            System.out.println("[REPLAYED] - "+observerr.name+" - message : "+m.messageString );
    }

    
}
