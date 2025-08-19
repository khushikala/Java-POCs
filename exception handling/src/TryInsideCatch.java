public class TryInsideCatch {
    public static void main(String[] args) {
        try {
            int num = Integer.parseInt("ABC"); // NumberFormatException
        } catch (NumberFormatException e) {
            System.out.println("Caught: " + e);
            try {
                int x = 10 / 0; // Another exception
            } catch (ArithmeticException ex) {
                System.out.println("Exception inside catch: " + ex);
            }
        }
    }
}
