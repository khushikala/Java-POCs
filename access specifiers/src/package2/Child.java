package package2;

import package1.Parent;

public class Child extends Parent {

    public void testAccessInSubclass() {
        // ✅ Accessible in subclass (different package)
        System.out.println(publicVar);
        System.out.println(protectedVar);  // ✅ allowed (because of inheritance)

        // ❌ Not accessible (different package, not default or private)
        // System.out.println(defaultVar);
        // System.out.println(privateVar);

        publicMethod();
        protectedMethod();  // ✅ allowed

        // ❌ Not accessible
        // defaultMethod();
        // privateMethod();
    }
}
