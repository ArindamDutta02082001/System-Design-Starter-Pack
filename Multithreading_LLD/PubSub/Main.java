package ObserverPattern.PubSub;


import ObserverPattern.PubSub.entities.Topic;
import ObserverPattern.PubSub.entities.Subscriber;
import ObserverPattern.PubSub.entities.TopicEnum;
import ObserverPattern.PubSub.entities.Publisher;

public class Main {

    public static void main(String[] args) {
        

        // ************************** ACTORS *******************

        PubSubManager pubSubManager = new PubSubManager();

        // creating topics

        Topic techTopic = new Topic(TopicEnum.TECH_TOPIC);
        Topic newsTopic = new Topic(TopicEnum.NEWS_TOPIC);
        Topic sportsTopic = new Topic(TopicEnum.SPORTS_TOPIC);

        // creating subs

        Subscriber s1 = new Subscriber("Anil Kapoor");
        Subscriber s2 = new Subscriber("Modi Bhai");

        // creating publisher

        Publisher p1 = new Publisher();
        Publisher p2 = new Publisher();

        // **************** relationship ***************

        techTopic.registerObserver(s1);
        techTopic.registerObserver(s2);

        newsTopic.registerObserver(s1);

        sportsTopic.registerObserver(s2);


        p1.addTopicInPublisher(techTopic);
        p2.addTopicInPublisher(sportsTopic);
        p2.addTopicInPublisher(newsTopic);


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // **************** ACTION *********************

        p1.publishToTopic(TopicEnum.TECH_TOPIC, "AGI is released by Elon :) ");
        p2.publishToTopic(TopicEnum.SPORTS_TOPIC, "Virat is playng football");
        p2.publishToTopic(TopicEnum.NEWS_TOPIC, "Bang Bang in Bangalore increasing");



    }
    
}
