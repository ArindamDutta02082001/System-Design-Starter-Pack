package com.lld.notification.factory;

import com.lld.notification.entities.Message;

public class FileSink implements Sink{
    @Override
    public void print(Message message) {
        System.out.println("TBD...for files --> "+message.getMessage());
    }
}
