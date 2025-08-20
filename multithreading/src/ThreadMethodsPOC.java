import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ThreadMethodsPOC {

    public static void main(String[] args) throws Exception {
//        banner("STEP 1 — start(), run(), setName()/getName(), getId(), threadId(), isAlive(), currentThread()");
//        demoStartRunNameId();

//        banner("STEP 2 — setPriority()/getPriority()");
//        demoPriority();

//        banner("STEP 3 — currentThread(), setName() on main");
//        demoCurrentThreadAndRenameMain();

//        banner("STEP 4 — sleep() and yield()");
//        demoSleepAndYield();

        banner("STEP 5 — interrupt(), isInterrupted() [busy thread] and [sleeping thread]");
        demoInterruptVariants();

//        banner("STEP 6 — setDaemon()/isDaemon()");
//        demoDaemon();

//        banner("STEP 7 — wait(), notify(), notifyAll()");
//        demoWaitNotify();

        banner("DONE");
    }

    // ---------- helpers ----------
    static void banner(String title) {
        System.out.println("\n==================================================");
        System.out.println(title);
        System.out.println("==================================================");
    }

    // Java 19+ has Thread#threadId(). For older JDKs we try reflect; if absent, return null.
    static Long threadIdCompat(Thread t) {
        try {
            Method m = Thread.class.getMethod("threadId");
            Object v = m.invoke(t);
            return (Long) v;
        } catch (Throwable ignore) {
            return null; // not available on this JDK
        }
    }

    // ---------- STEP 1 ----------
    static void demoStartRunNameId() throws InterruptedException {
        Thread t = new Thread(() -> {
            Thread me = Thread.currentThread();
            System.out.println("[RUN] " + me.getName() +
                    " started | getId=" + me.getId() +
                    (threadIdCompat(me) != null ? (" | threadId=" + threadIdCompat(me)) : " | threadId=N/A") +
                    " | alive=" + me.isAlive());
        }, "Demo-StartRun");

        System.out.println("Before start(): isAlive=" + t.isAlive() + " | name=" + t.getName());
        t.start();                       // -> creates a NEW thread; JVM will invoke run()
        System.out.println("After start(): isAlive=" + t.isAlive());
        t.join();                        // wait until t finishes
        System.out.println("After join(): isAlive=" + t.isAlive());

        // NOTE: calling t.run() directly would execute on the *current* thread (no new thread).
    }

    // ---------- STEP 2 ----------
    static void demoPriority() throws InterruptedException {
        Thread low = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " priority=" +
                    Thread.currentThread().getPriority());
        }, "Priority-Low");

        Thread high = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " priority=" +
                    Thread.currentThread().getPriority());
        }, "Priority-High");

        low.setPriority(Thread.MIN_PRIORITY);  // 1
        high.setPriority(Thread.MAX_PRIORITY); // 10

        low.start();
        high.start();
        low.join();
        high.join();

        // FYI: priority is just a *hint*; modern OS schedulers often ignore it.
    }

    // ---------- STEP 3 ----------
    static void demoCurrentThreadAndRenameMain() {
        Thread main = Thread.currentThread();
        System.out.println("currentThread() -> " + main.getName());
        main.setName("Main-POC"); // rename the main thread
        System.out.println("After setName(): " + Thread.currentThread().getName());
    }

    // ---------- STEP 4 ----------
    static void demoSleepAndYield() throws InterruptedException {
        Runnable r1 = () -> {
            Thread me = Thread.currentThread();
            System.out.println(me.getName());
            for (int i = 1; i <= 5; i++) {
                System.out.println(me.getName() + " step " + i + " (about to sleep 150ms)");
                try {
                    Thread.sleep(150); // pauses current thread, does NOT release any held lock
                } catch (InterruptedException e) {
                    System.out.println(me.getName() + " interrupted during sleep");
                    return;
                }
                if (i == 3) {
                    System.out.println(me.getName() + " calls yield() (scheduler hint)");
                    Thread.yield(); // hint only; may or may not switch
                }
            }
            System.out.println(me.getName() + " finished");
        };

        Thread a = new Thread(r1, "SleepYield-A");
        System.out.println(a.getState());
        Thread b = new Thread(r1, "SleepYield-B");
        a.start();
        System.out.println(a.getState());
        System.out.println("before start b: " + b.getState());
        b.start();
        System.out.println(b.getState());
        a.join();
        b.join();
    }

    // ---------- STEP 5 ----------
    static void demoInterruptVariants() throws InterruptedException {
        // (A) Busy thread: interrupt sets the flag; thread checks isInterrupted() and stops.
        Thread busy = new Thread(() -> {
            Thread me = Thread.currentThread();
            System.out.println(me.getName() + " running (busy loop); waiting for interrupt flag...");
            while (true) {
                if (me.isInterrupted()) { // does NOT clear the flag
                    System.out.println(me.getName() + " saw isInterrupted=true -> exiting loop");
                    break;
                }
                // do some lightweight work (no sleep/wait)...
            }
            System.out.println(me.getName() + " ended");
        }, "Interrupt-BUSY");

        busy.start();
        Thread.sleep(10000); // let it spin a bit
        System.out.println("Main: interrupting busy thread");
        busy.interrupt();            // sets interrupt flag (no exception since it's not blocked)
        busy.join();

        // (B) Sleeping thread: interrupt throws InterruptedException and clears the flag.
        Thread sleeper = new Thread(() -> {
            Thread me = Thread.currentThread();
            try {
                System.out.println(me.getName() + " going to sleep for 2s...");
                Thread.sleep(20000);
                System.out.println(me.getName() + " woke up normally (no interrupt)");
            } catch (InterruptedException e) {
                System.out.println(me.getName() + " caught InterruptedException; flag now="
                        + me.isInterrupted() + " (usually false because exception clears it)");
            }
        }, "Interrupt-SLEEPER");

        sleeper.start();
        Thread.sleep(2000); // ensure it's sleeping
        System.out.println("Main: interrupting sleeping thread");
        sleeper.interrupt();         // causes InterruptedException inside sleeper
        sleeper.join();
    }

    // ---------- STEP 6 ----------
    static void demoDaemon() throws InterruptedException {
        Thread worker = new Thread(() -> {
            System.out.println("User worker started (non-daemon)");
            try {
                Thread.sleep(800);
            } catch (InterruptedException ignored) {
            }
            System.out.println("User worker finishing");
        }, "User-Worker");

        Thread daemon = new Thread(() -> {
            Thread me = Thread.currentThread();
            System.out.println(me.getName() + " isDaemon=" + me.isDaemon());
            // "background heartbeat" while user worker is alive
            while (worker.isAlive()) {
                System.out.println(me.getName() + " heartbeat...");
                try {
                    Thread.sleep(200);
                } catch (InterruptedException ignored) {
                }
            }
            System.out.println(me.getName() + " exiting because user threads finished");
        }, "BG-Daemon");

        daemon.setDaemon(true); // must be BEFORE start()
        daemon.start();
        worker.start();
        worker.join();
        // we don't join daemon; it will exit naturally after worker ends
        Thread.sleep(250); // give daemon time to print the exit line
    }

    // ---------- STEP 7 ----------
    static void demoWaitNotify() throws InterruptedException {
        class Box {
            final Object lock = new Object();
            boolean ready = false;
        }
        Box box = new Box();

        Runnable waiter = () -> {
            Thread me = Thread.currentThread();
            synchronized (box.lock) {
                System.out.println(me.getName() + " waiting; ready=" + box.ready + " (releases lock)");
                while (!box.ready) {
                    try {
                        box.lock.wait();
                    }          // releases lock; waits to be notified
                    catch (InterruptedException e) {
                        System.out.println(me.getName() + " interrupted");
                        return;
                    }
                }
                System.out.println(me.getName() + " resumed; ready=" + box.ready);
            }
        };

        // Phase 1: notify() wakes ONE waiter; the other still waits until notifyAll()
        Thread w1 = new Thread(waiter, "Waiter-1");
        Thread w2 = new Thread(waiter, "Waiter-2");
        w1.start();
        w2.start();
        Thread.sleep(250);

        synchronized (box.lock) {
            box.ready = true;
            System.out.println("Notifier: ready=true; calling notify() (wakes one)");
            box.lock.notify(); // wakes exactly one thread waiting on lock
        }

        Thread.sleep(300);
        synchronized (box.lock) {
            System.out.println("Cleanup: calling notifyAll() to release any remaining waiters");
            box.lock.notifyAll();
        }
        w1.join();
        w2.join();

        // Phase 2: fresh waiters + notifyAll() wakes ALL
//        box.ready = false;
//        List<Thread> moreWaiters = new ArrayList<>();
//        for (int i = 3; i <= 4; i++) {
//            Thread w = new Thread(waiter, "Waiter-" + i);
//            moreWaiters.add(w);
//            w.start();
//        }
//        Thread.sleep(250);
//        synchronized (box.lock) {
//            box.ready = true;
//            System.out.println("Notifier: ready=true; calling notifyAll() (wakes all)");
//            box.lock.notifyAll();
//        }
//        for (Thread w : moreWaiters) w.join();

        // TIP: If you call wait()/notify() OUTSIDE synchronized, you'll get IllegalMonitorStateException.
    }
}
