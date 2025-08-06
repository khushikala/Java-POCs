class Demo {
    void show(int a) {
        System.out.println("int");
    }

    void show(long a) {
        System.out.println("long");
    }
}

public class OverloadingTest {
    public static void main(String[] args) {
        Demo d = new Demo();
        d.show(10); // int → matches exact method
    }
}
