package listIterator;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class KWLinkedList<T> {
  private Node<T> head = null;
  private Node<T> tail = null;
  private int size = 0;

  private static class Node<E> {
    private E data;
    private Node<E> next = null;
    private Node<E> prev = null;

    public Node(E item) {
      data = item;
      next = null;
    }
  }

  public Iterator<T> iterator() {
    return new KWListIterator(0);
  }

  public ListIterator<T> listIterator() {
    return new KWListIterator(0);
  }

  public ListIterator<T> listIterator(int index) {
    return new KWListIterator(index);
  }

  private class KWListIterator implements ListIterator<T> {
    // data member and constructor
    private Node<E> nextNode;
    private Node<E> lastItemReturned;
    private int index;

    public KWListIterator(int i) {
      if (i < 0 || i > size) {
        throw new IndexOutOfBoundsException("Invalid index : " + i);
      }
      lastItemReturned = null;
      if (i == size) {
        index = size;
        nextItem = null;
      } else {
        nextItem = head;
        for (index = 0; index < i; index++) {
          nextItem = nextItem.next;
        }
      }

    }
  }

  public E next() {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
  }

  public boolean hasPrevious() {
    return (nextItem == null && size != 0) || ne
  }

  public int indexOf(T item) {
    return 0;
  }

  public void add(int index, T item) {
    listIterator(index).add(item);
  }

  public T get(int index) {
    return listIterator(index).next();
  }

  public boolean remove(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
    ListIterator<E> iter = listIterator(index);
    E result = iter.next();
    iter.remove();
    return result;
  }

  public void remove(T obj) {

  }

  public int size() {
    return size;
  }

}
