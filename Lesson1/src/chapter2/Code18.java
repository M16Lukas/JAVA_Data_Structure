package chapter2;

import java.util.Scanner;

public class Code18 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] data = new int[n];
    for (int i = 0; i < n; i++) {
      data[i] = sc.nextInt();
    }
    sc.close();

    bubbleSort(n, data);

    System.out.print("Sorted data : ");
    for (int i = 0; i < n; i++) {
      System.out.print(data[i] + " ");
    }
  }

  private static void bubbleSort(int n, int[] array) {
    for (int i = n - 1; i > 0; i--) {
      for (int j = 0; j < i; j++) {
        if (array[j] > array[j + 1]) {
          // swap data
          // 값에 의한 호출
          // swap이 발생하지 않음
          swap(array[j], array[j + 1]); // actual parameter
        }
      }
    }
  }

  // actual parameter 와 formal parameter는 완전히 별개의 변수이다.

  private static void swap(int i, int j) { // formal parameter
    int tmp = i;
    i = j;
    j = tmp;
  }
}
