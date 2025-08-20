class ThreadRunnable11 implements Runnable {
    @Override
    public void run()
    {
        System.out.println("Hello");
        // int i = 0;
        // while(i<100)
        // {
        //     System.out.println("I am Thread 1");
        // }
    }
}


public class eg4_thread_constructor {
    public static void main(String[] args) {
        ThreadRunnable11 bullet = new ThreadRunnable11();
        Thread gun = new Thread(bullet, "Khushi");
        gun.start();
        System.out.println("id of thread is " + gun.threadId());
        System.out.println("name of thread is " + gun.getName());
    }
}
