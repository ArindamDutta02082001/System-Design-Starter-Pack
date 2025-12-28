package com.lld.notification;


import com.lld.notification.entities.Publisher;
import com.lld.notification.entities.Subscriber;
import com.lld.notification.entities.Topic;
import com.lld.notification.entities.enums.MESSAGE_TYPE;
import com.lld.notification.entities.enums.TOPIC_ENUMS;
import com.lld.notification.observer.subscriber.channel.EmailChannel;
import com.lld.notification.observer.subscriber.channel.IChannel;
import com.lld.notification.observer.subscriber.channel.PhoneChannel;

public class Main {

	public static void main(String[] args) {



		// ************************** ACTORS *******************

		NotificationManager notificationManager = new NotificationManager();

		// creating topics

		Topic techTopic = new Topic(TOPIC_ENUMS.TECH_TOPIC);
		Topic newsTopic = new Topic(TOPIC_ENUMS.NEWS_TOPIC);
		Topic sportsTopic = new Topic(TOPIC_ENUMS.SPORTS_TOPIC);

		// creating subs

		// s1 channel to email , phone both
		IChannel ch1 = new EmailChannel();
		IChannel ch2 = new PhoneChannel();
		Subscriber s1 = new Subscriber("Anil Kapoor" , "anil@email.com" , "123400000567" );
		s1.addChannel(ch1);
		s1.addChannel(ch2);


		// s2 channel to email
		IChannel ch3 = new EmailChannel();
		Subscriber s2 = new Subscriber("Modi Bhai" , "modi@email.com" , "12398765437" );
		s2.addChannel(ch3);

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

		p1.publishToTopic(TOPIC_ENUMS.TECH_TOPIC, "AGI is released by Elon :) " , MESSAGE_TYPE.TECH_NEWS);
		p2.publishToTopic(TOPIC_ENUMS.SPORTS_TOPIC, "Virat is playng football" , MESSAGE_TYPE.SPORTS_NEWS);
		p2.publishToTopic(TOPIC_ENUMS.NEWS_TOPIC, "Bang Bang in Bangalore increasing" , MESSAGE_TYPE.GENERAL_NEWS);


		/**
		 * Anil Kapoor Subscribed to : TECH_TOPIC
		 * Modi Bhai Subscribed to : TECH_TOPIC
		 * Anil Kapoor Subscribed to : NEWS_TOPIC
		 * Modi Bhai Subscribed to : SPORTS_TOPIC
		 *
		 *
		 * lke this it will come
		 * SPORTS_TOPIC Virat is playng football published    --> ye topic is subs only by modi , modis pref is email very busy guy
		 * [INCOMING] - EMAIL - modi@email.com - SPORTS_TOPIC - Virat is playng football timestamp : 2025-12-28T08:17:20.480242Z
		 *
		 *
		 */

	}

}
