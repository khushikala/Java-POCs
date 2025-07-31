//Super and this keyword

// Parent Class
class BaseClass {
    String name = "Base";

    // Method to demonstrate super.method()
    void display() {
        System.out.println("Inside BaseClass display()");
    }

    // Constructor
    BaseClass() {
        System.out.println("BaseClass Constructor");
    }
}

// Child Class
class DerivedClass extends BaseClass {
    String name = "Derived";

    // Using super and this keywords
    void showNames() {
        System.out.println("Child name using this: " + this.name);   // Derived
        System.out.println("Parent name using super: " + super.name); // Base
    }

    // Method overriding
    @Override
    void display() {
        System.out.println("Inside DerivedClass display()");
        super.display(); // call parent class method
    }

    // Constructor calling parent using super
    DerivedClass() {
        super(); // optional, added for clarity
        System.out.println("DerivedClass Constructor");
    }
}

public class eg1 {
    public static void main(String[] args) {
        System.out.println("--- Demonstrating this and super ---");
        DerivedClass obj = new DerivedClass(); // Create an instance of DerivedClass, Calls BaseClass constructor first then DerivedClass constructor
        obj.showNames();
        obj.display();
    }
}