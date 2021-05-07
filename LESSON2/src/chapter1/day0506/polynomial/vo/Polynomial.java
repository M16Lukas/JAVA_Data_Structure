package polynomial.vo;

public class Polynomial {
  // 하나의 다항식을 표현하기 위한 클래스
  private char name; // 다항식의 이름
  private int nTerms; // 다항식을 구성하는 항의 개수
  private Term[] terms = new Term[100]; // 다항식을 구성하는 항들을 저장할 배열

  public Polynomial(char name, int nTerms) {
    this.name = name;
    this.nTerms = nTerms;
  }

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

  public void setTerms(Term[] terms) {
    this.terms = terms;
  }

  public Term[] getTerms() {
    return terms;
  }

}
