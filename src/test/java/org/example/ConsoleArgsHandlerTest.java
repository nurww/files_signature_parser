package org.example;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;

import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class ConsoleArgsHandlerTest {

    public Properties getProperties() throws IOException {
        String rootPath = Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("")).getPath();
        String testData = rootPath + "testData.properties";
        Properties properties = new Properties();
        properties.load(new FileReader(testData));

        return properties;
    }

    @Test(expected = ParameterException.class)
    public void parseCommandLineArgs_InvalidArgsProvided() throws IOException {
        Properties properties = getProperties();
        String[] args = properties.getProperty("td.invalidArgs").split(", ");
        Options options = new Options();

        JCommander jc = JCommander.newBuilder()
                .addObject(options)
                .build();
        jc.parse(args);
    }
}