package testSet1;

import java.util.Scanner;

public class Test10 {
  // 사용자로부터 하나의 양의 정수 n을 입력받고 이어서 n개의 정수가 입력된다.
  // 그런 다음 다시 하나의 정수 k가 입력된다.
  // n개의 정수들 중에서 2개의 정수를 선택해 그 합이 k가 되는 경우의 수를 카운트
  // 단, 같은 정수를 중복 선택하는 것은 허용되지 않는다.

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("양의 정수를 입력 : ");
    int n = scanner.nextInt();

    int[] array = new int[n];
    for (int i = 0; i < n; i++) {
      array[i] = scanner.nextInt();
    }

    System.out.print("정수 k 입력 : ");
    int k = scanner.nextInt();
    int cnt = 0; // 두 정수의 합이 k가 되는 경우 카운트

    scanner.close();

    for (int i = 0; i < n - 1; i++) {
      for (int j = (i + 1); j < n; j++) {
        if (array[i] == array[j]) {
          continue;
        } else {
          if (k == array[i] + array[j]) {
            cnt++;
          }
        }
      }
    }

    System.out.println("합이 k가 되는경우 : " + cnt);
  }
}
