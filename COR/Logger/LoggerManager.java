package COR.Logger;

public class LoggerManager {

    private static LoggerManager instance = null ;

    private LoggerCORInterface loggerCORInterface1 ;
    private LoggerCORInterface loggerCORInterface2;
    private LoggerCORInterface loggerCORInterface3;
    private LoggerManager() {

        // creating a chain or responsibility --> this is important
        // checking will happen from ERROR -> WARN -> INFO

        loggerCORInterface1 = new INFOLogger(null);
        loggerCORInterface2 = new WARNLogger(loggerCORInterface1);
        loggerCORInterface3 = new ERRORLogger(loggerCORInterface2);
    }

    // static method to create instance of Singleton class
    public static LoggerManager getInstance() {
        if (instance == null) {
            instance = new LoggerManager();
        }
        return instance;
    }

    // utility method
    public void print( LogEnum logEnum , String message )
    {
        // humesa use the last logger manager
        loggerCORInterface3.print( logEnum , message);
    }


}
