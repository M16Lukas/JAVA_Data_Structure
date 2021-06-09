package poly2;

public class Polynomial {

  public char name;
  public MySingleLinkedList<Term> terms = new MySingleLinkedList<>();

  public Polynomial(char name) {
    this.name = name;
  }

  // 기존의 다항식에 새로운 항을 추가하는 메서드
  public void addTerm(int coef, int expo) {
    if (coef == 0) {
      return;
    }

    Node<Term> p = terms.head, q = null;
    while (p != null && p.data.expo > expo) {
      q = p;
      p = p.next;
    }

    // 추가하려는 항과 동일 차수의 항이 이미 있는 경우
    if (p != null && p.data.expo == expo) {
      p.data.coef += coef;
      if (p.data.coef == 0) {
        // remove this node
        if (q == null) {
          terms.removeFirst();
        } else {
          terms.removeAfter(q);
        }
      }
    } else { // 그렇지 않은 경우 : 새로운 항을 삽입(차수의 내림차순으로 정렬)
      Term t = new Term(coef, expo);
      if (q == null) { // 차수가 제일 큰 경우
        terms.addFirst(t);
      } else {
        terms.addAfter(q, t);
      }
    }
  }

  public int calc(int x) {
    int result = 0;
    Node<Term> p = terms.head;
    while (p != null) {
      result += p.data.calc(x);
      p = p.next;
    }
    return result;
  }

  @Override
  public String toString() {
    String result = "";
    Node<Term> p = terms.head;
    while (p != null) {
      result += "+" + p.data;
      p = p.next;
    }
    return result;
  }
}
