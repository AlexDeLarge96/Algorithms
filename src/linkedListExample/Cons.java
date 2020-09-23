package linkedListExample;

public class Cons<T> implements CustomLinkedList<T> {

    private T head;
    private CustomLinkedList<T> tail;

    public Cons(T head, CustomLinkedList<T> tail) {
        this.head = head;
        this.tail = tail;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public T getHead() {
        return head;
    }

    @Override
    public CustomLinkedList<T> getTail() {
        return tail;
    }

    @Override
    public T get(int n) {
        return getListValue(n, this);
    }

    private T getListValue(int n, CustomLinkedList<T> list) {
        if (list.isEmpty()) {
            throw new IndexOutOfBoundsException();
        } else if (n == 0) {
            return list.getHead();
        } else {
            return getListValue(n - 1, list.getTail());
        }
    }

    @Override
    public CustomLinkedList<T> replace(int index, T value) {
        return modifyListValue(index, value, this);
    }

    private CustomLinkedList<T> modifyListValue(int index, T value, CustomLinkedList<T> list) {
        if (list.isEmpty() || index < 0) {
            throw new IndexOutOfBoundsException();
        } else if (index == 0) {
            return new Cons<>(value, list.getTail());
        } else {
            return new Cons<T>(list.getHead(), modifyListValue(index - 1, value, list.getTail()));
        }
    }

    @Override
    public CustomLinkedList<T> remove(int n) {
        return removeListValue(n, this);
    }

    private CustomLinkedList<T> removeListValue(int index, CustomLinkedList<T> list) {
        if (index == 0 && list.getTail().isEmpty()) {
            return new Nil<>();
        } else if (index == 0 && !list.getTail().isEmpty()) {
            if (list.getTail().getTail().isEmpty()) return new Cons<>(list.getTail().getHead(), new Nil<>());
            else return new Cons<>(list.getTail().getHead(), list.getTail().getTail());
        } else {
            return new Cons<>(list.getHead(), removeListValue(index - 1, list.getTail()));
        }
    }

    @Override
    public CustomLinkedList<T> insert(int index, T value) {
        return insertListValue(index, value, this);
    }

    private CustomLinkedList<T> insertListValue(int index, T value, CustomLinkedList<T> list) {
        if (index == 0) {
            return new Cons<>(value, list);
        } else {
            return new Cons<>(list.getHead(), insertListValue(index - 1, value, list.getTail()));
        }
    }

    @Override
    public CustomLinkedList<T> link(CustomLinkedList<T> list2) {
        return joinList(this, list2);
    }

    private CustomLinkedList<T> joinList(CustomLinkedList<T> list1, CustomLinkedList<T> list2) {
        if (list1.getTail().isEmpty()) {
            return new Cons<>(list1.getHead(), list2);
        } else {
            return new Cons<>(list1.getHead(), joinList(list1.getTail(), list2));
        }
    }

    @Override
    public String toString() {
        return listToString(this, "");
    }

    private String listToString(CustomLinkedList<T> list, String result) {
        if (list.isEmpty()) {
            return result + "{Nil}";
        } else {
            return listToString(list.getTail(), result + "{" + list.getHead() + "}");
        }
    }
}
