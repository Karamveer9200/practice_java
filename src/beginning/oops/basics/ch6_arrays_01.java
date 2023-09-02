package beginning.oops.basics;

public class ch6_arrays_01 {
    public static void main(String[] args) {
        /*classroom of 500 students
        method1 - make 500 variables
        method2 - make an array (preferred)

        storing marks of 500 students
        int[]marks;

        object creation below:-
        int[]marks = new int[499] (memory allocation 500);
        */

        //----------------------------------------------------------
        // working - starts from 0 to (n-1), where n is the [n]

        //1
//        int[]marks; // Declaration
//        marks = new int[5]; // Memory Allocation
//        marks[3]= 89;
//        marks[4]= 56;
//        marks[6]= 67; -throws an error


//        //2.  Declaration + Memory Allocation
//        int[]marks = new marks[5];

//        //3. Declaration + Initialize + Memory allocation(auto)
        int[]marks = {34,24,73,45,14,56};
        System.out.println(marks[4]);
        System.out.println(marks.length); // max allocation possible

    }
}
