package org.example;

import java.util.Objects;

public class FileData {
  private String dir;
  private String fileName;
  private String code;
  private String subject;
  private String date;
  private String filePath;
  private String relFilePath;

  public FileData() {
  }

  public FileData(String dir, String fileName, String code, String subject, String date, String filePath, String relFilePath) {
    this.dir = dir;
    this.fileName = fileName;
    this.code = code;
    this.subject = subject;
    this.date = date;
    this.filePath = filePath;
    this.relFilePath = relFilePath;
  }

  public String getDir() {
    return dir;
  }

  public void setDir(String dir) {
    this.dir = dir;
  }

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getFilePath() {
    return filePath;
  }

  public void setFilePath(String filePath) {
    this.filePath = filePath;
  }

  public String getRelFilePath() {
    return relFilePath;
  }

  public void setRelFilePath(String relFilePath) {
    this.relFilePath = relFilePath;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    FileData fileData = (FileData) o;
    return Objects.equals(dir, fileData.dir) && Objects.equals(fileName, fileData.fileName) && Objects.equals(code, fileData.code) && Objects.equals(subject, fileData.subject) && Objects.equals(date, fileData.date) && Objects.equals(filePath, fileData.filePath) && Objects.equals(relFilePath, fileData.relFilePath);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dir, fileName, code, subject, date, filePath, relFilePath);
  }

  @Override
  public String toString() {
    return "FileData{" +
            "dir='" + dir + '\'' +
            ", fileName='" + fileName + '\'' +
            ", code='" + code + '\'' +
            ", subject='" + subject + '\'' +
            ", date='" + date + '\'' +
            ", filePath='" + filePath + '\'' +
            ", relFilePath='" + relFilePath + '\'' +
            '}';
  }
}
