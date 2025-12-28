package COR.Logger;

public class WARNLogger implements LoggerCORInterface {

    LoggerCORInterface next = null ;     // this is doing the chaining to the next logger manager

    WARNLogger( LoggerCORInterface loggerCORInterface)
    {
        this.next = loggerCORInterface;
    }

    public void print( LogEnum logEnum , String message )
    {
        if( logEnum == LogEnum.WARN)
            System.out.println( "[ERROR] "+message);
        else
            if(next != null)
            next.print(logEnum, message);

    }
}
