package node;

public class MySingleLinkedList<T> {

  public Node<T> head; // 첫 번째 노드
  public Node<T> tail; // 마지막 노드
  public int size = 0; // 연결된 노드의 갯수

  public MySingleLinkedList() {
    head = null;
    tail = null;
    size = 0;
  }

  public void addFirst(T item) {
    // 1. 새로운 노드를 새로운 head 노드로 한다.
    Node<T> newNode = new Node<T>(item); // T : type parameter
    // T t = new T(); // Not OK
    // T[] array = new T[100]; // Not OK

    // 2. 새로운 노드의 next 필드가 현재의 head노드를 가리키도록 한다.
    newNode.next = head;

    // 3. 새로운 노드를 만들고 추가할 데이터를 저장한다.
    head = newNode;
    size++;

  }

  public void addAfter(Node<T> before, T item) {
    // 1. 새로운 노드를 만들고 데이터를 저장한다
    Node<T> tmp = new Node<T>(item);

    // 2. 새로운 노드의 next 필드가 before의 다음 노드를 가리키도록 한다.
    tmp.next = before.next;

    // 3. 새로운 노드를 before의 다음 노드로 만든다.
    before.next = tmp;
    size++;
  }

  public T removeFirst() {
    if (head == null) {
      return null;
    }
    // 1. head 가 null이 아니라면 head가 현재 head노드의 다음 노드를 가리키게 만든다.
    T tmp = head.data;
    head = head.next;
    size--;
    return tmp;
  }

  public T removeAfter(Node<T> before) {
    if (before.next == null) {
      return null;
    }

    T tmp = before.next.data;
    before.next = before.next.next;
    size--;
    return tmp;
  }

  public void add(int index, T item) { // insert

  }

  public T get(int index) {
    return null;
  }

  public void remove(int index) { // delete

  }

  public int indexOf(T item) { // search
    return -1;
  }

  public static void main(String[] args) {
    MySingleLinkedList<String> list = new MySingleLinkedList<>();
    list.add(0, "saturday");
    list.add(1, "friday");
    list.add(0, "monday");

    String str = list.get(2);
    list.remove(2);
    int pos = list.indexOf("friday");
  }
}
