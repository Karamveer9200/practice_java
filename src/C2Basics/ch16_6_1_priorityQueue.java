package C2Basics;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class ch16_6_1_priorityQueue {
    public static void main(String[] args) {
        // using Queue because PriorityQueue is extending Queue(polymorphism)
        Queue<Integer> pq1 = new PriorityQueue<>();
        // also correct .: PriorityQueue is a subclass of Queue
        //PriorityQueue<Integer> pq2 = new PriorityQueue<>();

        pq1.offer(10);
        pq1.offer(5);
        pq1.offer(1);
        pq1.offer(2);
        pq1.offer(4);

        // automatically sorted in ascending order (MIN HEAP)
        System.out.println(pq1);

        // peek() will return the first element in the queue
        System.out.println(pq1.peek());

        // poll() will remove the first element in the queue
        System.out.println(pq1.poll());
        System.out.println(pq1);

        // to reverse the sorting, we can make a comparator
        Queue<Integer> pq2 = new PriorityQueue<>(Comparator.reverseOrder());
        pq2.offer(10);
        pq2.offer(5);
        pq2.offer(1);
        pq2.offer(2);
        pq2.offer(4);
        // Now, the fist element will be the largest, others may be here and there
        // heap using its own sorting methods
        System.out.println(pq2);
    }
}
