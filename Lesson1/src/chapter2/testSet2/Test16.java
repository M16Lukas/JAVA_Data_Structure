package chapter2.testSet2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test16 {
  // 파일 input16.txt에 여러 개의 단어들이 한줄에 하나씩 주어진다.
  // 이 파일을 읽어서 배열에 저장한다. 키보드로부터 문자의 개수 n과 이어서
  // n개의 문자들을 입력받아 문자 배열에 저장한다.
  // 이 배열에서 파일에 등장하는 모든 단어들을 찾아 출력하는 프로그램을 작성하라
  public static void main(String[] args) {
    try {
      Scanner scanner = new Scanner(System.in);
      Scanner inFile = new Scanner(new File("lib\\input16.txt"));

      String[] file = new String[1000];
      int index = 0;
      while (inFile.hasNext()) {
        file[index] = inFile.next();
        index++;
      }
      inFile.close();

      // 문자의 갯수
      System.out.print("n : ");
      int n = scanner.nextInt();
      scanner.nextLine();

      // n 개의 문자 입력받아 문자 배열에 저장
      String[] textArr = new String[n];
      for (int i = 0; i < n; i++) {
        System.out.print("values of N : ");
        textArr[i] = scanner.nextLine();
      }
      scanner.close();

      // 파일에 등장하는 단어 찾기
      String chktext = "";
      String[] findText = new String[n];
      int indexFind = 0;

      for (int i = 0; i < n - 1; i++) {
        chktext = textArr[i];
        for (int j = (i + 1); j < n; j++) {
          chktext += textArr[j];
          for (int k = 0; k < index; k++) {
            if (file[k].equals(chktext)) {
              findText[indexFind] = chktext;
              indexFind++;
            }
          }
        }
      }

      System.out.print("Find word : ");
      for (int i = 0; i < indexFind; i++) {
        System.out.print(findText[i] + " ");
      }

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }
}
