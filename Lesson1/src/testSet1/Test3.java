package testSet1;

import java.util.Scanner;

public class Test3 {
  // 사용자로 부터 n개의 정수를 입력받아서
  // 그 중 모든 짝수를 더한 값에서 모든 홀수를 뺀 값을 계산해 출력한다
  // << 입력 방식 >>
  // 1. n의 값이 주어짐
  // 2. n개의 정수들이 주어진다.

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int sumEven = 0; // 홀수의 합
    int sumOdd = 0; // 짝수의 합

    System.out.print("입력 받을 정수의 갯수 : ");
    int numberSize = scanner.nextInt(); // 입력 받을 정수의 갯수

    for (int i = 0; i < numberSize; i++) {
      int number = scanner.nextInt();
      if (number % 2 == 0) { // Even number
        sumEven += number;
      } else { // Odd number
        sumOdd += number;
      }
    }
    System.out.println(sumEven + " - " + sumOdd + " = " + (sumEven - sumOdd));
    scanner.close();
  }
}
