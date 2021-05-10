import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
  static Scanner sc = new Scanner(System.in);
  static PhoneBook[] books = new PhoneBook[100];

  static String name;
  static String phone;
  static int n = 0;

  public static void main(String[] args) {
    try {
      Scanner in = new Scanner(new File("lib\\phone.txt"));
      while (in.hasNext()) {
        name = in.next();
        phone = in.next();

        books[n++] = new PhoneBook(name, phone);
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    boolean run = true;

    while (run) {
      System.out.print("$ ");
      String key = sc.next();

      switch (key) {
        case "find": // 전화번호를 찾아서 출력한다.
          name = sc.next();
          int index = findPhoneNumer(name);
          if (index == -1) {
            System.out.println("Can't find phone number");
          } else {
            System.out.println(books[index].getPhone());
          }
          break;
        case "add": // 새로운 사람을 추가한다.
          name = sc.next();
          phone = sc.next();
          books[n++] = new PhoneBook(name, phone);
          break;
        case "remove": // 정보를 삭제한다.
          name = sc.next();
          removeInfo(name);
          break;
        case "list": // 모든사람의 이름과 정보를 출력한다.
          listInfo();
          break;
        case "exit":
          run = false;
          sc.close();
          break;
      }
    }
  }

  private static int findPhoneNumer(String name) {
    for (int i = 0; i < n; i++) {
      if (books[i].getName().equals(name)) {
        return i;
      }
    }
    return -1;
  }

  private static void removeInfo(String name) {
    int idx = findPhoneNumer(name);
    if (idx == -1) {
      System.out.println("No Data");
    } else {
      for (int i = idx; i < n - 1; i++) {
        PhoneBook tmp = books[i];
        books[i] = books[i + 1];
        books[i + 1] = tmp;
      }
      n -= 1;
      System.out.println("성공적으로 삭제 했습니다.");
    }
  }

  private static void listInfo() {
    for (int i = 0; i < n; i++) {
      System.out.println(books[i]);
    }
  }
}
