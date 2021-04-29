package chapter1;

import java.util.Scanner;

public class Code6 {
  public static void main(String[] args) {
    // n 개의 정수를 입력받아 배열에 저장
    // 이들 중에서 0개 이상의 연속된 정수들을 더하여 얻을 수 있는 최대값을 구하여 출력
    Scanner scanner = new Scanner(System.in);

    int index = scanner.nextInt();
    int[] data = new int[index];
    for (int i = 0; i < index; i++) {
      data[i] = scanner.nextInt();
    }
    scanner.close();

    int max = 0;
    for (int i = 0; i < data.length; i++) {
      int sum = 0;
      for (int j = i; j < data.length; j++) {
        sum += data[j];
        if (sum > max) {
          max = sum;
        }
        // add data[i] ~ data[j]
        // if the sum > max -> max = the sum
      }
    }
    System.out.println(max);
  }
}
