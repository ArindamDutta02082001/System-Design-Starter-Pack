package COR.Logger;

public abstract class LoggerManager {
    
    LoggerManager loggerManager;
    LogEnum logEnum;
    
    LoggerManager(LoggerManager loggerManager)
    {
        this.loggerManager = loggerManager;
    }

    public void print(LogEnum logEnum , String message )
    {
        if( loggerManager != null )
        loggerManager.print(logEnum,message);
        else
        System.out.println("Log level not found");

    }

}
