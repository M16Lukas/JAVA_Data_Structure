package ch4_abstract_interface.interfaceEX.shape.service;

import java.util.Arrays;

public class ShapeService {
  private int capacity = 10;
  private Shape[] shapes = new Shape[capacity];
  private int n = 0;

  public void reallocate() {
    capacity *= 2;
    Shape[] tmp = new Shape[capacity];
    System.arraycopy(shapes, 0, tmp, 0, shapes.length);
    shapes = tmp;
  }

  public void addShape(int w, int h) {
    if (n >= capacity) {
      reallocate();
    }
    shapes[n++] = new Rectangle(w, h);
  }

  public void addShape(int r) {
    if (n >= capacity) {
      reallocate();
    }
    shapes[n++] = new Circle(r);
  }

  public void handleShow(boolean detailed) {
    for (int i = 0; i < n; i++) {
      System.out.println((i + 1) + ". " + shapes[i]);
      if (!detailed) {
        System.out.println("\tThe area is " + shapes[i].computerArea());
        System.out.println("\tThe parimeter is " + shapes[i].computerPerimeter());
      }
    }
  }

  public void BubbleSort() {
    Arrays.sort(shapes,0,n);
  }
}
