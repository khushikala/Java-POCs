public class SafeFinally {
    public static void main(String[] args) {
        try {
            int a = 10 / 0; // ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Caught: " + e);
        } finally {
            try {
                int y = 100 / 0; // risky code
            } catch (Exception ex) {
                System.out.println("Handled exception inside finally: " + ex);
            }
        }
    }
}
