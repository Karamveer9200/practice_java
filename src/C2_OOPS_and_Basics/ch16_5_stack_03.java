package C2_OOPS_and_Basics;

import java.util.Stack;
// stack is a last in first out data structure
// Unlike ArrayList which is an interface, Stack is a class that extents vector class
public class ch16_5_stack_03 {
    public static void main(String[] args) {
        Stack<Integer> s1= new Stack<>();
        s1.add(1);
        s1.add(2);
        s1.add(3);
        // elements can be added using both push() (recommended) and add()
        s1.push(4);
        s1.push(5);
        s1.push(6);
        System.out.println(s1);
        System.out.println(s1.get(0));
        System.out.println(s1.get(5));

        // to see the top-most element of stack we use peek()
        System.out.println(s1.peek());

        // to remove the top-most element of stack we use pop()
        s1.pop();
        System.out.println(s1);
        System.out.println(s1.peek());
    }

}
