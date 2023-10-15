package C2_OOPS_and_Basics;
import java.util.*;

// queue works on 'first in first out' principle
// linked list is a queue
public class ch16_6_0_queue_03 {
    public static void main(String[] args) {
        Queue<Integer> q1 = new LinkedList<>();
        // add() : adds and element at the end of the queue but throws an exception
        // if operation is unsuccessful
        q1.add(1);
        q1.add(2);
        // offer() : recommended method for adding elements to the queue
        // offer() : adds the element at the end of the queue, and doesn't throw an exception
        q1.offer(3);
        q1.offer(4);
        q1.offer(5);
        System.out.println(q1);
        // queue methods
        // peek() : returns the element at the front of the queue
        System.out.println(q1.peek());
        // poll() : removes the element at the front of the queue and also returns the element
        // if the queue is empty, it throws an exception
        System.out.println(q1.poll());
        System.out.println(q1);

        // methods to remember: offer(),peek(),poll()

    }
}
