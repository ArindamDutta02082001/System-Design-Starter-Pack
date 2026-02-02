package com.lld.notification.factory;

import com.lld.notification.entities.enums.LOG_LEVEL;
import com.lld.notification.entities.enums.SINK_TYPE;

public class Sinkfactory {

    public static Sink getSink(SINK_TYPE sinkType , LOG_LEVEL log_level )
    {
        switch (sinkType)
        {
            case FILE:
                return new FileSink(log_level , sinkType);
            case DB:
                return new DBSink(log_level , sinkType);
            case STDOUT :
                return new StdoutSink(log_level , sinkType);
            default:
                return null;

        }

    }
}
