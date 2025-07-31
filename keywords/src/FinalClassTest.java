final class FinalClassDemo {
    // A final class cannot be extended
    void display() {
        System.out.println("This is a final class");
    }
}
//class SubClass extends FinalClassDemo {
//     void display() {
//         System.out.println("Trying to override final class in SubClass");
//     }
//}

public class FinalClassTest {
    public static void main(String[] args) {
        System.out.println("--- Demonstrating final class ---");
        FinalClassDemo obj = new FinalClassDemo();
        obj.display(); // Output: This is a final class
    }
}
