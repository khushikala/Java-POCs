interface Greetings {
    void sayHello();
}

public class Test {
    public static void main(String [] args) {
        Greetings g = new Greetings() {
            public void sayHello() {
                System.out.println("Hello from anonymous inner class!");
            }
        };
        g.sayHello();
    }
}