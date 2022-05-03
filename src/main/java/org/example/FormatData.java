package org.example;

import org.example.enums.DataColumns;
import org.example.exceptions.DateFormatIsInvalid;
import org.example.exceptions.DateIsInvalid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FormatData {
  Config config;
  ArrayList<FileData> data;
  Map<String, Integer> columnsWidthMap;

  public FormatData(ArrayList<FileData> data, Config config) {
    this.data = data;
    this.config = config;
  }

  public void fillColumnsWidthList() {
    columnsWidthMap = new HashMap<>();

    for (FileData fileData : data) {
      updateColumnMaxWidth(DataColumns.DIR.name(), fileData.getDir());
      updateColumnMaxWidth(DataColumns.FILENAME.name(), fileData.getFileName());
      updateColumnMaxWidth(DataColumns.FILEPATH.name(), fileData.getFilePath());
      updateColumnMaxWidth(DataColumns.RELPATH.name(), fileData.getRelFilePath());
      updateColumnMaxWidth(DataColumns.CODE.name(), fileData.getCode());
      updateColumnMaxWidth(DataColumns.SUBJECT.name(), fileData.getSubject());
      updateColumnMaxWidth(DataColumns.DATE.name(), fileData.getDate());
    }
  }

  public void updateColumnMaxWidth(String columnName, String columnValue) {
    int columnWidth = columnsWidthMap.getOrDefault(columnName, 0);
    columnWidth = Math.max(columnWidth, columnValue.length());
    columnsWidthMap.put(columnName, columnWidth);
  }

  public StringBuilder getPreparedData() throws DateFormatIsInvalid, DateIsInvalid {
    StringBuilder preparedData = new StringBuilder();
    fillColumnsWidthList();

    for (FileData fileData : data) {
      Map<String, String> collectedData = new HashMap<>();

      collectedData.put("dir".toLowerCase(), formatFileData(DataColumns.DIR.name(), fileData.getDir()));
      collectedData.put("fileName".toLowerCase(), formatFileData(DataColumns.FILENAME.name(), fileData.getFileName()));
      collectedData.put("fullPath".toLowerCase(), formatFileData(DataColumns.FILEPATH.name(), fileData.getFilePath()));
      collectedData.put("relPath".toLowerCase(), formatFileData(DataColumns.RELPATH.name(), fileData.getRelFilePath()));
      collectedData.put("code".toLowerCase(), formatFileData(DataColumns.CODE.name(), fileData.getCode()));
      collectedData.put("subject".toLowerCase(), formatFileData(DataColumns.SUBJECT.name(), fileData.getSubject()));

      String date = DateFormatter.getFormattedDate(formatFileData(DataColumns.DATE.name(), fileData.getDate()), config);
      collectedData.put("date", date);

      for(String key : config.getCustomFormatList()) {
        preparedData.append(collectedData.get(key));
      }
      preparedData.append("\n");
    }

    return preparedData;
  }

  public String formatFileData(String columnName, String columnValue) {
    int columnWidth = columnsWidthMap.get(columnName) + 5;

    return String.format("%-" + columnWidth + "s", columnValue);
  }
}
