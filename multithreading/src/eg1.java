class MyThreadClass1 extends Thread
{
    @Override
    public void run()
    {
        int i = 0;
        while(i<400)
        {
            System.out.println("Cooking Thread 1 is running");
            System.out.println("This is good");
            i++;
        }
    }
}
class MyThreadClass2 extends Thread {
    @Override
    public void run()
    {
        int i = 0;
        while(i<200)
        {
            System.out.println("Chatting Thread 2 is running");
            System.out.println("I am sad");
            i++;
        }
    }
}

public class eg1 {
    public static void main(String[] args) {
        MyThreadClass1 t1 = new MyThreadClass1();
        t1.start();
        MyThreadClass2 t2 = new MyThreadClass2();
        t2.start();
    }
}