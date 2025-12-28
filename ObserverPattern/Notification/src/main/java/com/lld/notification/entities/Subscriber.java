package com.lld.notification.entities;


import com.lld.notification.entities.enums.MESSAGE_TYPE;
import com.lld.notification.entities.enums.TOPIC_ENUMS;
import com.lld.notification.observer.subscriber.Observerr;
import com.lld.notification.observer.subscriber.channel.IChannel;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Subscriber extends Observerr {

    List<IChannel> subsChannel;

    List<MESSAGE_TYPE>preferredist;

    public Subscriber( String name , String email , String phone)
    {
        super(name , email , phone);
        subsChannel = new ArrayList<>();
        preferredist = new ArrayList<>();
    }

    // fn to add different channel per user/subscriber
    public void addChannel( IChannel ch )
    {
        subsChannel.add(ch);
    }

    // update fn
    @Override
    public void update(MessageDto message , TOPIC_ENUMS TOPICENUMS)
    {
//        if( preferredist.contains(message.messageType) )  // then ony send the notification
        // paused for now

        for( IChannel channel : subsChannel )
        {
            channel.notifyChannel(message , TOPICENUMS,this);
        }
    }



}
