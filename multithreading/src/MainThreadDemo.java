public class MainThreadDemo {
    public static void main(String[] args) {
        Thread t = Thread.currentThread();
        System.out.println("Set name for main thread");
        t.setName("MainThread");
        System.out.println("Current thread: " + t.getName());

        Thread t1 = new Thread(() -> {
            System.out.println("Thread 1 is running");
            System.out.println("Thread 1 name: " + Thread.currentThread().getName());
        });
        t1.start();
    }
}