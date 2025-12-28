package com.lld.notification.entities;


import com.lld.notification.entities.enums.TOPIC_ENUMS;
import com.lld.notification.observer.subscriber.Observerr;
import com.lld.notification.observer.subscriber.channel.IChannel;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Subscriber extends Observerr {

    List<IChannel> subsChannel;

    public Subscriber( String name , String email , String phone)
    {
        super(name , email , phone);
        subsChannel = new ArrayList<>();
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
        for( IChannel channel : subsChannel )
        {
            channel.notifyChannel(message , TOPICENUMS,this);
        }
    }



}
