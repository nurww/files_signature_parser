package org.example;

import org.example.enums.DataColumns;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import org.junit.Test;


public class FormatDataTest {

    public Properties getProperties() throws IOException {
        String rootPath = Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("")).getPath();
        String testData = rootPath + "testData.properties";
        Properties properties = new Properties();
        properties.load(new FileReader(testData));

        return properties;
    }

    @Test
    public void getColumnsWidthList() throws IOException {
        Properties properties = getProperties();
        ArrayList<FileData> data = new ArrayList<>();

        FileData fileData1 = new FileData(
                properties.getProperty("td.dir"),
                properties.getProperty("td.fileName"),
                properties.getProperty("td.code"),
                properties.getProperty("td.subject"),
                properties.getProperty("td.date"),
                properties.getProperty("td.fileInvalidPath"),
                properties.getProperty("td.relFilePath")
        );

        data.add(fileData1);


        Map<String, Integer> columnsWidthMap = new HashMap<>();
        for (FileData fileNameData : data) {

            int columnWidth = columnsWidthMap.getOrDefault(DataColumns.DIR.name(), 0);

            if(columnWidth < fileNameData.getDir().length()) {
                columnWidth = fileNameData.getDir().length();
            }
            columnsWidthMap.put(DataColumns.DIR.name(), columnWidth);
        }
    }
}