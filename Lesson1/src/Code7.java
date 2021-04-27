import java.util.Scanner;

public class Code7 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int index = scanner.nextInt();
    int[] data = new int[index];
    for (int i = 0; i < index; i++) {
      data[i] = scanner.nextInt();
    }
    scanner.close();

    int max = 0;
    for (int i = 0; i < index; i++) {
      for (int j = i; j < index; j++) {
        // convert data[i]...data[j] into an integer
        int val = 0;
        for (int k = i; k < j; k++) {
          val = val * 10 + data[k];
        }

        // test if it is a prime
        boolean isPrime = true;
        for (int k = 2; k * k <= val && isPrime; k++) {
          if (val % k == 0) {
            isPrime = false;
          }
        }

        // if yes, compare to the max
        if (isPrime && val > 1 && val > max) {
          max = val;
        }
        if (max > 0) {
          System.out.println(max);
        } else {
          System.out.println("No prime number");
        }
      }
    }
  }
}
