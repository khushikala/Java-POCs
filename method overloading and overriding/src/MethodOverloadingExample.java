
class A {
    int add(int a, int b) {
        return a + b;
    }
    float add(float a, float b) {
        return a + b;
    }
}

class B extends A {
    double add(double a, double b) {
        return a + b;
    }
}

public class MethodOverloadingExample {
    public static void main(String[] args) {
        A objA = new A();
        B objB = new B();

        // Calling overloaded add methods
        float floatSum = objA.add(5.5f, 10.5f);
        int intSum = objB.add(5, 10);
        double doubleSum = objB.add(5.5, 10.5);

        System.out.println("Sum of floats: " + floatSum); // Output: Sum of floats: 16.0
        System.out.println("Sum of integers: " + intSum); // Output: Sum of integers: 15
        System.out.println("Sum of doubles: " + doubleSum); // Output: Sum of doubles: 16.0
    }
}
