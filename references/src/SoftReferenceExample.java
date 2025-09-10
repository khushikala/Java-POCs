import java.lang.ref.SoftReference;

public class SoftReferenceExample {
    public static void main(String[] args) {
        SoftReference<String> softRef = new SoftReference<>(new String("I am Soft"));

        System.out.println("Before GC: " + softRef.get());

        System.gc(); // Suggest GC
        System.out.println("After GC (maybe still exists): " + softRef.get());
    }
}
