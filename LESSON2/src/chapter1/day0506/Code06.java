import java.util.Scanner;

public class Code06 {
  // 다항함수
  // 항(term)들의 합이며, 항은 계수(coefficient)와 지수(exponent)에 의해서 정의
  // 계수는 0이 아닌 정수이고 지수는 음이아닌 정수라고 가정한다

  static Polynomial[] polys = new Polynomial[100];
  static int n = 0;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (true) {
      System.out.print("$ ");
      String commands = sc.next();
      if (commands.equals("create")) {
        char name = sc.next().charAt(0);
        polys[n] = new Polynomial();
        polys[n].terms = new Term[100];
        polys[n].name = name;
        polys[n].nTerms = 0;
        n++;
      } else if (commands.equals("add")) { // add f 2 3
        char name = sc.next().charAt(0);
        int index = find(name);
        if (index == -1) {
          System.out.println("No such polynomial exists.");
        } else {
          int c = sc.nextInt();
          int e = sc.nextInt();
          sc.nextLine();
          addTerm(polys[index], c, e);
        }
      } else if (commands.equals("calc")) {
        char name = sc.next().charAt(0);
        int index = find(name);
        if (index == -1) {
          System.out.println("No such polynomial exists.");
        } else {
          int x = sc.nextInt();
          int result = calcPolynomial(polys[index], x);
          System.out.println(result);
        }
      } else if (commands.equals("print")) {
        char name = sc.next().charAt(0);
        int index = find(name);
        if (index == -1) {
          System.out.println("No such polynomial exists.");
        } else {
          printPolynomial(polys[index]);
        }
      } else if (commands.equals("exit")) {
        break;
      }
    }
    sc.close();
  }

  private static int calcPolynomial(Polynomial p, int x) {
    double result = 0.0;
    for (int i = 0; i < p.nTerms; i++) {
      result += calcTerm(p.terms[i], x);
    }
    return (int) result;
  }

  private static double calcTerm(Term term, int x) {
    return term.coef * (Math.pow(x, term.exp));
  }

  private static void printPolynomial(Polynomial p) {
    for (int i = 0; i < p.nTerms; i++) {
      printTerm(p.terms[i]);
      System.out.print(" + ");
    }
    System.out.println();
  }

  private static void printTerm(Term term) {
    System.out.print(term.coef + "x^" + term.exp);
  }

  private static int find(char name) {
    for (int i = 0; i < n; i++) {
      if (polys[i].name == name) {
        return i;
      }
    }
    return -1;
  }

  private static void addTerm(Polynomial p, int c, int e) {
    int index = findTerm(p, e);
    if (index != -1) { // 동일한 차수가 이미 존재하는 경우
      p.terms[index].coef += c;
    } else {
      int i = p.nTerms - 1;
      while (i >= 0 && p.terms[i].exp < e) {
        p.terms[i + 1] = p.terms[i];
        i--;
      }
      p.terms[i + 1] = new Term();
      p.terms[i + 1].coef = c;
      p.terms[i + 1].exp = e;
      p.nTerms++;
    }
  }

  private static int findTerm(Polynomial p, int e) {
    for (int i = 0; i < p.nTerms && p.terms[i].exp >= e; i++) {
      if (p.terms[i].exp == e) {
        return i;
      }
    }
    return -1;
  }
}
