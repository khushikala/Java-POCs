public class ReturnInCatchFinallyException {
    public static void main(String[] args) {
        System.out.println(test());
    }

    static int test() {
        try {
            int a = 10 / 0; // ArithmeticException
            return 1;
        } catch (ArithmeticException e) {
            System.out.println("Catch block executed");
            return 2; // planned return value
        } finally {
            System.out.println("Finally executed");
            int x = 5 / 0; // Exception in finally
        }
    }
}
