public class CatchFinallyOverride {
    public static void main(String[] args) {
        try {
            int a = 10 / 0; // ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("In catch, exception occurred");
            int x = 5 / 0; // New exception in catch
        } finally {
            System.out.println("In finally, another exception occurs");
            int y = 100 / 0; // Exception in finally
        }
    }
}
