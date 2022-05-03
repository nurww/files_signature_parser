package org.example.exceptions;

import java.io.IOException;

public class DateFormatIsInvalid extends IOException {
    public DateFormatIsInvalid(String message) {
        super(message);
    }
}
