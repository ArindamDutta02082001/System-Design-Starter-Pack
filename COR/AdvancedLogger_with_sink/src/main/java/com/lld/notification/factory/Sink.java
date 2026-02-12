package com.lld.notification.factory;

import com.lld.notification.entities.Message;
import com.lld.notification.entities.enums.LOG_LEVEL;
import com.lld.notification.entities.enums.SINK_TYPE;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Sink {

    LOG_LEVEL log_level;
    SINK_TYPE sinkType;

    public Sink(LOG_LEVEL log_level , SINK_TYPE sinkType)
    {
        this.log_level = log_level;
        this.sinkType = sinkType;
    }

    // print()
    public abstract void print(Message message);
}
