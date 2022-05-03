package org.example.exceptions;

import java.io.IOException;

public class FileSignatureIsNotCorrect extends IOException {
    public FileSignatureIsNotCorrect(String message) {
        super(message);
    }
}
