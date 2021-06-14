package poly2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MySingleLinkedList<T> {

  public Node<T> head; // 첫 번째 노드
  public Node<T> tail; // 마지막 노드
  public int size = 0; // 연결된 노드의 갯수

  public MySingleLinkedList() {
    head = null;
    tail = null;
    size = 0;
  }

  // private inner class
  private static class Node<T> {
    public T data;
    public Node<T> next;

    public Node(T data) {
      this.data = data;
      next = null;
    }
  }

  public Iterator<T> iterator() {
    return new MyIterator();
  }

  private class MyIterator implements Iterator<T>()
  {
    private Node<T> nextNode;

    public MyIterator() {
      nextNode = head;
    }

    public boolean hasNext() {
      return nextNode != null;
    }

    public T next() {
      if (nextNode == null) {
        throw new NoSuchElementException();
      }

      T tmp = nextNode.data;
      nextNode = nextNode.next;
      return tmp;
    }

    public void remove() {
      //
    }
  }

  private void addFirst(T item) {
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

  private void addAfter(Node<T> before, T item) {
    // 1. 새로운 노드를 만들고 데이터를 저장한다
    Node<T> tmp = new Node<T>(item);

    // 2. 새로운 노드의 next 필드가 before의 다음 노드를 가리키도록 한다.
    tmp.next = before.next;

    // 3. 새로운 노드를 before의 다음 노드로 만든다.
    before.next = tmp;
    size++;
  }

  private T removeFirst() {
    if (head == null) {
      return null;
    }
    // 1. head 가 null이 아니라면 head가 현재 head노드의 다음 노드를 가리키게 만든다.
    T tmp = head.data;
    head = head.next;
    size--;
    return tmp;
  }

  private T removeAfter(Node<T> before) {
    if (before.next == null) {
      return null;
    }

    T tmp = before.next.data;
    before.next = before.next.next;
    size--;
    return tmp;
  }

  // 연결리스트의 index번째 위치에 새로운 데이터를 삽입한다.
  // index - 1 번째 노드 뒤에 생성한다.
  public void add(int index, T item) { // insert
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException(index);
    }

    if (index == 0) {
      addFirst(item);
    } else {
      Node<T> tmp = getNode(index - 1);
      addAfter(tmp, item);
    }
  }

  // index 번째 노드를 삭제하고 그 노드에 저장된 데이터를 반환한다.
  public T remove(int index) { // delete
    if (index < 0 || index >= size) {
      return null;
    }

    if (index == 0) {
      return removeFirst();
    }

    Node<T> before = getNode(index - 1);
    return removeAfter(before);
  }

  // 입력된 스트링을 저장한 노드를 찾아 삭제한다.
  // 삭제된 노드에 저장된 스트링을 반환한다.
  public boolean remove(T item) {
    Node<T> p = head;
    Node<T> q = null; // q는 항상 p의 직전 노드를 가리킴
    while (p != null && !p.data.equals(item)) {
      q = p;
      p = p.next;
    }

    if (p == null) { // 삭제할 노드가 존재하지 않을 경우
      return false;
    }
    if (q == null) { // 찾는 노드가 첫번째인 경우
      T tmp = removeFirst();
      return (tmp != null);
    } else {
      T tmp = removeAfter(q);
      return (tmp != null);
    }
  }

  // 순회(traverse) : 연결리스트의 노드들을 처음부터 순서대로 방문하는 것
  public int indexOf(T item) { // search
    Node<T> p = head;
    int index = 0;

    while (p != null) {
      if (p.data.equals(item)) {
        return index;
      }

      p = p.next;
      index++;
    }

    return -1;
  }

  // 연결리스트의 index 번쨰 노드의 주소를 반환한다.
  public Node<T> getNode(int index) {
    if (index < 0 || index >= size) {
      return null;
    }

    Node<T> p = head;
    for (int i = 0; i < index; i++) {
      p = p.next;
    }

    return p;
  }

  // index 번째 노드의 데이터를 반환한다
  public T get(int index) {
    if (index < 0 || index >= size) {
      return null;
    }

    return getNode(index).data;
  }

  public static void main(String[] args) {
    MySingleLinkedList<String> list = new MySingleLinkedList<>();
    list.addFirst("Mondayyyy");
    list.addFirst("Sunday~");
    list.add(0, "saturday");
    list.add(1, "friday");
    list.add(1, "friday");
    list.add(2, "monday");
    list.remove("friday");
    int index = list.indexOf("Sunday~");

    String str = list.get(2);
    list.remove(2);
    int pos = list.indexOf("friday");
  }
}
