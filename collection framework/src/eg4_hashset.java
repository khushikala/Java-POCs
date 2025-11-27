import java.util.HashSet;

public class eg4_hashset {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();

        // 1. add()
        set.add("Apple");
        set.add("Banana");
        set.add("Orange");
        set.add("Banana");

        // 2. contains()
        System.out.println("Contains Banana? " + set.contains("Banana"));

        // 3. remove()
//        set.remove("Apple");

        // 4. size()
        System.out.println("Set size: " + set.size());

        // 5. isEmpty()
        System.out.println("Is set empty? " + set.isEmpty());

        // Print elements
        System.out.println("Elements: " + set);
    }
}
