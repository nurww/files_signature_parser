package org.example;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;
import org.example.help.HelpClass;

public class ConsoleArgsHandler {
  public static Config parseCommandLineArgs(String[] args) {
    Options options = new Options();
    try {
      JCommander jc = JCommander.newBuilder()
              .addObject(options)
              .build();
      jc.parse(args);
    } catch (ParameterException e) {
      System.out.println(e.getMessage() + "\n");
    }

    if (options.isHelp()) {
      System.out.println(HelpClass.getHelp());
    }

    return getConfigClass(options);
  }

  public static Config getConfigClass(Options options) {
    Config config = new Config();
    config.setDirectory(options.getInputDirectory());
    config.setFileToWrite(options.getOutputFile());
    config.setRecursive(options.isRecursive());
    config.setFileWrite(options.isWriteInFile());
    config.setDateFormat(options.getDateFormat());
    config.setCustomFormatList(options.getCustomFormatList());
    config.setOutputFile(options.getOutputFile());

    return config;
  }
}