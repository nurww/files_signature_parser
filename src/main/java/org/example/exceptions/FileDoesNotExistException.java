package org.example.exceptions;

import java.io.FileNotFoundException;

public class FileDoesNotExistException extends FileNotFoundException {
    public FileDoesNotExistException(String message) {
        super(message);
    }
}
