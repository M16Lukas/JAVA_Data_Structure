package poly2;

import java.util.Scanner;

public class MyPolynomialApp {
  private Polynomial[] polys = new Polynomial[100];
  private int n = 0;
  private Scanner sb = new Scanner(System.in);

  public MyPolynomialApp() {

  }

  public void processCommand() {
    while (true) {
      System.out.print("$ ");
      String command = sb.next();
      switch (command) {
        case "create":
          handleCreate();
          break;
        case "add":
          handleAdd();
          break;
        case "calc":
          handleCalc();
          break;
        case "print":
          handlePrint();
          break;
        case "exit":
          sb.close();
          return;
        default:
          break;
      }
    }
  }

  private void handlePrint() {
    char name = sb.next().charAt(0);
    int index = find(name);
    if (index < 0) {
      System.out.println("에러");
      return;
    }

    System.out.println(polys[index]);
  }

  private void handleCalc() {
    char name = sb.next().charAt(0);
    int x = sb.nextInt();
    int index = find(name);
    if (index < 0) {
      System.out.println("에러");
      return;
    }

    System.out.println(polys[index].calc(x));
  }

  private void handleAdd() {
    char name = sb.next().charAt(0);
    int coef = sb.nextInt();
    int expo = sb.nextInt();
    int index = find(name);
    if (index < 0) {
      System.out.println("에러");
      return;
    }

    polys[index].addTerm(coef, expo);
  }

  private int find(char name) {
    for (int i = 0; i < n; i++) {
      if (polys[i].name == name) {
        return i;
      }
    }
    return -1;
  }

  private void handleCreate() {
    char name = sb.next().charAt(0);
    Polynomial p = new Polynomial(name);

    polys[n++] = p;
  }

  public static void main(String[] args) {
    MyPolynomialApp app = new MyPolynomialApp();
    app.processCommand();
  }
}
