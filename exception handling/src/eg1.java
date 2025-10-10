public class eg1 {
    public static void main(String[] args) {
        try {
            int result = 10 / 0;
            System.out.println("First exception not thrown.");
            int arr[] = new int[5];
            int x = arr[10];
            System.out.println("Accessed array element: " + x);
        } catch (ArithmeticException e) {
            System.out.println("Caught in outer catch block: " + e.getMessage());
        } catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Caught in inner catch block: " + e.getMessage());
        }
        finally
        {
            System.out.println("finally block executed.");
        }
    }
}
