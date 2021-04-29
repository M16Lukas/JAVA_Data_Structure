package chapter1.testSet1;

import java.util.Scanner;

public class Test11 {
  // 입력으로 두 행렬(p*q, q*r)을 받아서 두 행렬을 곱하는 프로그램
  // 입력 형식
  // 1. 첫번째 행렬의 크기 p와q가 주어짐
  // 2. 이어지는 p줄에는 각 줄마다 q개의 정수가 주어진다
  // 3. 두번째 행렬의 크기 q와r가 주어짐
  // 4. 이어지는 q줄에는 각 줄마다 r개의 정수가 주어진다

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("p : ");
    int p = scanner.nextInt();
    System.out.print("q : ");
    int q = scanner.nextInt();

    int[][] arr1 = new int[p][q];
    arr1 = setMatrix(arr1, p, q);

    System.out.print("r : ");
    int r = scanner.nextInt();

    int[][] arr2 = new int[q][r];
    arr2 = setMatrix(arr2, q, r);

    getMultipleMatrix(arr1, arr2);
    scanner.close();
  }

  public static int[][] setMatrix(int[][] array, int row, int col) {
    Scanner sc = new Scanner(System.in);
    for (int i = 0; i < row; i++) {
      System.out.print((i + 1) + " 행 입력 : ");
      for (int j = 0; j < col; j++) {
        array[i][j] = sc.nextInt();
      }
    }
    // sc.close();
    return array;
  }

  // 행렬의 곱셈
  // 앞 행렬의 행의 갯수와 뒤 행렬의 열의 갯수의 곱이다.
  // (p x q) x (q x r) = (p x r)
  public static void getMultipleMatrix(int[][] array1, int[][] array2) {
    int row = array1.length;
    int col = array2[0].length;
    int[][] resultMatrix = new int[row][col];
    for (int i = 0; i < row; i++) { // p
      for (int j = 0; j < col; j++) { // r
        resultMatrix[i][j] = 0;
        for (int k = 0; k < array1[0].length; k++) { // q
          resultMatrix[i][j] += array1[i][k] * array2[k][j];
        }
      }
    }

    // output
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        System.out.print(resultMatrix[i][j] + " ");
      }
      System.out.println();
    }
  }
}
