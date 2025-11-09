package COR.Logger;

public class ERRORLogger extends LoggerManager {

    ERRORLogger(LoggerManager loggerManager )
    {
        super(loggerManager);
    }

    @Override
    public void print( LogEnum logEnum , String message)
    {
        if( logEnum == LogEnum.ERROR)
        System.out.println( "[ERROR] "+message);
        else
        super.print(logEnum, message);  // this is doing the chaining to the next logger manager
    }
}
