public class MyRectangle1 {
  private MyPoint1 lu;
  private int width;
  private int height;

  public MyRectangle1(int x, int y, int w, int h) {
    lu = new MyPoint1(x, y);
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
