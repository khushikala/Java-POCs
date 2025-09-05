class Printer {
    private int number = 1;
    private final int MAX = 50;

    public synchronized void printOdd() {
        while (number <= MAX) {
            if (number % 2 == 0) {  // Not my turn
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            } else {
                System.out.println(Thread.currentThread().getName() + " -> " + number);
                number++;
                notify(); // Wake up the other thread
            }
        }
    }

    public synchronized void printEven() {
        while (number <= MAX) {
            if (number % 2 != 0) { // Not my turn
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            } else {
                System.out.println(Thread.currentThread().getName() + " -> " + number);
                number++;
                notify(); // Wake up the other thread
            }
        }
    }
}

public class PrintNumbers {
    public static void main(String[] args) {
        Printer printer = new Printer();

        Thread t1 = new Thread(printer::printOdd, "Odd-Thread");
        Thread t2 = new Thread(printer::printEven, "Even-Thread");

        t1.start();
        t2.start();
    }
}
