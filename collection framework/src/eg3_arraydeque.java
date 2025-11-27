import java.util.ArrayDeque;
import java.util.Iterator;

public class eg3_arraydeque {
    public static void main(String[] args) {
        ArrayDeque<Integer> a1 = new ArrayDeque<>();
        a1.add(10);
        a1.add(20);
        a1.add(30);
        a1.add(40);
        a1.addFirst(2827);
//        System.out.println(a1.getFirst());
//        System.out.println(a1.getLast());

        Iterator<Integer> iterator = a1.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
