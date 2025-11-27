import java.util.HashMap;

public class eg5_hashmap {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();

        // 1. put()
        map.put(1, "Java");
        map.put(2, "Python");
        map.put(3, "C++");
        map.put(1, "Java");

        // 2. get()
        System.out.println("Value at key 2: " + map.get(2));

        // 3. containsKey()
        System.out.println("Contains key 1? " + map.containsKey(1));

        // 4. remove()
        map.remove(3);

        // 5. keySet() or entrySet()
        System.out.println("Keys: " + map.keySet());
        System.out.println("Map: " + map);
    }
}
