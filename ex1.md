# Log4j logging
## Example 1 <br/>

First, create a new logger and log4j2.xml at resources folder
```java
 private static final Logger logger = LogManager.getLogger();
```

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<Configuration status="WARN">
    <Appenders>
    </Appenders>
    <Loggers>
        <Root level="ALL"/>
    </Loggers>
</Configuration>
```

Next, create Pattern and Layout uses PatternLayout

```java
 private static final String PATTERN = "%d [%t] %-5level: %msg%n%throwable";
```

```java
PatternLayout patternLayout = PatternLayout.newBuilder()
                .withPattern("%d %m%n")
                .build();
```

Next, create appenders

Console appender
```java
 ConsoleAppender consoleAppender = ConsoleAppender.newBuilder()
                .setName("Console")
                .setLayout(patternLayout)
                .build();
```

File appender with logging into file log.txt
```java
FileAppender fileAppender = FileAppender.newBuilder()
                .setName("File")
                .setLayout(patternLayout)
                .withFileName("./log.txt")
                .build();
```

Then, starts it
```java
consoleAppender.start();
fileAppender.start();
```

Next, you need to cast the types
```java
org.apache.logging.log4j.core.Logger coreLog =
        (org.apache.logging.log4j.core.Logger) logger;
```

Adds appender to logger
```java
coreLog.addAppender(consoleAppender);
coreLog.addAppender(fileAppender);
```

Fine. Now apply the changes. <br/>
```java
configureLogger();
logger.info("Log4j test");
```

We can also apply the settings in the static initialization block

```java
static {
    LOGGER = LogManager.getLogger();
    configureLogger();
}
```

Full appender list
https://logging.apache.org/log4j/2.x/manual/appenders.html
