package com.lld.notification.observer.subscriber.channel;

import com.lld.notification.entities.MessageDto;
import com.lld.notification.entities.enums.TOPIC_ENUMS;
import com.lld.notification.observer.subscriber.Observerr;

public interface IChannel {

    public void notifyChannel(MessageDto message, TOPIC_ENUMS TOPICENUMS, Observerr observerr );
}
