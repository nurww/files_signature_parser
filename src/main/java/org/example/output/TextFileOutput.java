package org.example.output;

import org.example.Config;
import org.example.exceptions.FileDoesNotExistException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TextFileOutput implements OutputInterface {
  StringBuilder data;
  Config config;

  public TextFileOutput(StringBuilder data, Config config) {
    this.data = data;
    this.config = config;
  }

  @Override
  public void output() {
    if(Files.isDirectory(Paths.get(config.getFileToWrite()))) {
      config.setFileToWrite(config.getFileToWrite());
    }

    try (java.io.FileWriter fw = new java.io.FileWriter(config.getFileToWrite(), true)) {
      fw.write(String.valueOf(this.data));

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
