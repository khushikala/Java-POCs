import java.util.Iterator;
import java.util.LinkedList;

public class eg2_linkedlist {
    public static void main(String[] args)
    {
    LinkedList<Integer> l1 = new LinkedList<>();
    var l2 = new LinkedList<Integer>();
        l1.add(6);
        l1.add(5);
        l1.add(7);
        l1.add(4);
        l1.addFirst(4);
        l2.add(10);
        l2.add(20);

        l1.addAll(l2);
//        l1.addLast(299838);

//        System.out.println(l1.contains(222));
//        System.out.println(l1.indexOf(10));
//        System.out.println("--------------------------");
//        System.out.println(l1.indexOf(1254));
//        System.out.println(l1.indexOf(7));
//        System.out.println(l1.lastIndexOf(7));
//        l1.set(1, 234);
//        l1.clear();
//        l1.removeAll(l2);
//        l1.removeIf(n -> (n%5 == 0));
//        System.out.println(Arrays.toString(l1.toArray()));


//        for(int i = 0; i < l1.size(); i++)
//        {
//            System.out.print(l1.get(i));
//            System.out.print(", ");
//        }

//        Iterator<Integer> iterator = l1.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }

        for (Integer integer : l1) {
            System.out.println(integer);
        }
}
}
