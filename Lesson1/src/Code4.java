public class Code4 {
  /**
   * 소수 찾기
   */
  public static void main(String[] args) {

    int n = 10111;

    // 2,3, ... , sqrt(n)
    boolean isPrime = true;

    for (int i = 2; i < Math.sqrt(n); i++) {
      if (n % i == 0) {
        // not prime
        isPrime = false;
        break;
      }
    }

    if (isPrime) {
      System.out.println(n);
    }
  }
}
