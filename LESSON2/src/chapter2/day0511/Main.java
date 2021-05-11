import java.io.File;
import java.util.Scanner;

/**
 * Main
 */
public class Main {

  /**
   * 다각형과 점 입력으로 하나의 직교 다각형과 또 하나의 점 p가 주어질 때
   * 
   * 그 점이 다각형의 내부에 있는지 외부에 있는지 판단하는 프로그램 작성
   * 
   * [ex] 시계 방향으로 꼭지점의 좌표가 주어짐
   */
  public static void main(String[] args) {
    try {
      Scanner in = new Scanner(new File("lib\\data2.txt"));
      int n = in.nextInt();

      // 꼭지점의 개수를 먼저 입력받아 다각형을 생성
      OrthoPolygon thePolygon = new OrthoPolygon(n);

      // 꼭지점의 좌표를 시계방향 순서로 입력받아 다각형에 추가한다.
      for (int i = 0; i < n; i++) {
        thePolygon.addVertex(in.nextInt(), in.nextInt());
      }

      // 테스트할 참의 좌표를 입력받아 점 p를 생성한다
      MyPoint thePoint = new MyPoint(in.nextInt(), in.nextInt());
      in.close();

      // 내부인지 외부인지 검사한다.
      if (thePolygon.contains(thePoint)) {
        System.out.println("Yes");
      } else {
        System.out.println("No");
      }
    } catch (Exception e) {
      System.out.println("No data files exists");
      System.exit(0);
    }
  }
}