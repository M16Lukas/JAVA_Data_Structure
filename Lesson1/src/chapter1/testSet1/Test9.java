package chapter1.testSet1;

import java.util.Scanner;

public class Test9 {
  // 사용자로부터 n개의 정수를 입력받아 배열에 저장한 후
  // 짝수 인덱스에 저장된 수는 그대로 두고
  // 홀수 인덱스에 저장된 수들은 오름차순으로 정렬하여 출력
  // 1 7 4 12 5 10 9 7 -> 1 7 4 7 5 10 9 12
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt(); // n 개의 정수입력
    int[] arr = new int[n]; // 정수 입력 배열

    // 정수 입력
    for (int i = 0; i < n; i++) {
      arr[i] = scanner.nextInt();
    }
    scanner.close();

    // 홀수 인덱스(1, 3, 5, ....)
    int tmp = 0;
    for (int i = 1; i < n - 2; i += 2) {
      for (int j = (i + 2); j < n; j += 2) {
        if (arr[i] > arr[j]) {
          tmp = arr[i];
          arr[i] = arr[j];
          arr[j] = tmp;
        }
      }
    }

    // 출력
    for (int i = 0; i < n; i++) {
      System.out.print(arr[i] + " ");
    }
  }
}
