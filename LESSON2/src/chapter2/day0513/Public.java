package chapter2.day0513;

public class Public {
  // [ 접근 제어어 ]

  // public : "클래스 외부"에서 접근 가능하다
  // private : "클래스 내부에서만" 접근 가능하다

  // [ 데이터 캡슐화 ]
  // 모든 데이터 멤버를 private으로 만들고 필요한 경우에 public한 get/set 메서드 제공
  // 이렇게 하면 객체가 제공해주는 메서드를 통하지 않고서는 객체 내부의 데이터에 접근할 수 없다
  // 이것을 data encapsulation or imformation hiding 이라 한다.

  // protected : "동일 패키지의 다른 클래스" "다른 패키지의 하위 클래스"에서 접근 가능
  // default : "동일 패키지에 있는 다른 클래스"에서 접근 가능하다
}
