package ObserverPattern.PubSub;


import ObserverPattern.PubSub.entities.Topic;
import ObserverPattern.PubSub.subscriber.Subscriber;
import ObserverPattern.PubSub.entities.TopicEnum;
import ObserverPattern.PubSub.publisher.Publisher;

public class Main {

    public static void main(String[] args) {
        

        // ************************** ACTORS *******************

        // creating topics

        Topic techTopic = new Topic(TopicEnum.TECH_TOPIC);
        Topic newsTopic = new Topic(TopicEnum.NEWS_TOPIC);
        Topic sportsTopic = new Topic(TopicEnum.SPORTS_TOPIC);


        // creating subs

        Subscriber s1 = new Subscriber("AnilTV");
        Subscriber s2 = new Subscriber("MelonGeo");

        // creating publisher

        Publisher p1 = new Publisher();
        Publisher p2 = new Publisher();

        // **************** relationship ***************

        techTopic.subsribe(s1);
        techTopic.subsribe(s2);

        newsTopic.subsribe(s1);

        sportsTopic.subsribe(s2);


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
