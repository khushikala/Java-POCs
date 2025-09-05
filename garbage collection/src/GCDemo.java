class Person {
    String name;
    Person(String name) {
        this.name = name;
    }
}

public class GCDemo {
    public static void main(String[] args) {
        Person p1 = new Person("Alice"); // Step 1
        Person p2 = new Person("Bob");   // Step 2

        p1 = null;  // Step 3 → Alice lost reference
        p2 = new Person("Charlie"); // Step 4 → Bob lost reference
        System.gc(); // Step 5 → Request GC
    }
}
