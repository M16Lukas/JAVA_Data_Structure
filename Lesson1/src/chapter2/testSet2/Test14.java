package chapter2.testSet2;

import java.util.Scanner;

public class Test14 {
  // 입력으로 정수의 개수 n과 이어서 n개의 정수들이 주어진다.
  // 이 중 오름차순 혹은 내림차순으로 정렬되어 있는 가장 긴 구간을 찾아서
  // 그 구간의 길이를 출력하는 프로그램을 작성하라.
  // [ 예시 ]
  // n = 13 / 2 3 "15 15 13 12 11 9 0 -1" 2 -3 5 -> 길이 : 8

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("n : ");
    int n = scanner.nextInt();

    int[] arr = new int[n];

    System.out.print("value of Array : ");
    for (int i = 0; i < n; i++) {
      arr[i] = scanner.nextInt();
    }
    scanner.close();

    // 오름차순 or 내림차순 정렬 확인
    int length = checkAscAndDescLength(n, arr);

    System.out.println("length : " + length);
  }

  private static int checkAscAndDescLength(int n, int[] arr) {
    int cntDesc = 0;
    int cntAsc = 0;

    int lengthDesc = 0;
    int lengthAsc = 0;

    for (int i = 0; i < n - 1; i++) {
      if (arr[i] > arr[i + 1]) { // 내림차순
        if (lengthAsc < cntAsc) {
          lengthAsc = cntAsc;
        }
        cntDesc++;
      } else { // 올림차순
        if (lengthDesc < cntDesc) {
          lengthDesc = cntDesc;
        }
        cntAsc++;
      }
    }

    return (lengthAsc > lengthDesc) ? lengthAsc + 1 : lengthDesc + 1;
  }
}
