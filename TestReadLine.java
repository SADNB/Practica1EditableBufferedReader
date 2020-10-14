package practica1;

import java.io.*;

class TestReadLine {
  public static void main(String[] args) {
    BufferedReader in = new EditableBufferedReader(
      new InputStreamReader(System.in));
    int str = 0 ;
    try {
      str = in.read();
    } catch (IOException e) { e.printStackTrace(); }
    System.out.println("\nline is: " + str);
  }
}
