package org.example.output;

public class ConsoleOutput implements OutputInterface {
  StringBuilder data;

  public ConsoleOutput(StringBuilder data) {
    this.data = data;
  }

  @Override
  public void output() {
    System.out.println(this.data);
  }
}
