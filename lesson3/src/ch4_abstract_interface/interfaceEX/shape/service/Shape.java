package ch4_abstract_interface.interfaceEX.shape.service;

public abstract class Shape {
  public String name;

  public Shape(String name) {
    this.name = name;
  }

  public abstract double computerArea();

  public abstract double computerPerimeter();

  public int compareTo(Object o) {
    double myArea = computerArea();
    double yourArea = ((Shape) o).computerArea();
    if (myArea < yourArea)
      return -1;
    else if (myArea > yourArea)
      return 1;
    else
      return 0;
  }
}
