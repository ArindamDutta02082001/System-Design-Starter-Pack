package COR.Logger;

public class INFOLogger extends LoggerManager {

    INFOLogger(LoggerManager loggerManager )
    {
        super(loggerManager);
    }

    @Override
    public void print( LogEnum logEnum , String message)
    {
        if( logEnum == LogEnum.INFO)
        System.out.println( "[INFO] "+message);
        else
        super.print(logEnum, message);  // this is doing the chaining to the next logger manager
    }
}
