package org.example;

import org.example.exceptions.*;
import org.example.output.ConsoleOutput;
import org.example.output.OutputInterface;
import org.example.output.TextFileOutput;

import java.util.*;

/**
 * Hello world!
 */
public class App {

  public static void main(String[] args) {

    try {
      Config config = ConsoleArgsHandler.parseCommandLineArgs(args);

      DataCollector dataCollector = new DataCollector(config);
      ArrayList<FileData> data = dataCollector.getData();

      FormatData formatData = new FormatData(data, config);
      StringBuilder formattedData = formatData.getPreparedData();

      OutputInterface output;

      if (!config.getOutputFile().equals("")) {
        output = new TextFileOutput(formattedData, config);
      } else {
        output = new ConsoleOutput(formattedData);
      }

      output.output();

    } catch (FileSignatureIsNotCorrect | DateFormatIsInvalid | DateIsInvalid | FileDoesNotExistException | IsNotDirectoryException e) {
      System.out.println(e.getMessage());
    }

  }
}
