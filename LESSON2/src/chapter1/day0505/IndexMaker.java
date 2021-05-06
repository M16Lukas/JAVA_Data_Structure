package chapter1.day0505;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class IndexMaker {
  // 인덱스 메이커
  // 입력으로 하나의 텍스트 파일을 읽는다.
  // 텍스트 파일에 등장하는 모든 단어들의 목록을 만들고, 각 단어가
  // 텍스트 파일에 등장하는 횟수를 센다. 단, 단어 갯수는 100,000 개 이하
  // 사용자가 요청하면 단어 목록을 하나의 파일로 저장한다.
  // 사용자가 단어를 검색하면 그 단어가 텍스트 파일에 몇번 등장하는지 출력

  // [ 실행 예 ]
  // $ read sample.txt
  // $ find heaven
  // The word "heaven" appears 13 times
  // $ saveas index.txt
  // $ find java
  // The word "java" does not appear
  // $ exit

  // static String[] words = new String[100000]; // 단어 저장
  // static int[] count = new int[100000]; // 단어 별 갯수 저장

  static Item[] items = new Item[100000];
  static int n = 0; // 전체 단어의 갯수

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    while (true) {
      System.out.print("$ ");
      String command = sc.nextLine();

      if (command.equals("read")) {
        String filename = sc.nextLine();
        makeIndex(filename);

      } else if (command.equals("find")) {
        String str = sc.nextLine();
        int index = findWord(str);
        if (index != -1) {
          System.out.println("The word " + items[index].word + " appears " + items[index].count + " times");
        } else {
          System.out.println("The word " + items[index].word + " does not appears");
        }

      } else if (command.equals("saves")) {
        String fileName = sc.nextLine();
        saveAs(fileName);

      } else if (command.equals("exit")) {
        break;
      }
    }
    sc.close();
  }

  private static void makeIndex(String filename) {
    try {
      Scanner inFile = new Scanner(new File("lib\\" + filename));
      while (inFile.hasNext()) {
        String str = inFile.next();
        String trimmed = trimming(str);
        if (trimmed != null) {
          // case 3 : 대문자와 소문자가 다른 단어로 취급된다.
          String t = trimmed.toLowerCase();
          addWord(t);
        }
      }
      inFile.close();
    } catch (FileNotFoundException e) {
      System.out.println("No File");
      return;
    }
  }

  // 단어 앞뒤에 붙은 특수문자 제거하기
  private static String trimming(String str) {
    int i = 0, j = str.length() - 1;

    // case 1 : 소수점, 쉼표 등의 특수기호가 단어에 포함
    // while i-th character is not letter
    // 234&^%&^&
    // 첫번째 letter 위치
    while (i <= str.length() && !Character.isLetter(str.charAt(i))) {
      i++;
    }

    // 234&^%&^&
    // 마지막 letter 위치
    while (j >= 0 && !Character.isLetter(str.charAt(j))) {
      j--;
    }

    // case 2 : 숫자 등이 단어로 취급 == 문자열안에 알파벳이 하나도 없는 경우
    if (i > j) {
      return null;
    } else {
      return str.substring(i, j + 1);
    }
  }

  private static void addWord(String str) {
    int index = findWord(str);
    if (index != -1) { // found
      items[index].count++;
    } else { // not found
      // case 4 : 단어들이 알파벳 순으로 정렬
      // ordered list on insert
      int i = n - 1;
      while (i >= 0 && items[i].word.compareTo(str) > 0) {
        // shift
        items[i + 1] = items[i];
        i--;
      }
      items[i + 1] = new Item();
      items[i + 1].word = str;
      items[i + 1].count = 1;
      n++; // 새로운 단어가 추가 되었으므로 값 증가
    }
  }

  private static int findWord(String str) {
    for (int i = 0; i < n; i++) {
      if (items[i].word.equalsIgnoreCase(str)) {
        return i;
      }
    }
    return -1;
  }

  private static void saveAs(String fileName) {
    try {
      PrintWriter outFile = new PrintWriter(new FileWriter(fileName));
      for (int i = 0; i < n; i++) {
        outFile.println(items[i].word + " " + items[i].count);
      }
      outFile.close();
    } catch (IOException e) {
      System.out.println("Save failed");
      return;
    }
  }
}
