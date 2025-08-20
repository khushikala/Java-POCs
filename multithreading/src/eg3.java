class MyThr extends Thread{
    public MyThr(String name) {
        super(name);
    }
    @Override
    public void run()
    {
        // int i = 34;
        System.out.println("Thank you");
//         while (true) {
//         System.out.println("I am Thread");
//         }
    }

}

public class eg3 {
    public static void main(String[] args) {
        MyThr t1 = new MyThr("Khushi");
        MyThr t2 = new MyThr("Ram Candr");
        t1.start();
        t2.start();
        System.out.println("The id of Thread is " + t1.threadId());
        System.out.println("The name of Thread is " + t1.getName());
        System.out.println("The id of Thread is " + t2.threadId());
        System.out.println("The name of Thread is " + t2.getName());
    }
}
