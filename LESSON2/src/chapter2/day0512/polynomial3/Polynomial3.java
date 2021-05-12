package polynomial3;

public class Polynomial3 {
  // 하나의 다항식을 표현하기 위한 클래스

  // field
  private char name; // 다항식의 이름
  private int nTerms; // 다항식을 구성하는 항의 개수
  private Term3[] terms = new Term3[100]; // 다항식을 구성하는 항들을 저장할 배열

  // Constructor
  public Polynomial3(char name, int nTerms) {
    this.name = name;
    this.nTerms = nTerms;
  }

  // Getter & Setter
  public void setName(char name) {
    this.name = name;
  }

  public char getName() {
    return name;
  }

  public void plusnTerms(int nTerms) {
    this.nTerms += nTerms;
  }

  public int getnTerms() {
    return nTerms;
  }

  public void setTerms(Term3[] terms) {
    this.terms = terms;
  }

  public Term3[] getTerms() {
    return terms;
  }

  // Method
  /**
   * 입력된 차수값(exp)이 배열안에 존재하는지 확인
   * 
   * @param p : Polynomial Class Array
   * @param e : exp
   * @return i : index
   */
  public int findTermExp(int e) {
    for (int i = 0; i < nTerms && terms[i].getExp() >= e; i++) {
      if (terms[i].getExp() == e) {
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
  public void addTerm(int c, int e) {
    int index = findTermExp(e);
    if (index != -1) { // 동일한 차수가 이미 존재하는 경우 계수(coef, c) 합한다
      terms[index].plusCoef(c);
    } else {
      // 저장된 차수들보다 입력된 차수가 클 경우 배열 shift(방향 : ->)
      int i = nTerms - 1;
      while (i >= 0 && terms[i].getExp() < e) {
        terms[i + 1] = terms[i];
        i--;
      }

      // 배열 정렬 후 입력된 계수와 차수의 값 입력
      terms[i + 1] = new Term3(c, e);

      // 항의 개수 추가
      plusnTerms(1);
    }
  }

  /**
   * 다항 함수를 게산하는 기능
   * 
   * @param p : Polynomial Class Array
   * @param x
   * @return result : 다항함수 연산 결과
   */
  public int calcPolynomial(int x) {
    int result = 0;
    for (int i = 0; i < nTerms; i++) {
      result += terms[i].clacTerm(x);
    }
    return result;
  }

  /**
   * 다항함수 출력 기능
   * 
   * @param p : Polynomial Class Array
   */
  public void printPolynomial() {
    for (int i = 0; i < nTerms; i++) {
      System.out.print(terms[i]);
      if (i != nTerms - 1) {
        System.out.print(" + ");
      }
    }
    System.out.println();
  }
}
