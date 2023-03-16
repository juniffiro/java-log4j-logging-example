package ua.juniffiro.logging.log4j.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static ua.juniffiro.logging.log4j.LoggerV1.LOGGER;

/**
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 * ( Created ) ( by ) ( @juniffiro )
 * 27/02/2023
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 */
public class LoggerTestV1 {

    @BeforeAll
    public static void startTesting() {
        System.out.println("Starts logging version #1 test");
    }

    @BeforeEach
    public void startTest() {
        Assertions.assertNotNull(LOGGER);
    }

    @Test
    public void testLoggerV1() {
        LOGGER.info("Test logger V1");
    }
}
