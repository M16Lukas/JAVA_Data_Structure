public class MyRectangle2 {
  private MyPoint2 lu;
  private int width;
  private int height;

  public MyRectangle2(int x, int y, int w, int h) {
    lu = new MyPoint2(x, y);
    width = w;
    height = h;
  }

  public int calArea() {
    return (width * height);
  }

  @Override
  public String toString() {
    return lu.getX() + " " + lu.getY() + " " + width + " " + height;
  }
}
