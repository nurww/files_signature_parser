package org.example.help;

public class HelpClass {
  public static String directoryDoesNotExist(String dir) {
    return dir + " directory does not exist! Please enter correct directory path! If you having a trouble use -help.";
  }

  public static String fileDoesNotExist(String file) {
    return file + " is not a directory! Please provide correct file! If you having a trouble use -help.";
  }

  public static String invalidDateFormat(String dateFormat) {
    return dateFormat + " - date format is invalid! Please enter correct date format If you having a trouble use -help.";
  }

  public static String invalidDate(String date) {
    return date + " - date is invalid! Please provide correct date! If you having a trouble use -help.";
  }

  public static String fileSignatureFail(String signature, String dir) {
    return signature + " in directory " + dir + " - file signature is invalid! Please provide correct file! Use files with name {code}_{subject}_{date} If you having a trouble use -help.";
  }

  public static String getHelp() {
    return "" +
            "To run this parser you must open command line interface in current directory.\n" +
            "Then run the following command -java -jar files_signature_parser.jar [options] where options are described below.\n" +
            "NOTE: parser works only with files with following signature: {code}_{subject}_{date}. {date} must be {dd} {MM} {yy} or {dd} {MM} {yyyy}\n" +
            "NOTE: please, do not point inspected directory as an output directory!\n" +
            "<WARNING>: options are case sensitive!!!\n" +
            "\n" +
            "Usage: -java -jar files_signature_parser.jar [options]\n" +
            "  Options:\n" +
            "    -f, -F\n" +
            "      {-r / -R} - this command sets write in file mode\n" +
            "            Default: false\n" +
            "    -h, -H, -help\n" +
            "      {-h / -H / -help} - this command shows you available options\n" +
            "            Default: false\n" +
            "    -r, -R\n" +
            "      {-r / -R} - this command sets recursive mode\n" +
            "            Default: false\n" +
            "    -i, -I\n" +
            "      {-i / -I + path} - this command sets directory to inspect\n" +
            "            Default: _\n" +
            "    -o, -O\n" +
            "      {-o / -O + path} - this command sets file to write inside\n" +
            "            Default: FileWithResults.txt\n" +
            "    -cf, -CF, -cF, -Cf\n" +
            "      {-cf -customFormat + column(s)} - this command sets columns to display\n" +
            "            %dir - display Directory column%fileName - display File Name column\n" +
            "            %fullPath - display Absolute Path column\n" +
            "            %relPath - display Relative Path column\n" +
            "            %code - display Code column\n" +
            "            %subject - display Subject column\n" +
            "            %date - display Date column\n" +
            "            Default: [%dir, %fileName, %code, %subject, %date]\n" +
            "    -dateFormat, -df\n" +
            "      {-dateFormat / -df} - this command sets date formatYou can you the\n" +
            "            following date formats: ddMMyyyy, yyyyMMdd, dd.MM.yyyy, dd/MM/yyyy, dd-MM-yyyy\n" +
            "            Default: ddMMyyyy\n" +
            "\n" +
            "C:\\Users\\toktarkhan_n\\Desktop\\FileWithResults.txt file does not exist!\n" +
            "\n" +
            "Process finished with exit code 0\n\n";
  }
}
