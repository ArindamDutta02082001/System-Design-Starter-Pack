package COR.Logger;

public class Main
{
    public static void main(String[] args) {

        System.out.println("******************Logger***************");



        LoggerManager logger = LoggerManager.getInstance();

        // testing the chain

        logger.print( LogEnum.ERROR , "This is a error message ");
        logger.print( LogEnum.INFO , "This is a info message ");
        logger.print( LogEnum.DUMMY , "This is a dummy message , should not be printed ");

        
    }
}