package chapter2.testSet2;

import java.util.Scanner;

public class Test17 {
  // 아래 그림과 같이 0 or 1 로 채워진 n*n 그리드가 주어진다.
  // "1만으로 체워진" 가장 큰 정사각형을 찾아 면적을 출력하는 프로그램을 작성
  // [ 입력 형식 ]
  // 먼저 n 값이 주어지고, 이어서 n*n개의 0 or 1의 값이 한칸씩 띄워져서
  // 한줄에 n개씩 주어진다.

  static int n;
  static int[][] grid;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // n 값 입력
    System.out.print("n : ");
    n = scanner.nextInt();
    scanner.close();

    // 0, 1 값 입력
    grid = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        grid[i][j] = (int) Math.round(Math.random());
      }
    }
  }
}
