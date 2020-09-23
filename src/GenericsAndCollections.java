import java.util.*;
import java.util.stream.Collectors;

public class GenericsAndCollections {

    public static void main(String[] args) {
//        List<String> list1 = new ArrayList<>();
//        list1.add("one");
//        list1.add("two");
//
//        List<String> list2 = new Vector<>();
//        list2.add("one");
//        list2.add("two");
//
//        List<Double> list3 = new Stack<>();
//        list3.add(1.5);
//        list3.add(4.0);
//
//        printCollection(list1, "List1");
//        printCollection(list2, "List2");
//        printCollection(list3, "List3");
//
//
//        for (int i = 0; i < 3; i++) {
//            new Thread("thread" + i) {
//                public void run() {
//                    list2.add(currentThread().getName());
//                    System.out.println("List after threads:" + list2.toString());
//                }
//            }.start();
//        }
//        LinkedList<Integer> list4 = new LinkedList<>();
//        list4.add(1);
//        list4.add(10);
//        list4.add(5);
//
//
//        Set<String> set1 = new HashSet<>();
//        set1.add("two");
//        set1.add("one");
//        set1.add("two");
//
//        Set<Integer> sortedSet = new TreeSet<>();
//        sortedSet.add(10);
//        sortedSet.add(1);
//        sortedSet.add(0);
//        printCollection(set1, "Set1");
//        printCollection(sortedSet, "SortedSet");
//
//        Map<Integer, String> map1 = new HashMap<>();
//        map1.put(2, "two");
//        map1.put(10, "ten");
//        map1.put(1, "one");
//        map1.put(1, "two");
//        System.out.println("Map1:" + map1.toString());
//
//        Map<Integer, String> map2 = new LinkedHashMap<>();
//        map2.put(2, "two");
//        map2.put(10, "ten");
//        map2.put(1, "one");
//        map2.put(1, "two");
//        System.out.println("Map2:" + map2.toString());
//
//        IntBinaryOperator sum1 = (int x, int y) -> x + y; //Expanded lambda version
//        System.out.println(sum1.applyAsInt(1, 2));
//        IntBinaryOperator sum2 = Integer::sum; // Reduced lambda version with Method Reference
//        System.out.println(sum2.applyAsInt(1, 2));
//        IntUnaryOperator incrementOfOne = (int x) -> x + 1;
//        System.out.println(incrementOfOne.applyAsInt(10));

        Person p1 = new Person();
        p1.setAge(10);p1.setName("pepe");
        Person p2 = new Person();
        p2.setAge(20);p2.setName("Maria");
        List<Person> l1 = new ArrayList<>();
        l1.add(p1);l1.add(p2);
        List<Person> l2 = new ArrayList<>(l1);
        Person p3 = new Person();
        p3.setAge(13);p2.setName("eduard");
        l2.add(p3);
        List<Person> l3 = Arrays.asList(p1,p2);
        String [] a1 = new String[]{"one","two"};
        String[] a2 = a1.clone();
        a2[0]="asas";
        List<String> u1 = new ArrayList<>();
        u1.add("ofsdfsne");u1.add("tsdtfgsdwo");
        System.out.println(new LinkedList<>(u1));
        System.out.println("Arrays: " + a1.hashCode()+"    "+a2.hashCode());
        System.out.println(Arrays.toString(a1));
        System.out.println(Arrays.toString(a2));
        System.out.println(l1.hashCode());
        System.out.println(l2.hashCode());
        System.out.println(l1.toString());
        System.out.println(l2.toString());
        System.out.println(l1.stream().map(Person::hashCode).collect(Collectors.toList()));
        System.out.println(l2.stream().map(Person::hashCode).collect(Collectors.toList()));
    }

    public Integer add(Integer value1, Integer value2) {
        return value1 + value2;
    }

    public static <T> void printCollection(Collection<T> collection, String collectionName) {
        Iterator<T> iterator = collection.iterator();
        System.out.print(collectionName + ": ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }
}
