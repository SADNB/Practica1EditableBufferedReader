//package practica1;
import java.io.*;
class TestRead {
  public static void main(String[] args) {
    InputStreamReader input=new InputStreamReader(System.in);
    EditableBufferedReader in = new EditableBufferedReader(input);
    int str = 0 ;
    try {
      str = in.read();
    } catch (IOException e) { e.printStackTrace(); }
    System.out.println("\nline is: " + str);
  }
}
