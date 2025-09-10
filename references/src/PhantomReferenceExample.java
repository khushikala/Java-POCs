import java.lang.ref.*;

public class PhantomReferenceExample {
    public static void main(String[] args) throws InterruptedException {
        ReferenceQueue<String> queue = new ReferenceQueue<>();
        PhantomReference<String> phantomRef = new PhantomReference<>(new String("I am Phantom"), queue);

        System.out.println("phantomRef.get(): " + phantomRef.get()); // Always null

        System.gc();
        Thread.sleep(100); // Wait a bit for GC

        Reference<?> refFromQueue = queue.poll();
        if (refFromQueue != null) {
            System.out.println("Object is collected and enqueued for cleanup.");
        } else {
            System.out.println("Object not yet collected.");
        }
    }
}
