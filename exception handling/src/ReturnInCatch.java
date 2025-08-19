public class ReturnInCatch {
    public static void main(String[] args) {
        System.out.println(test());
    }

    static int test() {
        try {
            int a = 10 / 0; // throws ArithmeticException
            return 1;       // won't execute
        } catch (ArithmeticException e) {
            System.out.println("Catch block executed");
            return 2; // <-- return here
        } finally {
            System.out.println("Finally executed");
        }
    }
}
