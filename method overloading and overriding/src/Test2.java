class SuperClass {
    static void display() {
        System.out.println("Parent class display method");
    }
}
class SubClass extends SuperClass {
    // This method hides the static method in SuperClass
    static void display() {
        System.out.println("Child class display method");
    }
}
// Note: This is method hiding, not overriding, because static methods cannot be overridden in Java

public class Test2 {
    public static void main(String[] args) {
        SubClass sub = new SubClass();
        SuperClass sup = new SuperClass();
        sub.display(); // Outputs: Child class display method
        sup.display(); // Outputs: Parent class display method
        SuperClass.display(); // Outputs: Parent class display method
        SubClass.display(); // Outputs: Child class display method
        // Note: Static methods are not polymorphic, so the method called depends on the reference
    }
}
