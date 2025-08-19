public class TryFinallyOnly {
    public static void main(String[] args) {
        try {
            int[] arr = {1, 2, 3};
            System.out.println(arr[5]); // ArrayIndexOutOfBoundsException
        } finally {
            System.out.println("Finally block executed");
        }
    }
}
