package org.example;

import com.beust.jcommander.Parameter;

import java.util.ArrayList;
import java.util.Arrays;

public class Options {
  @Parameter(names = {"-r", "-R"})
  private  boolean isRecursive;
  @Parameter(names = {"-f", "-F"})
  private  boolean isWriteInFile;
  @Parameter(names = {"-i", "-I"})
  private  String inputDirectory = "_";
  @Parameter(names = { "-o", "-O" })
  private String outputFile = "";
  @Parameter(names = { "-cf", "-customFormat" }, variableArity = true)
  private ArrayList<String> customFormatList = new ArrayList<>(Arrays.asList("%dir", "%fileName", "%code", "%subject", "%date"));
  @Parameter(names = {"-dateFormat", "-df"})
  private  String dateFormat = "ddMMyyyy";
  @Parameter(names = {"-h", "-H", "-help"})
  private  boolean help;

  public boolean isRecursive() {
    return isRecursive;
  }

  public void setRecursive(boolean recursive) {
    isRecursive = recursive;
  }

  public boolean isWriteInFile() {
    return isWriteInFile;
  }

  public void setWriteInFile(boolean writeInFile) {
    isWriteInFile = writeInFile;
  }

  public String getDateFormat() {
    return dateFormat;
  }

  public void setDateFormatDayMonthYear(String dateFormatDayMonthYear) {
    this.dateFormat = dateFormatDayMonthYear;
  }

  public void setDateFormat(String dateFormat) {
    this.dateFormat = dateFormat;
  }

  public boolean isHelp() {
    return help;
  }

  public void setHelp(boolean help) {
    this.help = help;
  }

  public String getInputDirectory() {
    return inputDirectory;
  }

  public void setInputDirectory(String inputDirectory) {
    this.inputDirectory = inputDirectory;
  }

  public String getOutputFile() {
    return outputFile;
  }

  public void setOutputFile(String outputFile) {
    this.outputFile = outputFile;
  }

  public ArrayList<String> getCustomFormatList() {

    customFormatList.replaceAll(s -> s.substring(1));
    return customFormatList;
  }

  public void setCustomFormat(ArrayList<String> customFormatList) {
    this.customFormatList = customFormatList;
  }
}
