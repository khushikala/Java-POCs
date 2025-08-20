class MyNewThr1 extends Thread{
    @Override
    public void run()
    {
        int i =0;
        while (i<50) {
//             System.out.println("I am Thread");
            System.out.println("Thank you 1");
            try {
                Thread.sleep(455);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            i++;
        }
    }

}
class MyNewThr2 extends Thread{
    @Override
    public void run()
    {
        int i = 0;
        while (i < 50) {
//             System.out.println("I am Thread");
            System.out.println("Thank you 2");
            i++;
        }
    }

}

public class eg6_thread_methods {
    public static void main(String[] args)
    {
        MyNewThr1 t1 = new MyNewThr1();
        MyNewThr2 t2 = new MyNewThr2();
        t1.start();
//        try {
//            t1.join();
//        } catch(Exception e)
//        {
//            System.out.println(e);
//        }
        t2.start();
    }
}
