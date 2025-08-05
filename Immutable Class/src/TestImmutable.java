import java.util.Date;

final class StudentProfile {
    private final int id;
    private final String name;
    private final Date dateOfBirth; // mutable field

    // Constructor
    public StudentProfile(int id, String name, Date dateOfBirth) {
        this.id = id;
        this.name = name;
        // Defensive copy of mutable field
        this.dateOfBirth = new Date(dateOfBirth.getTime());
    }

    // Getters (no setters)
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getDateOfBirth() {
        return new Date(dateOfBirth.getTime()); // Defensive copy
    }
}


public class TestImmutable {
    public static void main(String[] args) {
        Date dob = new Date();
        StudentProfile student = new StudentProfile(101, "Khushi Kala", dob);

        System.out.println("Original DOB: " + student.getDateOfBirth());

        // Try to modify the original Date object
        dob.setTime(dob.getTime() + 1000000000L);
        System.out.println("Modified external DOB: " + dob);
        System.out.println("DOB from StudentProfile: " + student.getDateOfBirth());

        // Try to modify via getter
        Date extractedDOB = student.getDateOfBirth();
        extractedDOB.setTime(extractedDOB.getTime() + 2000000000L);
        System.out.println("Modified extracted DOB: " + extractedDOB);
        System.out.println("DOB from StudentProfile after external attempt: " + student.getDateOfBirth());
    }
}