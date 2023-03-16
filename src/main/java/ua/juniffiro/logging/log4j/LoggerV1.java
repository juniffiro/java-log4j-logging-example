package ua.juniffiro.logging.log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.appender.ConsoleAppender;
import org.apache.logging.log4j.core.appender.FileAppender;
import org.apache.logging.log4j.core.layout.PatternLayout;

/**
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 * ( Created ) ( by ) ( @juniffiro )
 * 20/02/2023
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 */
public class LoggerV1 {

    private static final String PATTERN = "%d [%t] %-5level: %msg%n%throwable";
    public static final org.apache.logging.log4j.Logger LOGGER;

    static {
        LOGGER = LogManager.getLogger();
        configureLogger();
    }

    private static void configureLogger() {
        PatternLayout patternLayout = PatternLayout.newBuilder()
                .withPattern(PATTERN)
                .build();
        ConsoleAppender consoleAppender = ConsoleAppender.newBuilder()
                .setName("Console")
                .setLayout(patternLayout)
                .build();
        FileAppender fileAppender = FileAppender.newBuilder()
                .setName("File")
                .setLayout(patternLayout)
                .withFileName("./logs/v1/log.txt")
                .build();

        consoleAppender.start();
        fileAppender.start();

        org.apache.logging.log4j.core.Logger coreLog =
                (org.apache.logging.log4j.core.Logger) LOGGER;

        coreLog.addAppender(consoleAppender);
        coreLog.addAppender(fileAppender);
    }
}
