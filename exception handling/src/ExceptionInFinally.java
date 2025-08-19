public class ExceptionInFinally {
    public static void main(String[] args) {
        try {
            int a = 10 / 0; // ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Caught: " + e);
        } finally {
            System.out.println("In finally");
            int x = 100 / 0; // Exception in finally
        }
    }
}
