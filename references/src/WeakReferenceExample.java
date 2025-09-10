import java.lang.ref.WeakReference;

public class WeakReferenceExample {
    public static void main(String[] args) {
        WeakReference<String> weakRef = new WeakReference<>(new String("I am Weak"));

        System.out.println("Before GC: " + weakRef.get());

        System.gc(); // Suggest GC
        System.out.println("After GC (likely null): " + weakRef.get());
    }
}
