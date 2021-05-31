package ch4_abstract_interface.interfaceEX.shape.service;

public class Circle extends Shape {
  public int radius;

  public Circle(int radius) {
    super("Circle");
    this.radius = radius;
  }

  @Override
  public double computerArea() {
    return Math.PI * radius * radius;
  }

  @Override
  public double computerPerimeter() {
    return 2.0 * Math.PI * radius;
  }

  @Override
  public String toString() {
    return "Circle : radius is " + radius;
  }

}
