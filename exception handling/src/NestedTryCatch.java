public class NestedTryCatch {
    public static void main(String[] args) {
        try {
            System.out.println("Outer try block");
            try {
                int x = 5 / 0; // Inner exception
            } catch (ArithmeticException e) {
                System.out.println("Inner catch: " + e);
            }
            int[] arr = new int[3];
            System.out.println(arr[5]); // Outer exception
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Outer catch: " + e);
        } finally {
            System.out.println("Finally always executes");
        }
    }
}
