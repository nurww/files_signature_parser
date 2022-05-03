package org.example;

import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Properties;

public class AppTest {
    @Test
    public void getConfig() throws IOException {
        Properties properties = getProperties();
        String[] args = properties.getProperty("td.args").split(", ");

        Config config = ConsoleArgsHandler.parseCommandLineArgs(args);

        Config expectedConfig = new Config();
        expectedConfig.setDirectory(properties.getProperty("td.dirFullPath"));
        expectedConfig.setFileToWrite("");
        expectedConfig.setRecursive(true);
        expectedConfig.setFileWrite(false);
        expectedConfig.setDateFormat("dd.MM.yyyy");
        expectedConfig.setCustomFormatList(new ArrayList<>(Arrays.asList("dir", "fileName", "code", "subject", "date")));

        Assert.assertEquals(config, expectedConfig);
    }

    public Properties getProperties() throws IOException {
        String rootPath = Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("")).getPath();
        String testData = rootPath + "testData.properties";
        Properties properties = new Properties();
        properties.load(new FileReader(testData));

        return properties;
    }
}