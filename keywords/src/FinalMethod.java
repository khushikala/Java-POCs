class Base {
     final void show() {
        System.out.println("Final method in Base");
    }
}

class Derived extends Base {
//    void show() {
//        // This will cause a compile-time error because show() is final in Base
//         System.out.println("Trying to override final method in Derived");
//    }
}

public class FinalMethod {
    public static void main(String[] args) {
        System.out.println("--- Demonstrating final method ---");
        Base b = new Base();
        b.show(); // Output: Final method in Base

        System.out.println("--- Attempting to override final method in Derived class ---");
        // Uncommenting the show() method in Derived will cause a compile-time error
//         Derived d = new Derived();
//         d.show(); // This will not compile if show() is overridden
    }
}
