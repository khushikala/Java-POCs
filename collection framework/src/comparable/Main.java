package comparable;

import java.util.*;

class Student implements Comparable<Student> {
    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Define natural sorting order by id
    @Override
    public int compareTo(Student other) {
        return this.id - other.id;
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

        // Sort using Comparable
        Collections.sort(list);

        System.out.println(list);
    }
}
