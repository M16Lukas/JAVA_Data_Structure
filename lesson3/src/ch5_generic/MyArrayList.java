package ch5_generic;

import java.util.Arrays;

// Generic한 리스트 클래스 만들기
public class MyArrayList<T> {
  private static final int INIT_CAPACITY = 10;
  private T[] theData;
  private int size;
  private int capacity = 0;

  public MyArrayList() {
    theData = (T[]) new Object[INIT_CAPACITY];
    size = 0;
    capacity = INIT_CAPACITY;
  }

  public void add(int index, T anEntry) {
    if (index < 0 || index > size) { // exception
      throw new ArrayIndexOutOfBoundsException(index);
    }
    if (size >= capacity) {
      reallocate();
    }
    for (int i = size - 1; i >= index; i--) {
      theData[i + 1] = theData[i];
    }
    theData[index] = anEntry;
    size++;
  }

  private void reallocate() {
    capacity *= 2;
    theData = Arrays.copyOf(theData, capacity);
  }

  public void add(T anEntry) {
    add(size, anEntry);
  }

  public int size() {
    return size;
  }

  public int indexOf(T anEntry) {
    for (int i = 0; i < size; i++) {
      // indexOf 메서드가 의도한 대로 작동하려면 클래스 T는 eqauls 메서드를 overriding 해야한다
      if (theData[i].equals(anEntry)) {
        return i;
      }
    }
    return -1;
  }

  public T get(int index) {
    if (index < 0 || index >= size) { // exception
      throw new ArrayIndexOutOfBoundsException(index);
    }

    return theData[index];
  }

  public T set(int index, T newValue) {
    if (index < 0 || index >= size) { // exception
      throw new ArrayIndexOutOfBoundsException(index);
    }

    T oldValue = theData[index];
    theData[index] = newValue;

    return oldValue;
  }

  public T remove(int index) {
    if (index < 0 || index >= size) { // exception
      throw new ArrayIndexOutOfBoundsException(index);
    }

    T returnValue = theData[index];

    for (int i = index + 1; i < size; i++) {
      theData[i - 1] = theData[i];
    }
    size--;
    return returnValue;
  }
}
