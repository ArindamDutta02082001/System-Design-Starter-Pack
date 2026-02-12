package com.lld.notification;

import com.lld.notification.entities.Logger;
import com.lld.notification.entities.Message;
import com.lld.notification.entities.enums.LOGGER_TYPE;
import com.lld.notification.entities.enums.LOG_LEVEL;
import com.lld.notification.entities.enums.SINK_TYPE;
import com.lld.notification.factory.Sink;
import com.lld.notification.factory.Sinkfactory;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalUnit;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AdvancedLogger {

	public static LOG_LEVEL getLogLevel ( int n )
	{
		switch (n)
		{
			case 1:
				return LOG_LEVEL.INFO;
			case 2:
				return LOG_LEVEL.WARN;
			case 3:
				return LOG_LEVEL.ERROR;
			default:
				return LOG_LEVEL.DEBUG;
		}
	}

	public static void main(String[] args) throws InterruptedException {

		// actors

		AdvancedLoggerManager advancedLoggerManager = new AdvancedLoggerManager();



		// sink
		Sink stdout =  Sinkfactory.getSink(SINK_TYPE.STDOUT , LOG_LEVEL.INFO);
		Sink file =  Sinkfactory.getSink(SINK_TYPE.FILE , LOG_LEVEL.ERROR);

		// logger
		Logger ll = advancedLoggerManager.config("FLIP_LOGGER" , LOGGER_TYPE.ASYNC, LOG_LEVEL.INFO , 5 , SINK_TYPE.STDOUT , List.of(stdout,file));


		// linking
		ll.addSink(stdout);				// logger k andar sinks sotre krne ki jrrot nhi hai
		ll.addSink(file);

		// actions


		for( int i=0;i<10;i++)
		{
			int rand = (int)(Math.random()*3)+1;
			LOG_LEVEL l = getLogLevel(rand);
			Message message = new Message( LocalDateTime.now() , l , "this is a mssg : "+l.toString() );
			System.out.println(message.getMessage()+" is put");
			ll.send(message);
		}
	}

}
