package linkedListExample;

import java.util.NoSuchElementException;

public class Nil<T> implements CustomLinkedList<T> {

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public T getHead() {
        throw new NoSuchElementException("Nil.head");
    }

    @Override
    public CustomLinkedList<T> getTail() {
        throw new NoSuchElementException("Nil.tail");
    }

    @Override
    public T get(int n) {
        throw new NoSuchElementException("Nil");
    }

    @Override
    public CustomLinkedList<T> replace(int index, T value) {
        throw new NoSuchElementException("Nil");
    }

    @Override
    public CustomLinkedList<T> remove(int n) {
        throw new NoSuchElementException("Nil");
    }

    @Override
    public CustomLinkedList<T> insert(int index, T value) {
        throw new NoSuchElementException("Nil");
    }

    @Override
    public CustomLinkedList<T> link(CustomLinkedList<T> list2) {
        throw new NoSuchElementException("Nil");
    }

    @Override
    public String toString() {
        return "{Nil}";
    }
}
