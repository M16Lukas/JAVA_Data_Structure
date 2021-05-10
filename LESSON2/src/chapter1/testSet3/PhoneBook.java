public class PhoneBook {
  private String name;
  private String phone;

  @Override
  public String toString() {
    return "name : " + name + " " + " Phone : " + phone;
  }

  // Constructor
  public PhoneBook(String name, String phone) {
    this.name = name;
    this.phone = phone;
  }

  // Setter & Getter
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

}
