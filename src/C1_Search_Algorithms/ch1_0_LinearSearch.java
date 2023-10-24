package C1_Search_Algorithms;

public class ch1_0_LinearSearch {
    public static void main(String[] args) {
        int[] numbers = {2,4,5,9,4,6,46,7,6,4,};
        int target = 9;
        System.out.println(linearSearch(numbers, target));

    }

    // search int the array: return the index if item found
    // otherwise if item not found return -1
    static int linearSearch(int[] arr, int target) {
       if (arr.length == 0) {
           return -1;
           // when returning an element use:
           //  return Integer.MAX_VALUE;
           // .: -1 could be an element in the array
       }
       // run a loop
       for (int index = 0; index < arr.length ; index++) {
           // check for the element at evert index if it is = target
           int element = arr[index];
           if (element == target) {
                return index;

               // to return the element:
               // modify for loop with enhanced for loop for only elements
//               for(int element : arr) {
//                   if (element == target) {
//                       return element;
//                   }
//               }

           }
       }
       // if none of the above return statements is hit
       // hence target not found
       return -1;
    }
}

// Iterable is an object which can be looped over or iterated over with the help of a for loop
