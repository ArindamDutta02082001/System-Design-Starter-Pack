package com.lld.notification.observer.subscriber;


import com.lld.notification.entities.MessageDto;
import com.lld.notification.entities.enums.TOPIC_ENUMS;
import lombok.Getter;

@Getter
public abstract class Observerr {

    public String name;
    public String email;
    public String mobile;

    public Observerr( String name , String email , String phone )
    {
        this.name=name;
        this.email = email;
        this.mobile = phone;
    }
    public abstract void update(MessageDto mssg , TOPIC_ENUMS TOPICENUMS);
}
