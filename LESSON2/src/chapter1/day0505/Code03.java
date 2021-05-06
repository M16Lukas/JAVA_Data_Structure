package chapter1.day0505;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Code03 {
  static Person1[] members = new Person1[100];
  static int n = 0;

  public static void main(String[] args) {
    try {
      Scanner in = new Scanner(new File("lib\\input.txt"));
      while (in.hasNext()) {
        String name = in.next();
        String number = in.next();

        members[n] = new Person1();
        members[n].name = name;
        members[n].number = number;
        n++;

      }
    } catch (FileNotFoundException e) {
      System.out.println("No data file");
      System.exit(1);
    }

    // 사전순으로 정렬
    bubbleSort();

    for (int i = 0; i < n; i++) {
      System.out.println(members[i].name + " " + members[i].number);
    }
  }

  private static void bubbleSort() {
    for (int i = n - 1; i > 0; i++) {
      for (int j = 0; j < i; j++) {
        if (members[j].name.compareToIgnoreCase(members[j + 1].name) > 0) { // compare names of j-th and (j+1)-th person
          // swap two person
          Person1 tmp = members[j];
          members[j] = members[j + 1];
          members[j + 1] = tmp;
        }
      }
    }
  }
}
