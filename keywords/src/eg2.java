// Class demonstrating final keyword
class FinalDemo {
    final int MAX_USERS = 100; // final variable

    final void showLimit() {   // final method
        System.out.println("MAX_USERS: " + MAX_USERS);
    }
}

// This will give compile-time error if you try to override final method
class TryOverrideFinal extends FinalDemo {
    // Uncommenting below will cause error
//     void showLimit() {
//         System.out.println("Trying to override final method");
//     }
}

// Final class cannot be extended
final class FinalClass {
    void display() {
        System.out.println("Inside FinalClass");
    }
}

// This will cause error: cannot inherit from final class

// class SubFinal extends FinalClass {}

public class eg2 {
    public static void main(String[] args) {
        System.out.println("\n--- Demonstrating final variable and method ---");
        FinalDemo f = new FinalDemo();
        f.showLimit();

        System.out.println("\n--- Demonstrating final class ---");
        FinalClass fc = new FinalClass();
        fc.display();
    }
}