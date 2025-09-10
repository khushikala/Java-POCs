import package1.Parent;
import package2.Child;

public class MainTest {
    public static void main(String[] args) {
        Parent p = new Parent();
        Child c = new Child();

        System.out.println("---- Access through Parent ----");
        System.out.println(p.publicVar);     // ✅ allowed
        p.publicMethod();                   // ✅ allowed

        // ❌ Not accessible (outside package without inheritance)
        // System.out.println(p.protectedVar);
        // System.out.println(p.defaultVar);
        // System.out.println(p.privateVar);

        // ✅ Run inside-class test
        p.testInsideClass();

        System.out.println("---- Access through Child (subclass) ----");
        c.testAccessInSubclass();
    }
}
