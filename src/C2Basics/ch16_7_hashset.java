package C2Basics;

import java.util.*;
public class ch16_7_hashset {
    public static void main(String[] args) {
        HashSet<Integer> hs1 = new HashSet<>();// new empty set created (with initial capacity of 16, load factor of 0.75)

        // HashSet with custom initial capacity and load factor by 'changing the constructor'
        HashSet<String> hs2 = new HashSet<>(50, 0.50f);

        // adding elements in the HashSet using hashing technique
        hs1.add(16);
        hs1.add(69);
        //hs1.add(69); NO ERROR BUT we cannot add duplicate elements
        hs1.add(3);
        System.out.println(hs1); // will be printed in hashed order

    }
}
// HashSet methods:

// add(E e)	                  add the specified element if it is not present, if it is present then return false.
// clear()	                  remove all the elements from the set.
// contains(Object o)	      return true if an element is present in a set.
// remove(Object o)           remove the element if it is present in set.
// iterator()	              return an iterator over the element in the set.
// isEmpty()	              check whether the set is empty or not. Returns true for empty and false for a non-empty condition for set.
// size()	                  return the size of the set.
// clone()                    create a shallow copy of the set.
