class SharedResource {
    private boolean available = false;

    synchronized void produce() throws InterruptedException {
        while (available) {
            wait(); // wait until consumed
        }
        System.out.println("Produced item");
        available = true;
        notify(); // notify consumer
    }

    synchronized void consume() throws InterruptedException {
        while (!available) {
            wait(); // wait until produced
        }
        System.out.println("Consumed item");
        available = false;
        notify(); // notify producer
    }
}

public class ProducerConsumerDemo {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        // Producer thread
        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    resource.produce();
                    Thread.sleep(500); // simulate production time
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Consumer thread
        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    resource.consume();
                    Thread.sleep(500); // simulate consumption time
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        producer.start();
        consumer.start();
    }
}
