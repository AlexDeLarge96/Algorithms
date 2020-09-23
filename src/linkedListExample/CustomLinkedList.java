package linkedListExample;

public interface CustomLinkedList<T> {

    boolean isEmpty();

    T getHead();

    CustomLinkedList<T> getTail();

    T get(int n);

    CustomLinkedList<T> replace(int index, T value);

    CustomLinkedList<T> remove(int n);

    CustomLinkedList<T> insert(int index, T value);

    CustomLinkedList<T> link(CustomLinkedList<T> list2);
}
