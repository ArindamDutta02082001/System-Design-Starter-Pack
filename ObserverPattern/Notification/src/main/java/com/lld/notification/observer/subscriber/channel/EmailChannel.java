package com.lld.notification.observer.subscriber.channel;

import com.lld.notification.entities.MessageDto;
import com.lld.notification.entities.enums.TOPIC_ENUMS;
import com.lld.notification.observer.subscriber.Observerr;

public class EmailChannel implements IChannel{


    @Override
    public void notifyChannel(MessageDto message , TOPIC_ENUMS TOPICENUMS, Observerr observerr ) {
        System.out.println( "[INCOMING] - EMAIL - "+observerr.getEmail()+" - "+ TOPICENUMS.toString()+" - "+message.messageString+" timestamp : "+message.timeStamp.toString());
    }
}
