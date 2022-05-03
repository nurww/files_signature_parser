package org.example;

import org.example.exceptions.FileDoesNotExistException;
import org.example.exceptions.FileSignatureIsNotCorrect;
import org.example.exceptions.IsNotDirectoryException;
import org.example.help.HelpClass;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class DataCollector {
  Config config;
  final Path pathBase;
  ArrayList<FileData> data = new ArrayList<>();

  public DataCollector(Config config) {
    this.config = config;
    this.pathBase = Paths.get(config.getDirectory()).getParent();
  }

  public FileData collectData(Path file) throws FileSignatureIsNotCorrect {
    String pathRelative = pathBase.relativize(file).toString();

    String directory = file.getParent().getFileName().toString();
    String fileName = file.getFileName().toString();
    fileName = fileName.substring(0, fileName.lastIndexOf('.'));

    String[] dividedFileName = getFileSignatureChunks(fileName, pathRelative, "_");

    return new FileData(directory, fileName, dividedFileName[0], dividedFileName[1], dividedFileName[2], file.toString(), pathRelative);
  }

  public String[] getFileSignatureChunks(String fileName, String pathRelative, String separator) throws FileSignatureIsNotCorrect {
    String[] dividedFileName = fileName.split(separator);
    if(dividedFileName.length != 3) {
      String parent = Paths.get(pathRelative).getParent().toString();
      throw new FileSignatureIsNotCorrect(HelpClass.fileSignatureFail(fileName, parent));
    }
    return dividedFileName;
  }

  public ArrayList<FileData> getData() throws FileDoesNotExistException, IsNotDirectoryException, FileSignatureIsNotCorrect {
    String path = config.getDirectory();
    if(!Files.exists(Paths.get(path))) {
      throw new FileDoesNotExistException(HelpClass.directoryDoesNotExist(path));
    }
    if(!Files.isDirectory(Paths.get(path))) {
      throw new IsNotDirectoryException(HelpClass.fileDoesNotExist(path));
    }
    return getData(path);
  }

  public ArrayList<FileData> getData(String path) throws FileDoesNotExistException, IsNotDirectoryException, FileSignatureIsNotCorrect {

    File root = new File(path);
    File[] list = root.listFiles();

    assert list != null;
    for (File file : list) {
      if (file.isDirectory()) {
        if (config.isRecursive()) {
          getData(file.getAbsolutePath());
        }
      } else {
        data.add(collectData(Paths.get(file.getAbsoluteFile().toString())));
      }
    }

    return data;
  }



}