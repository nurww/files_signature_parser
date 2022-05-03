package org.example.exceptions;

import java.io.FileNotFoundException;

public class IsNotDirectoryException extends FileNotFoundException {
    public IsNotDirectoryException(String message) {
        super(message);
    }
}
