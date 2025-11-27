package hashset;

class Student {
    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

public class HashSet {
    public static void main(String[] args) {
        java.util.HashSet<Student> set = new java.util.HashSet<>();

        Student s1 = new Student(1, "Alice");
        Student s2 = new Student(1, "Alice");

        set.add(s1);
        set.add(s2);

        System.out.println("HashSet size: " + set.size());
        for (Student s : set) {
            System.out.println(s.id + " - " + s.name);
        }
    }
}
