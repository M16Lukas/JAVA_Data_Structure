public class StaticMain {
  // 1. 왜 main 메서드는 반드시 static이어야 하는가?
  /**
   * main은 프로그램의 출발점이므로 다른 클래스에서 main이 속해있는 객체를
   * 
   * 생성할 수 없기 때문에
   */

  // 2. 왜 static 메서드에서 같은 클래스의 non-static 맴버를 엑세스 할 수 없는가?
  /**
   * static 메서드는 class 메서드이고 non-static 멤버는 Object 멤버 이므로
   * 
   * non-static 멤버는 new 를 통해 객체를 생성하지 전까진
   * 
   * 실체가 없기 때문에 엑세스 할 수 없다.
   */

  // 3. 다른 클래스에 속한 static 멤버는 어떻게 엑세스 하는가?
  /**
   * 클래스이름.static 멤버 형식으로 엑세스 한다.
   */

  // 4. static 메서드/필드의 용도는?
  /**
   * 1) main 메서드
   * 
   * 2) 상수 혹은 클래스 당 하나만 유지하고 있으면 되는 값(혹은 객체)
   * 
   * ex) Math.PI, System.out
   * 
   * 3) 순수하게 기능만으로 정의되는 메서드, 매게변수에 의존하는 메서드
   * 
   * ex) 수학함수 : Math.abs(k), Math.sqrt(k), Math.min(a, b)
   */
}
