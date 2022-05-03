package org.example.exceptions;

import java.io.IOException;

public class DateIsInvalid extends IOException {
    public DateIsInvalid(String message) {
        super(message);
    }
}
