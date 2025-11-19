package COR.Logger;

public class INFOLogger implements LoggerManager {

    LoggerManager next = null ;     // this is doing the chaining to the next logger manager

    INFOLogger( LoggerManager loggerManager)
    {
        this.next = loggerManager;
    }

    public void print( LogEnum logEnum , String message )
    {
        if( logEnum == LogEnum.INFO)
            System.out.println( "[INFO] "+message);
        else
            // if(next != null)
            // next.print(logEnum, message);   // aur aage nhi jayega
            System.out.println(" Select appropriate level to print the log message ");
    }
}
