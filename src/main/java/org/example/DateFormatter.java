package org.example;

import org.example.exceptions.DateFormatIsInvalid;
import org.example.exceptions.DateIsInvalid;
import org.example.help.HelpClass;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateFormatter {
    public static String getFormattedDate(String date, Config config) throws DateFormatIsInvalid, DateIsInvalid {
        isDateInvalid(date);

        String dateFormat = config.getDateFormat();

        switch (dateFormat) {
            case "ddMMyyyy":
                date = DateFormatter.getFormattedDateDayMonthYear(date);
                break;
            case "yyyyMMdd":
                date = DateFormatter.getFormattedDateYearMonthDay(date);
                break;
            case "dd.MM.yyyy":
                date = DateFormatter.getFormattedDateDayMonthYearWithDot(date);
                break;
            case "dd-MM-yyyy":
                date = DateFormatter.getFormattedDateDayMonthYearWithDash(date);
                break;
            case "dd/MM/yyyy":
                date = DateFormatter.getFormattedDateDayMonthYearWithSlash(date);
                break;
            default:
                throw new DateFormatIsInvalid(HelpClass.invalidDateFormat(config.getDateFormat()));
        }

        return date;
    }

    public static String getFormattedDateDayMonthYear(String date) {
        Calendar calendar = getCalendar(date);
        SimpleDateFormat formattedDate = new SimpleDateFormat("dd MM yyyy");

        return formattedDate.format(calendar.getTime());
    }

    public static String getFormattedDateYearMonthDay(String date) {
        Calendar calendar = getCalendar(date);
        SimpleDateFormat formattedDate = new SimpleDateFormat("yyyy MM dd");

        return formattedDate.format(calendar.getTime());
    }

    public static String getFormattedDateDayMonthYearWithDot(String date) {
        Calendar calendar = getCalendar(date);
        SimpleDateFormat formattedDate = new SimpleDateFormat("dd.MM.yyyy");

        return formattedDate.format(calendar.getTime());
    }

    public static String getFormattedDateDayMonthYearWithDash(String date) {
        Calendar calendar = getCalendar(date);
        SimpleDateFormat formattedDate = new SimpleDateFormat("dd-MM-yyyy");

        return formattedDate.format(calendar.getTime());
    }

    public static String getFormattedDateDayMonthYearWithSlash(String date) {
        Calendar calendar = getCalendar(date);
        SimpleDateFormat formattedDate = new SimpleDateFormat("dd/MM/yyyy");

        return formattedDate.format(calendar.getTime());
    }

    private static Calendar getCalendar(String date) {
        String[] dayMonthYear = date.split(" ");
        int day = Integer.parseInt(dayMonthYear[0]);
        int month = Integer.parseInt(dayMonthYear[1]) - 1;
        int year = Integer.parseInt("20" + dayMonthYear[2]);
        if (dayMonthYear[2].length() == 4) {
            year = Integer.parseInt(dayMonthYear[2]);
        }

        return new GregorianCalendar(year, month, day);
    }

    public static void isDateInvalid(String date) throws DateIsInvalid {
        if(date.split(" ").length != 3) {
            throw new DateIsInvalid(HelpClass.invalidDate(date));
        }
    }
}
