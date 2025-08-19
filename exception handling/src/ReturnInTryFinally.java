public class ReturnInTryFinally {
    public static void main(String[] args) {
        System.out.println(test());
    }

    public static int test() {
        try {
            return 10;
        } finally {
            System.out.println("Finally executed even after return");
        }
    }
}
