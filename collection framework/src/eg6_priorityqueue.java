import java.util.PriorityQueue;
public class eg6_priorityqueue {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 1. add()
        pq.add(30);
        pq.add(10);
        pq.add(20);
        System.out.println(pq);

        // 2. peek() (head of queue)
        System.out.println("Peek: " + pq.peek());
        System.out.println("After peek: " + pq);

        // 3. poll() (remove head)
        System.out.println("Poll: " + pq.poll());
        System.out.println("After poll: " + pq);

        // 4. size()
        System.out.println("Queue size: " + pq.size());

        // 5. isEmpty()
        System.out.println("Is queue empty? " + pq.isEmpty());

        // Print remaining elements
        System.out.println("Queue: " + pq);
    }
}

