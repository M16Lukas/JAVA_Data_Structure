package chapter2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// 2 차원 배열에서 소수 찾기
// 입력으로 n*n개의 음이 아닌 한자리 정수가 그림과 같이 주어진다.
// 이 정수들 중 가로,세로, 대각선의 8 방향으로 연속된 숫자들을 합쳐서
// 만들 수 있는 모든 소수를 찾아서 나열하는 프로그램을 작성하라.
// 단, 중복된 수를 출력해도 상관없다. 
public class Code21 {

  static int n;
  static int[][] grid;

  public static void main(String[] args) {
    try {
      Scanner inFile = new Scanner(new File("lib\\data.txt"));
      n = inFile.nextInt();
      grid = new int[n][n];

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          grid[i][j] = inFile.nextInt();
        }
      }
      inFile.close();

      // 모든 가능한 수열들에 대해
      // 1. 하나의 수열은 (시작점, 방향, 길이)에 의하여 정의된다.
      // 2. 방향은 0~7번까지의 수로 표현
      for (int i = 0; i < n; i++) { // 행 (row)
        for (int j = 0; j < n; j++) { // 열 (col)
          for (int dir = 0; dir < 8; dir++) { // 방향
            for (int length = 1; length <= n; length++) { // 길이
              int value = computeValue(i, j, dir, length);
              if (value != -1 && isPrime(value)) {
                System.out.println(value);
              }
            }
          }
        }
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  // 시작위치 (i,j)에서 dir 방향으로 길이가 length인 수열을 정수로 환산하여 반환
  // 만약 그런 수열이 존재하지 않으면 -1을 반환
  private static int computeValue(int i, int j, int dir, int length) {
    // 수열을 정수로 환산하기
    int value = 0;
    for (int x = 0; x < length; x++) {
      int digit = getDigit(i, j, dir, x);
      if (digit == -1) {
        return -1;
      }
      value = value * 10 + digit;
    }
    return value;
  }

  // 시작위치 (i,j)에서 dir 방향으로 i칸 떨어진 자리에 있는 digit 반환
  // 만약 그런 자리가 존재하지 않으면 -1을 반환
  private static int getDigit(int i, int j, int dir, int x) {
    // 임의의 위치에서 dir 방향으로 한칸 움직였을때 좌표값의 증감분
    int[] offsetX = { 0, 1, 1, 1, 0, -1, -1, -1 };
    int[] offsetY = { -1, -1, 0, 1, 1, 1, 0, -1 };

    int newX = i + (x * offsetX[dir]);
    int newY = j + (x * offsetY[dir]);

    if (newX < 0 || newX >= n || newY < 0 || newY >= n) {
      return -1;
    }
    return grid[newX][newY];
  }

  // 소수 확인
  public static boolean isPrime(int value) {
    if (value < 2) {
      return false;
    }
    for (int i = 2; i * i <= value; i++) {
      if (value % i == 0) {
        return false;
      }
    }
    return true;
  }
}