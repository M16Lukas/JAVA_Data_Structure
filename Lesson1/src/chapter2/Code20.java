package chapter2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Code20 {
  static String[] name = new String[1000];
  static String[] number = new String[1000];
  static int n = 0;

  public static void main(String[] args) {

    try {
      Scanner inFile = new Scanner(new File("lib\\input.txt"));

      // hasNext : 다음 string 값이 있는가? ( = 더 읽을 값이 있는가? -? o : T, x : F)
      while (inFile.hasNext()) { // detect End of File
        name[n] = inFile.next();
        number[n] = inFile.next();
        n++;
      }

      inFile.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      System.exit(0);
    }

    bubbleSort();

    for (int i = 0; i < n; i++) {
      System.out.println(name[i] + " " + number[i]);
    }
  }

  private static void bubbleSort() {
    for (int i = 0; i < n - 1; i++) {
      for (int j = (i + 1); j < n; j++) {
        if (name[i].compareTo(name[j]) > 0) { // 사전식 순서 비교
          // > : 1 , == : 0(=equals), < : -1
          // swap
          String tmp = name[i];
          name[i] = name[j];
          name[j] = tmp;

          tmp = number[i];
          number[i] = number[j];
          number[j] = tmp;
        }
      }
    }
  }
}
