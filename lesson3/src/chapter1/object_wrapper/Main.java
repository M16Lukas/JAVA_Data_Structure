package chapter1.object_wrapper;

/**
 * Main
 */
public class Main {
  // Class Object

  // 1. Java에서 모든 클래스의 superclass 이다.

  // 2. 맴버 메서드
  // - boolean equals(Object obj)
  // - int hashCode()
  // - String toString()
  // - Class<?> getClass()

  // 3. Java의 모든 클래스는 내가 만들어 주지 않아도
  // 이미 equals과 toString 메서드를 가지고 있다.
  // 다만 내 의도대로 작동하지는 않을 것이다.

  public int a = 10;
  public double b = 1.3;

  @Override
  public boolean equals(Object other) {
    Main other2 = (Main) other;
    return a == other2.a && b == other2.b;
  }

  public static void main(String[] args) {
    Main m1 = new Main();

    // => toString()
    // : 클래스에서 override 하지 않으면 다음과 같은 String이 반환된다.
    // ex) 클래스이름@객체의 hash code
    System.out.println(m1);

    // => equals(Object)
    // - 매개변수로 제공된 객체와 자기 자신의 동일성을 검사한다.
    // - 이 메서드를 위도대로 사용하려면 override 해야한다.

    Main m2 = new Main();
    Main m3 = new Main();
    // m2.a = 5;
    // m2.b = 1.234234;

    if (m2.equals(m3)) { // 결과 : No
      System.out.println("yes");
    } else {
      System.out.println("No");
    }
  }

}