public class ThreadPriorityDemo2 {
    public static void main(String[] args) {
        Thread.currentThread().setPriority(7); // change main thread priority
        System.out.println("Main thread priority: " + Thread.currentThread().getPriority());

        MyThread t = new MyThread();
        t.start(); // child thread inherits priority
    }
}
