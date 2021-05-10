public class MyPoint1 {
  // 평면상 좌표축에 평행한 n개의 직사각형에 관한 데이터를 입력 받은 후
  // 면적이 작은 것부터 큰 것 순으로 정렬하여 출력
  // 0 1 2 4 : 좌표(0,1), 너비 2, 높이 4

  private int x;
  private int y;

  public MyPoint1(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }
}
