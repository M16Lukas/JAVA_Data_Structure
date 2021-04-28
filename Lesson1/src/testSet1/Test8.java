package testSet1;

import java.util.Scanner;

public class Test8 {
  // 사용자로부터 n개의 정수를 입력받아
  // 크기순으로 정렬한 후 중복된 수를 제거하고 출력
  // ex. n = 8, 4 7 1 12 4 10 9 7 -> 4 7 9 10 12
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("몇개의 정수를 입력 받으시겠습니까? : ");
    int n = scanner.nextInt();
    int[] arr = new int[n];

    // 정수 입력
    System.out.print("정수를 입력하세요 : ");
    for (int i = 0; i < n; i++) {
      arr[i] = scanner.nextInt();
    }
    scanner.close();

    // Sort(크기 순으로 정렬)
    int temp = 0;
    for (int i = 0; i < n - 1; i++) {
      for (int j = (i + 1); j < n; j++) {
        if (arr[i] == arr[j]) {
          arr[i] = 0;
        } else if (arr[i] > arr[j]) {
          temp = arr[i];
          arr[i] = arr[j];
          arr[j] = temp;
        }
      }
    }

    // 중복된 수 제거

    // 출력
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
  }
}
