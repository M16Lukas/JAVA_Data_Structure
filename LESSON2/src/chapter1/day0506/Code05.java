import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Code05 {

  static MyRectangle1[] rects = new MyRectangle1[100];
  static int n = 0;

  public static void main(String[] args) {
    try {
      Scanner in = new Scanner(new File("lib\\data.txt"));

      while (in.hasNext()) {
        rects[n++] = new MyRectangle1(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());
      }
      in.close();
    } catch (FileNotFoundException e) {
      System.out.println("No File Data");
      System.exit(0);
    }

    bubbleSort();

    for (int i = 0; i < n; i++) {
      rects[i].toString();
    }
  }

  private static void bubbleSort() {
    for (int i = n - 1; i > 0; i--) {
      for (int j = 0; j < i; j++) {
        if (rects[j].calArea() > rects[j + 1].calArea()) {
          MyRectangle1 tmp = rects[j];
          rects[j] = rects[j + 1];
          rects[j + 1] = tmp;
        }
      }
    }
  }
}
