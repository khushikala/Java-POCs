public class TryInsideFinally {
    public static void main(String[] args) {
        try {
            System.out.println("Outer try");
        } catch (Exception e) {
            System.out.println("Outer catch");
        } finally {
            System.out.println("Outer finally");
            try {
                int x = 5 / 0; // Exception in finally
            } catch (ArithmeticException e) {
                System.out.println("Handled exception inside finally: " + e);
            }
        }
    }
}
