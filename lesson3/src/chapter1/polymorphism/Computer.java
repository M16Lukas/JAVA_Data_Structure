package chapter1.polymorphism;

/**
 * Computer
 */
public class Computer {
  // Field
  protected String manufacturer;
  protected String processor;
  protected int ramSize;
  protected int diskSize;
  protected double processorSpeed;

  // Constructor
  public Computer(String manufacturer, String processor, int ramSize, int diskSize, double processorSpeed) {
    this.manufacturer = manufacturer;
    this.processor = processor;
    this.ramSize = ramSize;
    this.diskSize = diskSize;
    this.processorSpeed = processorSpeed;
  }

  // Getter & Setter
  public String getManufacturer() {
    return manufacturer;
  }

  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  public String getProcessor() {
    return processor;
  }

  public void setProcessor(String processor) {
    this.processor = processor;
  }

  public int getRamSize() {
    return ramSize;
  }

  public void setRamSize(int ramSize) {
    this.ramSize = ramSize;
  }

  public int getDiskSize() {
    return diskSize;
  }

  public void setDiskSize(int diskSize) {
    this.diskSize = diskSize;
  }

  public double getProcessorSpeed() {
    return processorSpeed;
  }

  public void setProcessorSpeed(double processorSpeed) {
    this.processorSpeed = processorSpeed;
  }

  // Override Method
  @Override
  public String toString() {
    String result = "manufacturer : " + manufacturer + "\nprocessor : " + processor + "\nramSize : " + ramSize
        + "\ndiskSize : " + diskSize + "\nprocessorSpeed : " + processorSpeed;

    return result;
  }

  // Method
  public double computePower() {
    return ramSize * processorSpeed;
  }
}