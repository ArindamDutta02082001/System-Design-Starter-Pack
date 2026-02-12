package com.lld.notification.strategy;

import com.lld.notification.entities.enums.LOGGER_TYPE;
import com.lld.notification.entities.enums.LOG_LEVEL;
import com.lld.notification.entities.enums.SINK_TYPE;
import com.lld.notification.factory.DBSink;
import com.lld.notification.factory.FileSink;
import com.lld.notification.factory.Sink;
import com.lld.notification.factory.StdoutSink;

import java.util.List;

public class LoggerStrategyfactory {

    public static LogStrategy getStrategy(LOGGER_TYPE loggerType , List<Sink> sinkList)
    {
        return switch (loggerType) {
            case ASYNC -> new AsyncLogStrategy(sinkList, 2);
            case SYNC -> new SyncLogStrategy(sinkList);
            default -> null;
        };

    }
}
