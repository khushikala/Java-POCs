import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class list1 {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = Arrays.asList(10, 20, 30, 40, 50);
        list1.add(10);
        list1.add(20);
        list1.add(30);
        list1.add(10);
        list1.add(10);
        list1.add(20);
        list1.add(10);
        list1.add(10);
        System.out.println(list1.get(2));
        System.out.println(list1);

//        Set<Integer> set1 = new HashSet<>();
//        set1.add(10);
//        set1.add(10);
//        set1.add(20);
//        set1.add(30);
//        System.out.println(set1);

        int target = 10;
        int count = 0;
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i) == target) {
                count++;
            }
        }
        System.out.println("Count of " + target + " in list1: " + count);
    }
}
