public class OrthoLine {
  // 수직 / 수평 성분 표시

  // field
  private MyPoint u; // 한쪽 끝점
  private MyPoint v; // 다른쪽 끝점

  // constructor
  public OrthoLine(MyPoint u, MyPoint v) {
    this.u = u;
    this.v = v;

    // 수직 : u(위) - y 값이 더 작음, v(아래)
    // 수평 : u(왼) - x 값이 더 작음, v(오른)
    if (u.getX() > v.getX() || u.getX() == v.getX() && u.getY() > v.getY()) {
      swap();
    }
  }

  public OrthoLine(int x1, int y1, int x2, int y2) {
    u = new MyPoint(x1, y1);
    v = new MyPoint(x2, y2);
  }

  // Getter & Setter
  public MyPoint getU() {
    return u;
  }

  public void setU(MyPoint u) {
    this.u = u;
  }

  public MyPoint getV() {
    return v;
  }

  public void setV(MyPoint v) {
    this.v = v;
  }

  // Method
  // swap
  private void swap() {
    MyPoint tmp = u;
    u = v;
    v = tmp;
  }

  // 수직 성분인지 확인하는 기능
  // x 좌표값이 동일한지 확인
  public boolean isVerical() {
    return (u.getX() == v.getX());
  }

  // 두 성분이 교차하는지 확인
  public boolean intersects(OrthoLine other) {
    if (isVerical() && !other.isVerical()) { // 수직 && 수평
      return (other.u.getX() < u.getX() && other.v.getX() > v.getX() && u.getY() < other.u.getY()
          && v.getY() > other.v.getY());
    } else if (!isVerical() && other.isVerical()) { // 수평 && 수직
      return (other.u.getY() < u.getY() && other.v.getY() > v.getY() && u.getX() < other.u.getX()
          && v.getX() > other.v.getX());
    } else {
      return false;
    }
  }
}
