package framework.logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Pavel Romanov 27.12.2022
 */
public class Log {
    private static Logger logger = LogManager.getLogger();

    public static void logTestSteps(String logMessage) {
        logger.info(logMessage);
    }

    public static void logPages(String logMessage) {
        logger.info(logMessage);
    }

    public static void logElements(String logMessage) {
        logger.debug(logMessage);
    }
}
