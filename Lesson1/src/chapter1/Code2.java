package chapter1;

public class Code2 {
  public static void main(String[] args) {
    int[] grades = new int[5];

    grades[0] = 1;
    grades[1] = 2;
    grades[2] = 3;
    grades[3] = 4;
    grades[4] = 5;

    for (var i = 0; i < grades.length; i++) {
      System.out.println("Grade : " + grades[i]);
    }
  }
}
