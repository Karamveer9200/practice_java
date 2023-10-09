package OOPs_java.basics;
import java.util.*;

// queue works on 'first in first out' principle
// linked list is a queue
public class ch16_6_queue_03 {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        System.out.println(q);

    }
}
