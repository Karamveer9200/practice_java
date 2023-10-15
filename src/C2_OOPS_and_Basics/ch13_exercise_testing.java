package C2_OOPS_and_Basics;

import java.util.Scanner;

public class ch13_exercise_testing {

    //int length; // --ERROR: can't access instance variable .: no object creation in the main method
    // So, we have to make them 'static' to make then accessible to this class
    static int length;
    static int width;


        // area method
        // public int area(){ // --ERROR: can't access .: 'no object creation' in the main method
        // So, we have to make it 'static' to make it accessible to this class
        public static int area(){

            return length * width;
        }

        // setters for length and width
        public static void set_Len(int l){
            // this.length = length; cannot use 'this.' since 'no object creation' (no separate heap segment)
            // is happening in the main method
            length = l;
        }
        public static void set_Wid(int w){
            // this.width = w; cannot use this. since no object creation (no separate heap segment)
            width = w;
        }


        public static void main(String[] args){
            int l ;
            int b;
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the length");
            l = sc.nextInt();
            set_Len(l);
            System.out.println("Enter the width");
            b = sc.nextInt();
            set_Wid(b);
            System.out.println("area of square is "+area()+" m/sq");
        }

}
