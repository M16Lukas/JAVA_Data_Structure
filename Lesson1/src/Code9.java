import java.util.Scanner;

public class Code9 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("배열 길이 : ");
    int index = scanner.nextInt();

    int[] arr = new int[index];

    // 사용자로부터 n개의 정수를 입력받는다.
    // 정수가 하나씩 입력될 때마다 현재까지 입력된 정수들을 오름차순으로 정렬(sort)하여 출력하는 코드이다.
    // ordered list insert algorithm
    System.out.print("배열의 data 들 : ");
    for (int i = 0; i < index; i++) {
      int tmp = scanner.nextInt();
      int j = i - 1;
      while (j >= 0 && arr[j] > tmp) {
        arr[j + 1] = arr[j];
        j--;
      }
      arr[j + 1] = tmp;

      // 현재까지 입력된 데이터 정렬 결과 출력
      System.out.print("Sorted Data : ");
      for (int k = 0; k <= i; k++) {
        System.out.print(arr[k] + " ");
      }
    }
    scanner.close();
  }
}
