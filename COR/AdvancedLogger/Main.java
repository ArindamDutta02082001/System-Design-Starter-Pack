package COR.AdvancedLogger;

public class Main
{
    public static void main(String[] args) {

        System.out.println("******************Logger***************");

        // creating a chain or responsibility --> this is important
        // checking will happen from ERROR -> WARN -> INFO

        LoggerManager loggerManager1 = new INFOLogger(null);
        LoggerManager loggerManager2 = new WARNLogger(loggerManager1);
        LoggerManager loggerManager3 = new ERRORLogger(loggerManager2);

        // testing the chain
        // humesa use the last logger manager
        loggerManager3.print( LogEnum.ERROR , "This is a error message ");
        loggerManager3.print( LogEnum.INFO , "This is a info message ");

        
    }
}