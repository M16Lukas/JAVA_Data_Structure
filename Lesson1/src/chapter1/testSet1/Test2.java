package chapter1.testSet1;

public class Test2 {
  // 1 ~ 100000 사이의 정수들 중에 가장 작은 50개의 소수를 찾아 그 합을 구하여 출력
  // 만약 소수의 개수가 50개 미만이라면 모든 소수의 합을 출력
  public static void main(String[] args) {
    int number = 100000;
    int sumNumber = 0;

    int cnt = 0;
    for (int i = 2; i <= number; i++) { // 1 ~ 10000 사이의 정수들
      boolean isPrime = true;
      for (int j = 2; j * j <= i && isPrime; j++) { // 1 ~ 자기 자신
        if (i % j == 0) {
          isPrime = false;
        }
      }

      if (isPrime) {
        if (cnt <= 50) {
          sumNumber += i;
          cnt++;
        } else {
          break;
        }
      }
    }
    System.out.println("가장 작은 50개의 소수의 합 : " + sumNumber);
  }
}
