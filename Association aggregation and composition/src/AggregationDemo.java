import java.util.List;

class StudentNew {
    private String name;

    StudentNew(String name) {
        this.name = name;
    }
    public String getName() { return name; }
}

class Department {
    private String deptName;
    private List<StudentNew> students; // Aggregation

    Department(String deptName, List<StudentNew> students) {
        this.deptName = deptName;
        this.students = students;
    }

    public void showStudents() {
        System.out.println("Department: " + deptName);
        for (StudentNew s : students) {
            System.out.println(" - " + s.getName());
        }
    }
}

public class AggregationDemo {
    public static void main(String[] args) {
        StudentNew s1 = new StudentNew("Khushi");
        StudentNew s2 = new StudentNew("Amit");

        Department dept = new Department("Computer Science", List.of(s1, s2));
        dept.showStudents();
    }
}
