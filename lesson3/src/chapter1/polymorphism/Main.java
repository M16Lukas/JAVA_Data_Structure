package chapter1.polymorphism;

public class Main {
  // ****** 다형성 : Polymorphism *******
  // - 슈퍼클래스의 타입의 변수가 서브클래스 타입의 객체를 참조할 수 있다.

  public static void main(String[] args) {
    // Computer 타입 변수 theComputer가 Notebook 타입의 객체를 참조하고 있다
    Computer theComputer = new NoteBook("Asus", "AMD", 4, 240, 24, 15, 0.75);

    // theComputer는 Computer 타입의 변수이면서 실제로는 NoteBook 객체를 참조하고 있다.
    // 그리고 두 클래스는 각자의 toString()을 가지고 있다.
    // 그렇다면 여기서 둘 중 어느 toString() 메서드가 실행될까? NoteBook의 toString()이 실행된다.
    // 즉, 동적 바인딩(Dynamic binding)이 일어난다.
    System.out.println(theComputer);

  }
}
