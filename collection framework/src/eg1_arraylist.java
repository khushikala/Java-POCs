import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

public class eg1_arraylist {
    public static void main(String[] args)
    {
        ArrayList<Integer> l1 = new ArrayList<>();
//        ArrayList<Integer> l2 = new ArrayList<>(5);
        l1.add(6);
        l1.add(5);
        l1.add(7);
        l1.add(4);
//        l1.addFirst(4);
//        l1.addFirst(7);
//        l2.add(10);
//        l2.add(20);
//        l2.add(30);
//        l2.add(40);
//        l2.add(50);
//        l2.add(60);
//        l2.add(70);
//
//        l1.addAll(l2);

//        System.out.println(l1.contains(222));
//        System.out.println(l1.indexOf(10));
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
//
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }

//        for (Integer integer : l1) {
//            System.out.println(integer);
//        }

        ListIterator<Integer> listIterator = l1.listIterator(l1.size());

        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }
    }
}
