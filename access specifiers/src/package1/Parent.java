package package1;

public class Parent {

    public String publicVar = "Public Variable";
    protected String protectedVar = "Protected Variable";
    String defaultVar = "Default Variable";   // default (no modifier)
    private String privateVar = "Private Variable";

    public void publicMethod() {
        System.out.println("Public Method");
    }

    protected void protectedMethod() {
        System.out.println("Protected Method");
    }

    void defaultMethod() { // default
        System.out.println("Default Method");
    }

    private void privateMethod() {
        System.out.println("Private Method");
    }

    public void testInsideClass() {
        // ✅ Accessible inside the same class
        System.out.println(publicVar);
        System.out.println(protectedVar);
        System.out.println(defaultVar);
        System.out.println(privateVar);

        publicMethod();
        protectedMethod();
        defaultMethod();
        privateMethod();
    }
}
