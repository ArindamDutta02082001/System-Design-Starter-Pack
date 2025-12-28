package ObserverPattern.PubSub;

import java.util.*;
import java.util.concurrent.*;

import ObserverPattern.PubSub.entities.Subscriber;
import ObserverPattern.PubSub.entities.Topic;
import ObserverPattern.PubSub.entities.enums.TOPIC_ENUM;


public class PubSubManager {

    // list of topics
    public Map<TOPIC_ENUM , Topic> topicMap;

    ExecutorService executor;
    private final ScheduledExecutorService scheduler ;

    public PubSubManager()
    {
        topicMap = new HashMap<>();
        executor = Executors.newCachedThreadPool();
        scheduler =
                Executors.newScheduledThreadPool(5);
    }

    // get topi by TOPIC_ENUM
    public Topic getTopic( TOPIC_ENUM topicEnum )
    {
        return topicMap.get(topicEnum);
    }


    // adding topic
    public void addTopicInPublisher( TOPIC_ENUM topicEnum , Topic topic)
    {
        topicMap.put(topicEnum,topic);
    }


    // facade starting of subscribers
    public void startSubs(Subscriber subscriber ) throws InterruptedException {

//        executor.execute(subscriber);
        scheduler.scheduleAtFixedRate(
                ()->subscriber.run2(),   // task
                0,               // initial delay
                2,               // interval
                TimeUnit.SECONDS
        );
    }

    public void shutdown() {
        executor.shutdownNow();
    }


    
}
