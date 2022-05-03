package org.example;

import org.example.exceptions.DateIsInvalid;
import org.example.help.HelpClass;
import org.junit.Test;

public class DateFormatterTest {

    @Test(expected = DateIsInvalid.class)
    public void isDateInvalidShouldThrowDateIsInvalidException_WithUnderScoreSign() throws DateIsInvalid {
        String date = "20_04 22";
        if(date.split(" ").length != 3) {
            throw new DateIsInvalid(HelpClass.invalidDate(date));
        }
    }

    @Test(expected = DateIsInvalid.class)
    public void isDateInvalidShouldThrowDateIsInvalidException_WithTwoValues() throws DateIsInvalid {
        String date = "04 22";
        if(date.split(" ").length != 3) {
            throw new DateIsInvalid(HelpClass.invalidDate(date));
        }
    }

    @Test(expected = DateIsInvalid.class)
    public void isDateInvalidShouldThrowDateIsInvalidException_WithOneValue() throws DateIsInvalid {
        String date = "22";
        if(date.split(" ").length != 3) {
            throw new DateIsInvalid(HelpClass.invalidDate(date));
        }
    }
}