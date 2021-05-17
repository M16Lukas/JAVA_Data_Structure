package chapter1.polymorphism;

// 상속(Inheritance) : is - a 관계

// Computer : super , basic, parent class
// NoteBook : sub , extends, child  class

public class NoteBook extends Computer {

  private double screenSize;
  private double weight;

  // 상속과 생성자
  // 1. 생성자가 없을 경우 자동으로 no-parameter 생성자가 만들어진다.
  // 생성자가 하나라도 있을 경우 자동으로 만들어지지 않는다.
  // 2. 모든 서브 클래스의 생성자는 먼저 수퍼 클래스의 생성자를 호출한다.
  // - super()를 통해 명시적으로 호출
  // - 그렇지 않을 경우에는 자동으로 no-parameter 생성자 호출
  public NoteBook(String manufacturer, String processor, int ramSize, int diskSize, double processorSpeed,
      double screenSize, double weight) {
    super(manufacturer, processor, ramSize, diskSize, processorSpeed);
    this.screenSize = screenSize;
    this.weight = weight;
  }

  @Override
  public String toString() {
    String result = super.toString() + "\nscreenSize : " + screenSize + "\nweight : " + weight;

    return result;
  }

  public static void main(String[] args) {
    NoteBook tmp = new NoteBook("Dell", "i5", 4, 1000, 3.2, 15.6, 1.2);

    System.out.println(tmp.computePower());
    System.out.println(tmp);
  }
}
