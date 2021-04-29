package chapter1;

import java.util.Scanner;

public class Code8 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("배열 길이 : ");
    int index = scanner.nextInt();

    int[] arr = new int[index];
    System.out.print("배열의 data 들 : ");
    for (int i = 0; i < index; i++)
      arr[i] = scanner.nextInt();
    scanner.close();

    // 사용자로부터 n개의 정수를 입력받은 후 오름차순으로 정렬(sort)하여 출력하는 코드이다.
    // 버블 정렬(bubble sort)
    for (int i = index - 1; i > 0; i--) {
      for (int j = 0; j < i; j++) {
        if (arr[j] > arr[j + 1]) {
          // swap data[j] and data[j + 1]
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
      }
    }

    System.out.print("Sorted Data : ");
    for (int i = 0; i < index; i++) {
      System.out.print("\t" + arr[i]);
    }
  }
}
