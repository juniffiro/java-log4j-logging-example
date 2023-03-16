package ua.juniffiro.logging.log4j.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static ua.juniffiro.logging.log4j.LoggerV2.LOGGER;

/**
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 * ( Created ) ( by ) ( @juniffiro )
 * 27/02/2023
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 */
public class LoggerTestV2 {

    @BeforeAll
    public static void startTesting() {
        System.out.println("Starts logging version #2 test");
    }

    @BeforeEach
    public void startTest() {
        Assertions.assertNotNull(LOGGER);
    }

    @Test
    public void testLoggerV2() {
        LOGGER.info("Test logger V2");
    }
}
