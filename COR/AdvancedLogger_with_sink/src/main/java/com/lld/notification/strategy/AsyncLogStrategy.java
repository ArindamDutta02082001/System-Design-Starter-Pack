package com.lld.notification.strategy;

import com.lld.notification.entities.Message;
import com.lld.notification.entities.enums.LOG_LEVEL;
import com.lld.notification.factory.Sink;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AsyncLogStrategy extends LogStrategy {

    private final BlockingQueue<Message> queue;
    private final List<Sink> sinks;
    private final ExecutorService executor;

    public AsyncLogStrategy(List<Sink> sinks, int bufferSize) {
        this.sinks = sinks;
        this.queue = new ArrayBlockingQueue<>(bufferSize);

        this.executor = Executors.newFixedThreadPool(5);

        startConsumer();
    }

    private void startConsumer() {
        executor.submit(() -> {
            while (true) {
                Message msg = queue.take();   // BLOCKS safely
                for (Sink sink : sinks) {
                    sink.print(msg);
                }
            }
        });
    }

    @Override
    public void send(Message message) {

        executor.submit( ()->{

            try {
                queue.put(message);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        } );


    }
}

