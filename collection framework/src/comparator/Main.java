package comparator;

import java.util.*;

class Student {
    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return id + " - " + name;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student(3, "Ravi"));
        list.add(new Student(1, "Amit"));
        list.add(new Student(2, "Neha"));

        // Sort by name using Comparator
        Comparator<Student> nameComparator = (s1, s2) -> s1.name.compareTo(s2.name);
        Collections.sort(list, nameComparator);

        System.out.println(list);
    }
}
