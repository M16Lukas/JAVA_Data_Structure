package chapter1.testSet1;

public class Test1 {
  // 1 ~ 100000 사이의 정수들 중 소수의 갯수를 출력하는 프로그램을 작성하라
  // 소수(prime number) : 1 보다 큰 자연수 중 1과 자기 자신만을 약수로 가지는 수
  public static void main(String[] args) {
    int number = 100000;
    int cnt = 0;
    for (int i = 2; i <= number; i++) { // 1 ~ 10000 사이의 정수들
      boolean isPrime = true;
      for (int j = 2; j * j <= i && isPrime; j++) { // 1 ~ 자기 자신
        if (i % j == 0) {
          isPrime = false;
        }
      }

      if (isPrime)
        cnt++;
    }
    System.out.println("1과 " + number + " 사이의 소수의 갯수 : " + cnt);
  }
}
