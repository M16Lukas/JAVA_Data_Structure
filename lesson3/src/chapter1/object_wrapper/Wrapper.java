package chapter1.object_wrapper;

public class Wrapper {
  /**
   * Wrapper Class
   */

  // 1. Java 에서 primitive type 데이터와 non-primitive type 데이터(즉, 객체)
  // 근본적으로 다르게 처리된다.

  // 2. 가령 Object 타입의 배열에는 다형성의 원리에 의해서 모든 종류의 객체를 저장할 수 있다.
  // 하지만, int, double, char 등의 primitive type 데이터는 저장할 수 없다.
  // 객체가 아니므로

  // 3. primitive type 데이터를 객체로 만들어야할 경우가 있다.
  // 이럴때 Integer, Double, Character 등의 wrapper class를 이용한다.

  // 4. 기본 타입의 데이터를 하나의 객체로 포장해주는 클래스
  // ex)
  // int a = 20;
  // Integer age = new Integer(a); // wrapping
  // int b = age.intValue(); // unwrapping : b becomes 20

  // 5. 데이터 타입간의 변환 기능을 제공
  // String str = "123123";
  // int c = Integer.parseInt(str); // 123123

  /**
   * Autoboxing 과 Unboxing
   */
  // Object[] theArray = new Object[100];

  // theArray[0] = 10;
  // -> 10은 정수이다 하지만 이 경우 Java 컴파일러가 자동으로 이것을 Integer 객체로 변환해준다
  // 이것을 autoboxing 이라고 부른다

  // int a = (Integer)theArray[0];
  // -> theArray[0]에 저장된 것은 Integer객체이지만 Java컴파일러가
  // 자동으로 정수로 변환해준다. 이것을 unboxing 이라고 부른다.
  //
}
