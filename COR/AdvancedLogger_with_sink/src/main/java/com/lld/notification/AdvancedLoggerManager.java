package com.lld.notification;

import com.lld.notification.entities.Logger;
import com.lld.notification.entities.enums.LOGGER_TYPE;
import com.lld.notification.entities.enums.LOG_LEVEL;
import com.lld.notification.entities.enums.SINK_TYPE;
import com.lld.notification.factory.Sink;
import com.lld.notification.strategy.LoggerStrategyfactory;
import java.util.List;

public class AdvancedLoggerManager {

    // create config

//    Ts_format: any format
//    log_level:INFO
//    logger_type:ASYNC
//    buffer_size:25
//    sink_type:STDOUT



    public Logger config(String name , LOGGER_TYPE loggerType, LOG_LEVEL log_level , Integer buffer  , SINK_TYPE sink , List<Sink>list)
    {
        return Logger.builder()
                .sinkType(sink)
                .name(name)
                .buffer(buffer)
                .logStrategy( LoggerStrategyfactory.getStrategy(loggerType , list ))
                .build();
    }

}
