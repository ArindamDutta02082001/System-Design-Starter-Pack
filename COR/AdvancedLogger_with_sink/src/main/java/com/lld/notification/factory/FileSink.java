package com.lld.notification.factory;

import com.lld.notification.entities.Message;

public class StdoutSink implements Sink{
    @Override
    public void print(Message message) {
        System.out.println(message.getDateTime() +" ["+ message.getLog_level()+"] "+ message.getMessage());
    }
}
