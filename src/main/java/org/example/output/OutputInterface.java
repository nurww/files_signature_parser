package org.example.output;

import org.example.exceptions.FileDoesNotExistException;

public interface OutputInterface {
  void output() throws FileDoesNotExistException;
}
