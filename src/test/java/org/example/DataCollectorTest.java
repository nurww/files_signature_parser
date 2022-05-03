package org.example;

import org.example.exceptions.FileDoesNotExistException;
import org.example.exceptions.FileSignatureIsNotCorrect;
import org.example.exceptions.IsNotDirectoryException;
import org.example.help.HelpClass;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Properties;

public class DataCollectorTest {

    public Properties getProperties() throws IOException {
        String rootPath = Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("")).getPath();
        String testData = rootPath + "testData.properties";
        Properties properties = new Properties();
        properties.load(new FileReader(testData));

        return properties;
    }

    @Test
    public void testCollectData() throws IOException {
        Properties properties = getProperties();
        Path file = Paths.get(properties.getProperty("td.filePath"));
        Path pathBase = Paths.get(properties.getProperty("td.dirFullPath"));
        String pathRelative = pathBase.relativize(file).toString();

        String directory = file.getParent().getFileName().toString();
        String fileName = file.getFileName().toString();
        fileName = fileName.substring(0, fileName.lastIndexOf('.'));

        String[] dividedFileName = fileName.split("_");

        FileData fileDataExpected = new FileData(
                properties.getProperty("td.dir"),
                properties.getProperty("td.fileName"),
                properties.getProperty("td.code"),
                properties.getProperty("td.subject"),
                properties.getProperty("td.date"),
                properties.getProperty("td.filePath"),
                properties.getProperty("td.relFilePath"));

        FileData fileData = new FileData(
                directory,
                fileName,
                dividedFileName[0],
                dividedFileName[1],
                dividedFileName[2],
                file.toString(),
                pathRelative);

        Assert.assertEquals(fileData, fileDataExpected);
    }

    @Test(expected = FileSignatureIsNotCorrect.class)
    public void testCollectDataShouldThrowFileSignatureIsNotCorrectException() throws IOException {
        Properties properties = getProperties();
        Path file = Paths.get(properties.getProperty("td.fileInvalidPath"));
        Path pathBase = Paths.get(properties.getProperty("td.dirFullPath"));
        String pathRelative = pathBase.relativize(file).toString();

        String fileName = file.getFileName().toString();
        fileName = fileName.substring(0, fileName.lastIndexOf('.'));

        String[] dividedFileName = fileName.split("_");

        if(dividedFileName.length != 3) {
            String parent = Paths.get(pathRelative).getParent().toString();
            throw new FileSignatureIsNotCorrect(HelpClass.fileSignatureFail(fileName, parent));
        }
    }

    @Test(expected = FileDoesNotExistException.class)
    public void testGetDataShouldThrowFileDoesNotExistException() throws FileDoesNotExistException {
        String notCorrectPath = "_";

        if(!Files.exists(Paths.get(notCorrectPath))) {
            throw new FileDoesNotExistException(HelpClass.directoryDoesNotExist(notCorrectPath));
        }
    }

    @Test(expected = IsNotDirectoryException.class)
    public void testGetDataShouldThrowIsNotDirectoryException() throws IOException {
        Properties properties = getProperties();
        String notCorrectPath = properties.getProperty("td.filePath");

        if(!Files.isDirectory(Paths.get(notCorrectPath))) {
            throw new IsNotDirectoryException(HelpClass.directoryDoesNotExist(notCorrectPath));
        }
    }

}