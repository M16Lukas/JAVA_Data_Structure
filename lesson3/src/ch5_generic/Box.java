package ch5_generic;

// T : type parameter
// T라는 가상의 타입에 의해서 parameterized 된 클래스
// 2 개 이상의 type parameter를 가질 수도 있다. 
public class Box<T> {
  private T t;

  public void set(T t) {
    this.t = t;
  }

  public T get() {
    return t;
  }
}
