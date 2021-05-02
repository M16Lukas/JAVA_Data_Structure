package chapter2.testSet2;

import java.util.Scanner;

public class Test15 {
  // 서로 다른 수들로 구성된 수열 a1, a2, a3, ..., an이 있다.
  // 어떤 수가 자신과 인접한 두 수(즉, 바로 전의 수와 바로 다음의 수)보다 작을 때 그 수를 local minimum이라고 부른다.
  // 어떤 수열에서 local minimum이 최대 1개 일깨 그 수열은 "오목하다" 라고 부르기로 하자.
  // 입력으로 하나의 수열이 주어질 때 가장 길이가 긴 오목한 부분 수열을 찾아서 출력하라/
  // [ 예 시 ]
  // 입력 수열 : 1 3 7 6 "12 11 9 0 -1 2" -3 5 라면 가장 긴 오목한 수열은
  // 12 11 9 0 -1 2 이다.
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("n : ");
    int n = scanner.nextInt();
    int[] arr = new int[n];

    System.out.print("values : ");
    for (int i = 0; i < n; i++) {
      arr[i] = scanner.nextInt();
    }
    scanner.close();

    printLocalMinimumArray(n, arr);
  }

  private static void printLocalMinimumArray(int n, int[] arr) {
    int[] localArr = new int[n];
    int index = 0;

  }
}
