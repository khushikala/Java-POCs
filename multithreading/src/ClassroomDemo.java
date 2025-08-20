public class ClassroomDemo {
    static class Classroom {
        final Object doorKey = new Object(); // lock
        boolean papersArrived = false;       // flag
    }

    public static void main(String[] args) throws InterruptedException {
        Classroom room = new Classroom();

        // Student task: wait until exam papers arrive
        Runnable student = () -> {
            String name = Thread.currentThread().getName();
            synchronized (room.doorKey) {
                System.out.println(name + ": No papers yet. I’ll wait.");
                while (!room.papersArrived) {
                    try {
                        room.doorKey.wait(); // student sleeps, gives up the key
                    } catch (InterruptedException e) {
                        return;
                    }
                }
                System.out.println(name + ": Woke up! Papers are here!");
            }
        };

        // Phase 1: Teacher wakes ONE student
        Thread s1 = new Thread(student, "Student-1");
        Thread s2 = new Thread(student, "Student-2");
        s1.start();
        s2.start();
        Thread.sleep(500); // let them start and wait

        synchronized (room.doorKey) {
            room.papersArrived = true;
            System.out.println("Teacher: Papers arrived! Waking ONE student.");
            room.doorKey.notify(); // wakes only one
        }

        Thread.sleep(500);
        synchronized (room.doorKey) {
            System.out.println("Teacher: Waking remaining students!");
            room.doorKey.notifyAll(); // wakes others
        }
        s1.join();
        s2.join();

        // Phase 2: Teacher wakes ALL at once
        room.papersArrived = false;
        Thread s3 = new Thread(student, "Student-3");
        Thread s4 = new Thread(student, "Student-4");
        s3.start();
        s4.start();
        Thread.sleep(500);

        synchronized (room.doorKey) {
            room.papersArrived = true;
            System.out.println("Teacher: Papers arrived! Waking ALL students.");
            room.doorKey.notifyAll();
        }
        s3.join();
        s4.join();
    }
}
