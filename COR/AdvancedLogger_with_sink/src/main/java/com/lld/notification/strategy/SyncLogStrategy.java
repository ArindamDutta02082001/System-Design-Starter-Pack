package com.lld.notification.strategy;

import com.lld.notification.entities.Message;
import com.lld.notification.factory.Sink;

import java.time.LocalDateTime;
import java.util.List;

public class SyncLogStrategy extends LogStrategy {

    private final List<Sink> sinks;

    public SyncLogStrategy(List<Sink> sinks) {
        this.sinks = sinks;
    }

    @Override
    public synchronized void send(Message message) {

        for (Sink sink : sinks) {
            sink.print(message);
        }
    }
}
