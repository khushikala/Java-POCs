public class StrongReferenceExample {
    public static void main(String[] args) {
        String strongRef = new String("I am Strong");
        System.out.println("Before GC: " + strongRef);

        System.gc(); // Request GC
        System.out.println("After GC: " + strongRef); // Still exists
    }
}
