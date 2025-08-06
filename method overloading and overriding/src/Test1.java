class ATest {
    private void show() {
        System.out.println("A");
    }
}

class BTest extends ATest {
    public void show() {
        System.out.println("B");
    }
}
public class Test1 {
    public static void main(String[] args) {
        ATest a = new BTest();
        // a.show(); // This will cause a compile-time error because show() in ATest is private
        // To call the method, we need to change the visibility of show() in ATest to protected or public
        System.out.println("Cannot call private method from superclass");
    }
}