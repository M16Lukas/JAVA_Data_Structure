package ch4_abstract_interface.interfaceEX.shape.ui;

import java.util.Scanner;

import ch4_abstract_interface.interfaceEX.shape.service.ShapeService;

public class ShapeUI {
  private Scanner scanner = new Scanner(System.in);
  private ShapeService ss = new ShapeService();

  public ShapeUI() {
    processCommand();
  }

  private void processCommand() {
    while (true) {
      System.out.print("$ ");
      String command = scanner.next();

      switch (command) {
        case "add":
          handleAdd();
          break;
        case "show":
        case "showdetail":
          handleShow(command.equals("show"));
          break;
        case "sort":
          BubbleSort();
          break;
        case "exit":
          scanner.close();
          System.exit(0);
          break;
        default:
          break;
      }
    }
  }

  private void handleAdd() {
    String type = scanner.next();
    switch (type) {
      case "r":
        ss.addShape(scanner.nextInt(), scanner.nextInt());
        break;
      case "c":
        ss.addShape(scanner.nextInt());
        break;
      case "t":
        break;
    }
  }

  private void handleShow(boolean detailed) {
    ss.handleShow(detailed);
  }

  private void BubbleSort() {
    ss.BubbleSort();
  }
}
