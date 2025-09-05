class A {
    void m1() {
        System.out.println("m1 of A");
    }
}
public class Test2 {
    public static void main(String[] args) {
        A a = new A() {
            void m1() {
                System.out.println("m1 of anonymous inner class");
            }
        };
        a.m1();
    }
}
