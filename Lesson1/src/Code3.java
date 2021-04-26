import java.util.Scanner;

public class Code3 {
  /*
   * n 개의 정수를 입력받아 순서대로 배열에 저장한다. 그런 다음 모든 정수들을 한칸씩 오른쪽으로 shift하라. 마지막 정수는 배열의 첫
   * 칸으로 이동하라.
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("배열의 크기를 입력하세요 : ");
    int n = scanner.nextInt();
    int[] data = new int[n];

    System.out.println("입력 값들을 입력하세요");
    for (int i = 0; i < n; i++) {
      data[i] = scanner.nextInt();
      scanner.nextLine();
    }
    scanner.close();

    for (int i = 0; i < n - 1; i++) {
      int temp = 0;

      temp = data[i + 1];
      data[i + 1] = data[0];
      data[0] = temp;
    }

    System.out.print("결과 : ");
    for (int i = 0; i < n; i++) {
      System.out.print("\t" + data[i]);
    }
  }
}
