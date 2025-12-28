package com.lld.notification.entities;

import com.lld.notification.entities.enums.MESSAGE_TYPE;

import java.time.Instant;

public class MessageDto {
    
    public String messageString;
    public Instant timeStamp;

    public MESSAGE_TYPE messageType;

    public MessageDto(String messageString , Instant timeStamp , MESSAGE_TYPE messageType)
    {
        this.messageString = messageString;
        this.timeStamp = timeStamp;
        this.messageType = messageType;
    }

}
