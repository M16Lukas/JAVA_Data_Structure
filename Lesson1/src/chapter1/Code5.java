package chapter1;

import java.util.Scanner;

public class Code5 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("배열의 크기를 입력하세요 : ");
    int n = scanner.nextInt();
    int[] data = new int[n];

    System.out.println("입력 값들을 입력하세요");
    for (int i = 0; i < n; i++) {
      data[i] = scanner.nextInt();
      scanner.nextLine();
    }
    scanner.close();

    int cnt = 0;

    for (int i = 0; i < data.length; i++) {
      for (int j = i + 1; j < data.length; j++) {
        if (data[i] == data[j]) {
          cnt++;
        }
      }
    }

    System.out.println("중첩된 요소 합 : " + cnt);
  }
}
