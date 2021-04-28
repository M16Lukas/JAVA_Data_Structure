package testSet1;

import java.util.Scanner;

public class Test7 {
  // 사용자로부터 n개의 정수를 입력받은 후
  // 그 중 (1) 서로 다르면서 (2) 차이가 가장 작은 두 수를 찾아 출력
  // 입력 형식 : 먼저 n의 값이 주어지고 이어서 n개의 정수들이 주어진다.
  // ex. n = 5 이고 정수들이 8, 1, 6, 9, 6 이라면 8, 9 이다.
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int arraySize = scanner.nextInt();
    int[] arr = new int[arraySize];

    for (int i = 0; i < arraySize; i++) {
      arr[i] = scanner.nextInt();
    }
    scanner.close();

    int subResult = arr[0] - arr[1]; // 두 배열 값이 차 저장
    if (subResult < 0) {
      subResult = -subResult;
    }

    int temp = 0; // 빼기 결과 임시 저장 필드
    for (int i = 0; i < arraySize - 1; i++) {
      for (int j = (i + 1); j < arraySize; j++) {
        temp = arr[i] - arr[j];

        if (temp < 0) { // 음수일 경우 양수로 변환
          temp = -temp;
        }

        if (arr[i] != arr[j] && subResult > temp) {
          subResult = temp;
        }
      }
    }
    System.out.println(subResult);
  }
}
