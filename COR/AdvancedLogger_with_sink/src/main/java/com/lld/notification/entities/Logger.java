package com.lld.notification.entities;

import com.lld.notification.entities.enums.SINK_TYPE;
import com.lld.notification.factory.Sink;
import com.lld.notification.strategy.LogStrategy;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


@Getter
@Setter
@Builder
public class Logger {

    String name;

    @Builder.Default
    List<Sink> sinks = new ArrayList<>();

    SINK_TYPE sinkType;

    Integer buffer;

    LogStrategy logStrategy;


//    @Builder.Default
//    Deque<Message> messagesQueue = new ArrayDeque<>();

    /** first design mistake - if you thin you will
     * a synchronized queue is same as BlockingQueue
     * it will maintain the order of messages incoming from different threads
     * NOOOOOO !!
     * the usecase is typically a pub-sub : which is implemented via Blocking Queue
     */



    // add sink
    public void addSink( Sink sink )
    {
        if(sink.getSinkType() == sinkType)
            this.sinks.add(sink);
        else
            System.out.println("THIS SINK not allowed in this logger : "+sink.getSinkType());
    }

    // sync send
    public synchronized void send(Message message) {
        logStrategy.send(message);
    }



}
