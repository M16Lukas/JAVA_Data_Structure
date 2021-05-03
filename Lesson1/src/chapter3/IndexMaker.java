package chapter3;

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

  static String[] words = new String[100000];
  static int[] count = new int[100000];
  static int n = 0; // 단어의 갯수

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
          System.out.println("The word " + words[index] + " appears " + count[index] + " times");
        } else {
          System.out.println("The word " + words[index] + " does not appears");
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

  private static void saveAs(String fileName) {
    try {
      PrintWriter outFile = new PrintWriter(new FileWriter(fileName));
      for (int i = 0; i < n; i++) {
        outFile.println(words[i] + " " + count[i]);
      }
      outFile.close();
    } catch (IOException e) {
      System.out.println("Save failed");
      return;
    }
  }

  private static void makeIndex(String filename) {
    try {
      Scanner inFile = new Scanner(new File("lib\\" + filename));
      while (inFile.hasNext()) {
        String str = inFile.next();
        addWord(str);
      }
      inFile.close();
    } catch (FileNotFoundException e) {
      System.out.println("No File");
      return;
    }
  }

  private static void addWord(String str) {
    int index = findWord(str);
    if (index != -1) { // found
      count[index]++;
    } else { // not found
      words[n] = str;
      count[n] = 1;
      n++;
    }
  }

  private static int findWord(String str) {
    for (int i = 0; i < n; i++) {
      if (words[i].equalsIgnoreCase(str)) {
        return i;
      }
    }
    return -1;
  }
}
