package polynomial3;

public class Term3 {
  // 다항식을 구성하는 하나의 항을 표현하기 위한 클래스
  // 계수(coef)와 차수(exp)를 가진다

  // field
  private int coef;
  private int exp;

  // Constructor
  public Term3(int coef, int exp) {
    this.coef = coef;
    this.exp = exp;
  }

  @Override
  public String toString() {
    return coef + "x^" + exp;
  }

  // Getter & Setter
  public int getCoef() {
    return coef;
  }

  public void setCoef(int coef) {
    this.coef = coef;
  }

  public void plusCoef(int coef) {
    this.coef += coef;
  }

  public int getExp() {
    return exp;
  }

  public void setExp(int exp) {
    this.exp = exp;
  }

  // Methoed
  public int clacTerm(int x) {
    return (int) (coef * Math.pow(x, exp));
  }

}
