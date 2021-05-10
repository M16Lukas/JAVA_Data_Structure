package polynomial2.service;

import java.util.Scanner;

import polynomial2.vo.Polynomial2;

// 다항함수
// 항(term)들의 합이며, 항은 계수(coefficient)와 지수(exponent)에 의해서 정의
// 계수는 0이 아닌 정수이고 지수는 음이아닌 정수라고 가정한다

public class Main {

  static Scanner sc = new Scanner(System.in);
  static Polynomial2[] polys = new Polynomial2[100];
  static int n = 0;
  static char name = 0;
  static int index = 0;

  public static void main(String[] args) {
    boolean run = true;
    while (run) {
      System.out.print("$ ");
      String commands = sc.next();

      switch (commands) {
        case "create":
          // 함수 생성
          name = inputChar();
          polys[n++] = new Polynomial2(name, 0);
          break;
        case "add": // add f 2 3
          // 항 추가 기능
          name = inputChar();
          index = find(name);
          if (index == -1) {
            System.out.println("No Such Polynomial exists.");
          } else {
            int c = sc.nextInt();
            int e = sc.nextInt();
            sc.nextLine();
            polys[index].addTerm(c, e);
          }
          break;
        case "calc":
          // 다항항수 계산
          name = inputChar();
          index = find(name);
          if (index == -1) {
            System.out.println("No such polynomial exists.");
          } else {
            System.out.print("input x : ");
            int x = sc.nextInt();
            int result = polys[index].calcPolynomial(x);
            System.out.println("result : " + result);
          }
          break;
        case "print":
          // 다항함수 출력
          name = inputChar();
          index = find(name);
          if (index == -1) {
            System.out.println("No such polynomial exists.");
          } else {
            polys[index].printPolynomial();
          }
          break;
        case "exit":
          run = false;
          sc.close();
          break;
      }
    }
    sc.close();
  }

  /**
   * char type 입력 기능
   */
  private static char inputChar() {
    return sc.next().charAt(0);
  }

  /**
   * 입력된 함수 이름의 존재 여부 확인
   * 
   * @param name
   * @return i : index
   */
  private static int find(char name) {
    for (int i = 0; i < n; i++) {
      if (polys[i].getName() == name) {
        return i;
      }
    }
    return -1;
  }
}
