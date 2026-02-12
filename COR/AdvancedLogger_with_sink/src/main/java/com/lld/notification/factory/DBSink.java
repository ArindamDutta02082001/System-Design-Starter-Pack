package com.lld.notification.factory;

import com.lld.notification.entities.Message;
import com.lld.notification.entities.enums.LOG_LEVEL;
import com.lld.notification.entities.enums.SINK_TYPE;

public class DBSink extends Sink{
    public DBSink(LOG_LEVEL log_level , SINK_TYPE sinkType)
    {
        super(log_level , sinkType);
    }
    @Override
    public void print(Message message) {
        if(message.getLog_level().getLevel() >= this.log_level.getLevel() )
        System.out.println("TBD...for DB --> "+message.getMessage());
    }
}
