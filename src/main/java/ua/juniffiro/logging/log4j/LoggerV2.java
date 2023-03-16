package ua.juniffiro.logging.log4j;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.core.config.builder.api.*;
import org.apache.logging.log4j.core.config.builder.impl.BuiltConfiguration;

/**
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 * ( Created ) ( by ) ( @juniffiro )
 * 21/02/2023
 * +-+-+-+-+-+ +-+-+ +-+-+-+-+-+-+-+-+-+
 */
public class LoggerV2 {

    private static final String PATTERN = "%d [%t] %-5level: %msg%n%throwable";
    public static final Logger LOGGER;

    static {
        configure();
        LOGGER = LogManager.getLogger();
    }

    private static void configure() {
        ConfigurationBuilder<BuiltConfiguration> builder =
                ConfigurationBuilderFactory.newConfigurationBuilder();

        LayoutComponentBuilder layoutComponentBuilder = builder.newLayout("PatternLayout");
        layoutComponentBuilder.addAttribute("pattern", PATTERN);

        AppenderComponentBuilder console = builder.newAppender(
                "stdout", "Console");

        AppenderComponentBuilder file = builder.newAppender("log", "File");
        file.addAttribute("fileName", "./logs/v2/log.txt");

        console.add(layoutComponentBuilder);
        file.add(layoutComponentBuilder);

        builder.add(console);
        builder.add(file);

        LoggerComponentBuilder logger = builder.newLogger("ua.juniffiro.logging.log4j", Level.ALL);
        logger.add(builder.newAppenderRef("log"));
        builder.add(logger);

        Configurator.initialize(builder.build());
    }
}
