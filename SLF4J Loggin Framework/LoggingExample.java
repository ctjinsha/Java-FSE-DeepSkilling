import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingExample {

    private static final Logger logger =
            LoggerFactory.getLogger(LoggingExample.class);

    public static void main(String[] args) {

        logger.info("Application Started");

        // Warning message
        logger.warn("Low disk space. Please free some memory.");

        // Error message
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            logger.error("An error occurred: Division by zero.");
        }

        logger.info("Application Finished");
    }
}