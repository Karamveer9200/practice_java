package C2_OOPS_and_Basics;

public class ch6_arrays_02 {
    public static void main(String[] args) {

        // different data-types

        int [] marks = {1,2,3,4};
//        float [] marks_f = {1.5f,2.5f,3.5f,4.5f};
//        String [] students = {"Ram","Harry","Jiddu","mohd"}; // String with 'S'

        System.out.println(marks.length);
//        System.out.println(marks_f.length);

        // Displaying the array (Naive Way)
        System.out.println("Printing using Naive way");
        System.out.println(marks[0]);
        System.out.println(marks[1]);
        System.out.println(marks[2]);
        System.out.println(marks[3]);

//        // Displaying the array (Naive Way)
//        System.out.println("Printing using Naive way");
//        System.out.println(students[0]);
//        System.out.println(students[1]);
//        System.out.println(students[2]);
//        System.out.println(students[3]);

         // Displaying the array (for loop - array traversal)
        System.out.println("printing using for-loop");
        for (int i=0; i<marks.length; i++ ) {
            System.out.println(marks[i]);
        }

        // Displaying the array reverse (for loop - array traversal)
        System.out.println("printing using for-loop");
        for (int i=marks.length-1; i>=0; i-- ) {
            System.out.println(marks[i]);
        }

        // Displaying the Array (for-each loop)
        System.out.println("printing using for-each loop");
        for (int element1: marks) {
            System.out.println(element1);
        }
    }
}
