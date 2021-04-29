package chapter1.testSet1;

import java.util.Scanner;

public class Test5 {
  // 사용자로부터 n개의 정수를 받아서
  // 그 중 최대값에서 최소값을 뺀값을 계산해 출력
  // 입력 형식은 Test3 과 동일
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("입력 받을 정수의 갯수 : ");
    int numberSize = scanner.nextInt(); // 입력 받을 정수의 갯수

    int[] arr = new int[numberSize];

    // Input
    System.out.print("숫자 입력 : ");
    for (int i = 0; i < numberSize; i++) {
      arr[i] = scanner.nextInt();
    }

    // Sort
    for (int i = 0; i < numberSize - 1; i++) {
      int temp = 0;
      for (int j = (i + 1); j < numberSize; j++) {
        if (arr[i] > arr[j]) { // 이전 index 값이 현재 index 값보다 큰 경우
          // swap
          temp = arr[i];
          arr[i] = arr[j];
          arr[j] = temp;
        }
      }
    }

    // Output
    System.out.println(arr[numberSize - 1] + " - " + arr[0] + " = " + (arr[numberSize - 1] - arr[0]));
    scanner.close();
  }
}
