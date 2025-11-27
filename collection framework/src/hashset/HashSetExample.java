package hashset;

import java.util.HashSet;
import java.util.Objects;

class StudentTest {
    int id;
    String name;

    StudentTest(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentTest)) return false;
        StudentTest student = (StudentTest) o;
        return id == student.id && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}

public class HashSetExample {
    public static void main(String[] args) {
        HashSet<StudentTest> set = new HashSet<>();

        StudentTest s1 = new StudentTest(1, "Alice");
        StudentTest s2 = new StudentTest(1, "Alice");

        set.add(s1);
        set.add(s2);

        System.out.println("HashSet size: " + set.size());
        for (StudentTest s : set) {
            System.out.println(s.id + " - " + s.name);
        }
    }
}
