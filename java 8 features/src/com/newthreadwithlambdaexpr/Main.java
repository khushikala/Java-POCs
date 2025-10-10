package com.newthreadwithlambdaexpr;

public class Main {
    public static void main(String[] args) {
        //Without Lambda Expression
    /*    MyClassNew myClassNew = new MyClassNew();
        Thread childThread = new Thread(myClassNew);
        childThread.start();*/

        //With Lambda Expression
        Runnable runnable = () -> {
            for(int i=1; i<=10; i++){
                System.out.println("Hello from Lambda " + i);
            }
        };
        Thread childThread1 = new Thread(runnable);
        childThread1.start();
        //Or
        Thread childThread2 = new Thread(() -> {
            for(int i=1; i<=10; i++){
                System.out.println("Hello from Lambda " + i);
            }
        });
        childThread2.start();
    }
}
