package ch5_generic;

public class Main {
  // Generic Programming
  // "데이터 형식에 의존하지 않고"
  // 하나의 값이 여러 다른 데이터 타입들을 가실 수 있는
  // 기술에 중점을 두어 재사용성을 높일 수 있는 프로그래밍 방식

  // 1. Generic한 변수/ 자료구조
  // Event ev;
  // Event[] events = new Event[];
  // Object obj; // Object는 모든 자료형을 가질 수 있다

  // 2. Generic 한 알고리즘 (Method)
  // Arrays.sort(events, 0, n);

  // 3. Generic 클래스
  // Generics

  // class Object vs Generics

  // Object 클래스의 경우 return type이 Object 이므로 반드시
  // type casting 해주어야한다.

  public static void main(String[] args) {
    // 객체를 생성하는 시점에 가상의 타입 T를 실제하는 타입으로 지정해준다.
    Box<Integer> integerbox = new Box<Integer>();
    integerbox.set(10);
    System.out.println(integerbox.get());
  }
}
