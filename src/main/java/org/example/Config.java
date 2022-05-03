package org.example;

import java.util.ArrayList;
import java.util.Objects;

public class Config {
    private String directory;
    private String fileToWrite;
    private boolean isRecursive = false;
    private boolean isUserInclude = false;
    private boolean isFileWrite = false;
    private String dateFormat;
    private ArrayList<String> customFormatList;
    private String outputFile;

    public String getDirectory() {
        return this.directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public boolean isRecursive() {
        return this.isRecursive;
    }

    public void setRecursive(boolean recursive) {
        this.isRecursive = recursive;
    }

    public boolean isUserInclude() {
        return isUserInclude;
    }

    public void setUserInclude(boolean userInclude) {
        isUserInclude = userInclude;
    }

    public boolean isFileWrite() {
        return isFileWrite;
    }

    public void setFileWrite(boolean fileWrite) {
        isFileWrite = fileWrite;
    }

    public String getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    public String getFileToWrite() {
        return fileToWrite;
    }

    public void setFileToWrite(String fileToWrite) {
        this.fileToWrite = fileToWrite;
    }

    public ArrayList<String> getCustomFormatList() {
        for(int i = 0; i < customFormatList.size(); i++) {
            customFormatList.set(i, customFormatList.get(i).toLowerCase());
        }
        return customFormatList;
    }

    public void setCustomFormatList(ArrayList<String> customFormat) {
        this.customFormatList = customFormat;
    }

    public String getOutputFile() {
        return outputFile;
    }

    public void setOutputFile(String outputFile) {
        this.outputFile = outputFile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Config config = (Config) o;
        return isRecursive == config.isRecursive && isUserInclude == config.isUserInclude && isFileWrite == config.isFileWrite && directory.equals(config.directory) && Objects.equals(fileToWrite, config.fileToWrite) && dateFormat.equals(config.dateFormat) && customFormatList.equals(config.customFormatList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(directory, fileToWrite, isRecursive, isUserInclude, isFileWrite, dateFormat, customFormatList);
    }

    @Override
    public String toString() {
        return "Config{" +
                "directory='" + directory + '\'' +
                ", fileToWrite='" + fileToWrite + '\'' +
                ", isRecursive=" + isRecursive +
                ", isUserInclude=" + isUserInclude +
                ", isFileWrite=" + isFileWrite +
                ", dateFormat='" + dateFormat + '\'' +
                ", customFormatList=" + customFormatList +
                '}';
    }
}
