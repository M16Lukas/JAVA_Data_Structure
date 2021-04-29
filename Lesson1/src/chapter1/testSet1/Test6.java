package chapter1.testSet1;

import java.util.Scanner;

public class Test6 {
  // 사용자로부터 하나의 양의 정수 n을 입력받는다.
  // n보다 크거나 같으면서 가장 작은 2의 거듭제곱수를 찾아서 출력
  // ex. n = 12 -> 출력 : 2^4(= 16)
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();

    int powNum = 0;
    double m = 0.0;
    boolean chk = true;
    while (chk) {
      powNum = (int) Math.pow(2.0, m);
      if (n <= powNum) {
        chk = false;
      } else {
        m++;
      }
    }
    System.out.println(n + " 출력은 " + powNum);
    scanner.close();
  }
}
