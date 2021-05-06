package chapter1.day0505;

public class Code01 {
  public static void main(String[] args) {

    // 프리미티브 타입과 클래스 : 차이점
    // a 라는 이름의 변수가 만들어지지만 그 "안"에
    // 이름(name)과 전화번호(number) 가 저장되지는 않는다.
    // new 명령으로 따로 만들어서 그 객체의 주소(참조)를 저장할 수 있다.

    // [[ The Role is very Simple ]]
    // 모든 프리미티브 타입 변수는 "보통 변수" 이다.
    // 즉, 변수 자체에 값이 저장된다.
    // 프리미티브 타입이 아닌 모든 변수는 "참조 변수"이다.
    // 즉, 실제 데이터가 저장될 "객체"는 new 명령으로 따로 만들어야 하고,
    // 참조변수에는 그 "객체의 주소"를 저장한다.

    Person1 first; // 참조변수(포인터) 선언
    first = new Person1(); // new 명령어로 생성된 Person type의 객체 주소값 저장(참조)
    first.name = "John";
    first.number = "010-1111-2222";
    System.out.println("Name : " + first.name + " number : " + first.number);

    Person1 second = first; // first와 second 가 동일한 객체를 참조
    second.name = "Tom";

    System.out.println("Name : " + second.name + " number : " + second.number);
    System.out.println("Name : " + first.name + " number : " + first.number);

    // 클래스와 객체
    // int[] members = new int[8];
    // 배열은 프리미티브 타입이 아니다. 프리미티브 타입 배열이라고 하더라도 배열의 각 원소가
    // 프리미티브 타입인 것이지 배열 자체가 프리미티브 타입인 것은 아니다.
    // 따라서 배열의 이름 members 는 참조 변수(포인터)다.
    Person1[] members = new Person1[100];
    members[0] = first;
    members[1] = second;
    System.out.println("Name : " + members[0].name + " number : " + members[0].number);

    System.out.println("Name : " + members[2].name + " number : " + members[2].number);

  }
}
