public class ExampleWithLambdaExp {
    public static void main(String[] args) {
        Runnable r = () -> System.out.println("Hello, this is a lambda expression!");
        r.run();
    }
}
