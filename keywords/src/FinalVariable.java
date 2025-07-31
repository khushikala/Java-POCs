public class FinalVariable {
    final int a = 10;

    void show() {
//        a = 20; // This will cause a compile-time error because 'a' is final
        System.out.println("Value of a: " + a);
    }

    public static void main(String[] args) {
        FinalVariable obj = new FinalVariable();
        obj.show(); // Attempting to change final variable will cause an error
    }
}
