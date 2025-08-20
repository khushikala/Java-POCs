class MyThr1 extends Thread{
    public MyThr1(String name) {
        super(name);
    }
    @Override
    public void run()
    {
        // int i = 34;
         while (true) {
//             System.out.println("I am Thread");
             System.out.println("Thank you " + this.getName());
         }
    }

}

public class eg5_thread_priority {
    public static void main(String[] args)
    {
//        READY QUEUE: T1 T2 T3 T4 T5
//        There are 3 priorities: Min- 1, norm-5, max-10
//        Default priority is norm priority
        MyThr1 t1 = new MyThr1("Khushi1");
        MyThr1 t2 = new MyThr1("Khushi2");
        MyThr1 t3 = new MyThr1("Khushi3");
        MyThr1 t4 = new MyThr1("Khushi4");
        MyThr1 t5 = new MyThr1("Khushi5 (most important)");
        t5.setPriority(Thread.MAX_PRIORITY);
        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);
        t3.setPriority(Thread.MIN_PRIORITY);
        t4.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t2.start();;
        t3.start();
        t4.start();
        t5.start();
    }
}
