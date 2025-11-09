package COR.Logger;

public class WARNLogger extends LoggerManager {

    WARNLogger(LoggerManager loggerManager )
    {
        super(loggerManager);
    }

    @Override
    public void print( LogEnum logEnum , String message)
    {
        if( logEnum == LogEnum.WARN)
        System.out.println( "[WARN] "+message);
        else
        super.print(logEnum, message);  // this is doing the chaining to the next logger manager
    }
}
