package com.lld.notification.observer.subscriber.channel;

import com.lld.notification.entities.MessageDto;
import com.lld.notification.entities.enums.TOPIC_ENUMS;
import com.lld.notification.observer.subscriber.Observerr;

public class PhoneChannel implements IChannel{


    @Override
    public void notifyChannel(MessageDto message , TOPIC_ENUMS TOPICENUMS, Observerr observerr ) {
        System.out.println( "[INCOMING] - PHONE - "+observerr.getMobile()+" - "+ TOPICENUMS.toString()+" - "+message.messageString+" timestamp : "+message.timeStamp.toString());
    }
}
