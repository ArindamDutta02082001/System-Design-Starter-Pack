package ObserverPattern.PubSub;


import ObserverPattern.PubSub.entities.Topic;
import ObserverPattern.PubSub.entities.Subscriber;
import ObserverPattern.PubSub.entities.enums.TOPIC_ENUM;
import ObserverPattern.PubSub.entities.Publisher;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.Thread.sleep;

public class Main {

    public static void main(String[] args) throws InterruptedException {



        // ************************** ACTORS *******************

        PubSubManager pubSubManager = new PubSubManager();

        // creating topics

        Topic techTopic = new Topic(TOPIC_ENUM.TECH_TOPIC);
        Topic newsTopic = new Topic(TOPIC_ENUM.NEWS_TOPIC);
        Topic sportsTopic = new Topic(TOPIC_ENUM.SPORTS_TOPIC);

        // creating subs

        // ANIL KAPOOR ka 2 thread chlega na
        Subscriber s01 = new Subscriber("Anil Kapoor" , techTopic);
        Subscriber s02 = new Subscriber("Anil Kapoor" , newsTopic);

        // MODI BHAI ka bhi 2 hai
        Subscriber s11 = new Subscriber("Modi Bhai" , techTopic);
        Subscriber s12 = new Subscriber("Modi Bhai" , sportsTopic);

        // creating publisher

        Publisher p1 = new Publisher(pubSubManager);
        Publisher p2 = new Publisher(pubSubManager);

        // **************** relationship ***************

        // subs subscribing topics
        techTopic.registerSubscriber(s01);
        techTopic.registerSubscriber(s11);

        newsTopic.registerSubscriber(s02);

        sportsTopic.registerSubscriber(s12);


        // ******************** actions ********************************


        // starting the subsribers
        pubSubManager.startSubs(s11);
        pubSubManager.startSubs(s12);
        pubSubManager.startSubs(s01);
        pubSubManager.startSubs(s02);

        pubSubManager.addTopicInPublisher(TOPIC_ENUM.TECH_TOPIC,techTopic);
        pubSubManager.addTopicInPublisher(TOPIC_ENUM.SPORTS_TOPIC,sportsTopic);
        pubSubManager.addTopicInPublisher(TOPIC_ENUM.NEWS_TOPIC,newsTopic);


        // pushing mssges at 5 sec intervals
        p1.publishToTopic(TOPIC_ENUM.TECH_TOPIC, "AGI is released by Elon :) ");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        p2.publishToTopic(TOPIC_ENUM.SPORTS_TOPIC, "Virat is playng football");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        p2.publishToTopic(TOPIC_ENUM.NEWS_TOPIC, "Bang Bang in Bangalore increasing");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        p1.publishToTopic(TOPIC_ENUM.TECH_TOPIC, "Pak pak pak in tech mkc :) ");

        System.out.println("Replaying testing");

        // s11 modi bhai ka hai -- tech topic replay from start =0
        s11.topic.replay(s11,0);

        pubSubManager.shutdown();

    }
    
}
