package org.example;

import org.example.exceptions.FileDoesNotExistException;
import org.example.exceptions.FileSignatureIsNotCorrect;
import org.example.exceptions.IsNotDirectoryException;

import java.io.File;
import java.nio.file.Paths;

public class TestRecursionMethod {
    public static void main(String[] args) {

    }

    public void getData() throws FileDoesNotExistException, IsNotDirectoryException, FileSignatureIsNotCorrect {

        /*
        File file = new File(config.getDirectory());

        if (file.isDirectory()) {
            if (config.isRecursive()) {
                config.setDirectory(file.getAbsolutePath());
                getData();
            }
        } else {
            data.add(collectData(Paths.get(file.getAbsoluteFile().toString())));
        }

         */
    }
}
