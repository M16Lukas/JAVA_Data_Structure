package polynomial.service;

import java.util.Scanner;

import polynomial.vo.Polynomial;
import polynomial.vo.Term;

// 다항함수
// 항(term)들의 합이며, 항은 계수(coefficient)와 지수(exponent)에 의해서 정의
// 계수는 0이 아닌 정수이고 지수는 음이아닌 정수라고 가정한다

public class Code06_1 {

  static Scanner sc = new Scanner(System.in);
  static Polynomial[] polys = new Polynomial[100];
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
          polys[n++] = new Polynomial(name, 0);
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
            addTerm(polys[index], c, e);
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
            int result = calcPolynomial(polys[index], x);
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
            printPolynomial(polys[index]);
          }
          break;
        case "exit":
          run = false;
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

  /**
   * 입력된 차수가 이미 존재하는지, 이전에 저장된 차수들보다 큰지 확인
   * 
   * 정렬 후 입력된 차수값을 Terms Class Array에 입력
   * 
   * @param p : Polynomial Class Array
   * @param c : coef
   * @param e : exp
   */
  private static void addTerm(Polynomial p, int c, int e) {
    int index = findTermExp(p, e);
    if (index != -1) { // 동일한 차수가 이미 존재하는 경우 계수(coef, c) 합한다
      p.getTerms()[index].plusCoef(c);
    } else {
      // 저장된 차수들보다 입력된 차수가 클 경우 배열 shift(방향 : ->)
      int i = p.getnTerms() - 1;
      while (i >= 0 && p.getTerms()[i].getExp() < e) {
        p.getTerms()[i + 1] = p.getTerms()[i];
        i--;
      }

      // 배열 정렬 후 입력된 계수와 차수의 값 입력
      p.getTerms()[i + 1] = new Term(c, e);

      // 항의 개수 추가
      p.plusnTerms(1);
    }
  }

  /**
   * 입력된 차수값(exp)이 배열안에 존재하는지 확인
   * 
   * @param p : Polynomial Class Array
   * @param e : exp
   * @return i : index
   */
  private static int findTermExp(Polynomial p, int e) {
    for (int i = 0; i < p.getnTerms() && p.getTerms()[i].getExp() >= e; i++) {
      if (p.getTerms()[i].getExp() == e) {
        return i;
      }
    }
    return -1;
  }

  /**
   * 다항 함수를 게산하는 기능
   * 
   * @param p : Polynomial Class Array
   * @param x
   * @return result : 다항함수 연산 결과
   */
  private static int calcPolynomial(Polynomial p, int x) {
    double result = 0.0;
    for (int i = 0; i < p.getnTerms(); i++) {
      result += p.getTerms()[i].getCoef() * (Math.pow(x, p.getTerms()[i].getExp()));
    }
    return (int) result;
  }

  /**
   * 다항함수 출력 기능
   * 
   * @param p : Polynomial Class Array
   */
  private static void printPolynomial(Polynomial p) {
    for (int i = 0; i < p.getnTerms(); i++) {
      System.out.print(p.getTerms()[i]);
      if (i != p.getnTerms() - 1) {
        System.out.print(" + ");
      }
    }
    System.out.println();
  }
}
