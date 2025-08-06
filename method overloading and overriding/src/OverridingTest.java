import java.io.FileNotFoundException;
import java.io.IOException;

class Parent {
    Number getNumber() throws IOException {
        return 100;
    }
}

class Child extends Parent {
    @Override
    Integer getNumber() throws FileNotFoundException {
        return 200;
    }
}

public class OverridingTest {
    public static void main(String[] args) throws IOException {
        Parent parent = new Parent();
        System.out.println("Parent getNumber: " + parent.getNumber()); // Outputs: 100

        Child child = new Child();
        System.out.println("Child getNumber: " + child.getNumber()); // Outputs: 200

        Parent parentRef = new Child();
        System.out.println("Parent reference to Child getNumber: " + parentRef.getNumber()); // Outputs: 200
    }
}
