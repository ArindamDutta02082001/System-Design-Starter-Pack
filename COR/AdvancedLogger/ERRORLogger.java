package COR.AdvancedLogger;

public class ERRORLogger implements LoggerManager {
   
    LoggerManager next = null ;     // this is doing the chaining to the next logger manager
    
    ERRORLogger( LoggerManager loggerManager)
    {
        this.next = loggerManager;
    }

    public void print( LogEnum logEnum , String message )
    {
        if( logEnum == LogEnum.ERROR)
            System.out.println( "[ERROR] "+message);
        else
            if(next != null)
            next.print(logEnum, message);
    }


 }
