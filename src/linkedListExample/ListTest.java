package linkedListExample;

public class ListTest {

    public static void main(String[] args) {
        CustomLinkedList<Integer> list1 = new Cons<>(1, new Cons<>(4, new Nil<>()));
        CustomLinkedList<Integer> list2 = new Cons<>(2, new Nil<>());
        System.out.println(list1.toString());
        System.out.println(list2.toString());
        System.out.println(list1.getHead());
        System.out.println(list1.getTail());
        System.out.println(list1.get(1));
        System.out.println(list1.replace(0, 10));
        System.out.println(list1.remove(0));
        System.out.println(list1.insert(1, 20));
        System.out.println(list1.link(list2));
    }
}
