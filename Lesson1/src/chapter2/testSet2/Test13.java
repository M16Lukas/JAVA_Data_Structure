package chapter2.testSet2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test13 {
  // 데이터 파일 input.txt 에 사람들의 이름과 나이가
  // 아래 그림과 같은 형식으로 저장되어 있다. 단 이름은 하나의 영문 단어라고 가정
  // 이 데이터 파일을 읽은 후 사람들을 나이순으로 정렬하여 출력
  // 단, 나이가 같은 경우 이름의 알파벳 순으로 정렬
  static String[] name = new String[1000];
  static int[] age = new int[1000];
  static int cnt = 0;

  public static void main(String[] args) {
    try {
      Scanner inFile = new Scanner(new File("lib\\input.txt"));

      while (inFile.hasNext()) {
        name[cnt] = inFile.next();
        age[cnt] = inFile.nextInt();
        cnt++;
      }

      // 사람들을 나이순(오름차순)으로 정렬
      bubbleSort();

      printArray();

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  // 사람들을 나이순(오름차순)으로 정렬
  private static void bubbleSort() {
    int temp = 0;
    String tmp = null;
    for (int i = 0; i < cnt - 1; i++) {
      for (int j = (i + 1); j < cnt; j++) {
        if (age[i] > age[j]) {
          // swap age[i] to age[j]
          temp = age[i];
          age[i] = age[j];
          age[j] = temp;

          // swap name[i] to name[j]
          tmp = name[i];
          name[i] = name[j];
          name[j] = tmp;
        } else if (age[i] == age[j]) {
          // 단, 나이가 같을 경우 이름의 알파벳 순으로 정렬
          if (name[i].compareTo(name[j]) > 0) {
            // 사전식 순서 비교
            // > : 1 , == : 0(=equals), < : -1
            // swap name[i] to name[j]
            tmp = name[i];
            name[i] = name[j];
            name[j] = tmp;
          }
        }
      }
    }
  }

  private static void printArray() {
    for (int i = 0; i < cnt; i++) {
      System.out.println(name[i] + " " + age[i]);
    }
  }

}
