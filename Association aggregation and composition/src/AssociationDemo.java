class Student {
    private String name;

    Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Teacher {
    private String name;

    Teacher(String name) {
        this.name = name;
    }

    // Association: Teacher "knows" Student
    public void teach(Student student) {
        System.out.println(name + " is teaching " + student.getName());
    }
}

public class AssociationDemo {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("Mr. Smith");
        Student student = new Student("Khushi");

        teacher.teach(student);  // Mr. Smith is teaching Khushi
    }
}
