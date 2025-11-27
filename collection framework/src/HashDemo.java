import java.util.*;

class Key {
    String k;

    Key(String k) {
        this.k = k;
    }

    @Override
    public int hashCode() {
        return k.length();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Key && this.k.equals(((Key) obj).k);
    }
}

public class HashDemo {
    public static void main(String[] args) {
        Map<Key, Integer> map = new HashMap<>();
        map.put(new Key("Aa"), 1);
        map.put(new Key("BB"), 2);
        map.put(new Key("CC"), 3);

        System.out.println(map.get(new Key("Aa"))); // 1
        System.out.println(map.get(new Key("BB"))); // 2
    }
}
