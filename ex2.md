# Log4j logging
## Example 2 <br/>

First, create a new logger
```java
 private static final Logger logger = LogManager.getLogger();
```

Create a new configuration
```java
ConfigurationBuilder<BuiltConfiguration> builder =
                ConfigurationBuilderFactory.newConfigurationBuilder();
```

Next, create Pattern and Layout uses PatternLayout

```java
 private static final String PATTERN = "%d [%t] %-5level: %msg%n%throwable";
```

```java
LayoutComponentBuilder layoutComponentBuilder = builder.newLayout("PatternLayout");
        layoutComponentBuilder.addAttribute("pattern", PATTERN);
```

Next, create appenders

Console appender
```java
 AppenderComponentBuilder console = builder.newAppender(
        "stdout", "Console");
```

File appender with logging into file log.txt
```java
AppenderComponentBuilder file = builder.newAppender("log", "File");
        file.addAttribute("fileName", "./log.txt");
```

Then, add layout and add its to builder
```java
console.add(layoutComponentBuilder);
file.add(layoutComponentBuilder);

builder.add(console);
builder.add(file);
```

Next, create logger component builder and add it to configuration builder

Setup options
<br/>
**ua.juniffiro.logging.log4j** - package when need logger
<br/>
**ALL** - logger's level
```java
LoggerComponentBuilder logger = builder.newLogger("ua.juniffiro.logging.log4j", Level.ALL);
logger.add(builder.newAppenderRef("log"));

builder.add(logger);
```

Fine. Now apply the changes. <br/>
```java
Configurator.initialize(builder.build());
```
>Note! We have to call the configuration method before the logger.

We can also apply the settings in the static initialization block

```java
static {
    configureLogger();
    LOGGER = LogManager.getLogger();
}
```

I like this programmatic method because in addition to programmatic settings, you can write all these settings in the configuration file.
```java
try {
    builder.writeXmlConfiguration(new FileOutputStream("./log.xml"));
} catch (IOException e) {
    throw new RuntimeException(e);
}
```