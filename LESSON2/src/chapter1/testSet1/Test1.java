import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test1 {

  static MyRectangle1[] rect = new MyRectangle1[100];
  static int n = 0;

  public static void main(String[] args) {
    try {
      Scanner in = new Scanner(new File("lib\\data.txt"));

      while (in.hasNext()) {
        int x = in.nextInt();
        int y = in.nextInt();
        int width = in.nextInt();
        int height = in.nextInt();

        rect[n++] = new MyRectangle1(x, y, width, height);
      }
    } catch (FileNotFoundException e) {
      System.out.println("No Data");
    }
    bubbleSort();
    for (int i = 0; i < n; i++) {
      int result = calc(rect[i].getWidth(), rect[i].getHeight());
      System.out.println("result : " + result);
    }

  }
  // 정렬

  private static void bubbleSort() {
    for (int i = n - 1; i >= 0; i--) {
      for (int j = 0; j < i; j++) {
        if (rect[j].getX() > rect[j + 1].getX()) {
          MyRectangle1 tmp = rect[j];
          rect[j] = rect[j + 1];
          rect[j + 1] = tmp;
        }
      }
    }
  }

  // 면적 계산
  private static int calc(int width, int height) {
    return width * height;
  }
}