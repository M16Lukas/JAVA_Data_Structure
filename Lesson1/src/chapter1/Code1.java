package chapter1;

import java.util.Scanner;

public class Code1 {
  static int num;

  public static void main(String[] args) { // Main Method
    Scanner scanner = new Scanner(System.in);

    String str = "Hello";
    String input = null;

    input = scanner.next();

    if (str.equals(input)) {
      System.out.println("String match!");
    } else {
      System.out.println("String do not match");
    }
    scanner.close();
  }
}
