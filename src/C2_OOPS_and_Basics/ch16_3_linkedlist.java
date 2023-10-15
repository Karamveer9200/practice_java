package C2_OOPS_and_Basics;

import java.util.*;

public class ch16_3_linkedlist {
    public static void main(String[] args) {

        // Creating an object of LinkedList class and using some of its method
        // Methods of ArrayList and LInkedList are mostly the same.
        // Just copied the code from arraylist and replaced 'ArrayList' with 'LinkedList'.

        // created an LinkedList that only accepts Integers
        LinkedList<Integer> L1 = new LinkedList<>();
        // also correct .: LinkedList is extending List
        //List<Integer> L2 = new LinkedList<>();

        // unlike arraylist, LinkedList does not have an initial size
        //LinkedList<Integer> L3 = new LinkedList<>(10);

        // array list could be of 'any' particular data-type
        // ArrayList<String> S1 = new ArrayList<>();

        // adding elements to the arraylist using add() method
        L1.add (4);
        L1.add (7);
        L1.add (6);
        L1.add (7);
        L1.add (1);
        System.out.println(L1);
        // for(int i=0; i<L1.size(); i++){
        // System.out.println(L1.get(i));
        // }


        //adding elements of another arraylist to the arraylist L1 using addAll() method
        LinkedList<Integer> L2 = new LinkedList<>();
        L2.add(10);
        L2.add(11);
        L2.add(12);
        L2.add(13);

        L1.addAll(L2);  // adding elements of L2 to L1 at the end of L1
        System.out.println(L1);
        //L1.addAll(0, L2); // adding elements of L2 to L1 at the beginning of L1(index 0)

        // adding an element at index 0, But 4 will not be deleted, it will move to index 1
        // method overloading
        L1.add(0, 5);
        System.out.println(L1);
        L1.add(0,6); // adding element at index 0
        System.out.println(L1);

        // setting(replacing) an element at any index using set() method
        L1.set(0, 69); // replacing an element at index 0 (i.e. 6 with 69, six will be deleted)
        System.out.println(L1);

        // removing elements from the arraylist using remove() method and removeAll() method
        L1.removeAll(L2); // removing all elements of L2 from L1
        System.out.println(L1);


        L1.remove(0); // removing an element at index 0, which is 69
        System.out.println(L1);
        L1.remove(4); // removing an element at index 3, which is now 7
        System.out.println(L1);

        // Using some other methods of arraylist class
        System.out.println(L1.contains(69));// returns true if the list contains the specified element.
        System.out.println(L1.indexOf(7));// returns the index of the 'first' occurrence of the specified element.
        System.out.println(L1.subList(1,4));// returns a list containing the elements between index 1 and 4 (4 excluded)

        // Methods exclusive to LinkedList
        L1.addFirst(666); // adding an element at the beginning of the list
        System.out.println(L1);
        L1.addLast(999); // adding an element at the end of the list
        System.out.println(L1);

        // Other common methods:
        // L1.subList(1,3)  --> This   method is used to get elements from index 1 to 3(excluding 3)
        // L1.retainAll(L2)  --> This method removes all elements from L1 that are not present in L2
        // L1.clear()        --> This method removes all elements from L1
        // L1.indexOf(6)     --> This method returns the index of the first occurrence of the specified element
        // L1.lastIndexOf(6) --> This method returns the index of the last occurrence of the specified element
        // L1.set()          --> This method replaces the element at the specified index
        // L1.isEmpty()      --> This method returns true if the list contains no elements
        // L1.size()         --> This method returns the number of elements in the list
        // L1.contains(6)    --> This method returns true if the list contains the specified element
        // L1.containsAll(L2) --> This method returns true if the list contains all of the elements of the specified list
        // L1.equals(L2)     --> This method returns true if the two lists contain the same elements in the same order
        // L1.toArray()      --> This method returns an array containing all of the elements in the list
        // L1.toArray(L2)    --> This method returns an array containing all of the elements in the list

    }
}
