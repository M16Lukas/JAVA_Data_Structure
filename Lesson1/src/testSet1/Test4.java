package testSet1;

import java.util.Scanner;

public class Test4 {
  // 사용자로부터 하나의 양의 정수 n을 입력받는다.
  // 그런 다음 다음과 같이 n 줄을 출력하는 프로그램을 작성하라
  // n = 4
  // 1
  // 1 2
  // 1 2 3
  // 1 2 3 4
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < (i + 1); j++) {
        System.out.print((j + 1) + " ");
      }
      System.out.println();
    }
    scanner.close();
  }
}
