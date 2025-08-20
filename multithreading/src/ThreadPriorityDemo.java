class MyThread extends Thread {
    public void run() {
        System.out.println("Child thread priority: " + this.getPriority());
    }
}

public class ThreadPriorityDemo {
    public static void main(String[] args) {
        System.out.println("Main thread priority: " + Thread.currentThread().getPriority());

        MyThread t = new MyThread(); // child thread
        t.start();
    }
}
