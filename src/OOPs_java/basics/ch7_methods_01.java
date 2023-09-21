package OOPs_java.basics;

public class ch7_methods_01 {
    // When we don't want to repeat logic, we put the logic in a method to use it again
// saves time, clean code, easy debugging
// Method is a function written inside a class
// Since java is an Object-Oriented language, we need to write the method inside the same class
    // syntax -
    // datatype name() {
    //    method body
    //    }

    //----------------------------------------------------------
// creating a method

// it can be called directly if 'static' (anyone in the same class can call without creating an object)
// if 'not static' we have to crate an object of class to call the method

// static: This keyword indicates that the method belongs to the class itself rather than to an instance
// of the class. In other words, you can call the static method on the class itself without creating an object
// of the class.

    static int logic(int x, int y){  // datatype 'int' is used,so, this method will return in integer
 // int logic(int x, int y){ // non static method
        int z;
       if(x>y){
           z=x+y;
       }else {
           z = (x+y)*2;
       }
       return z; // returns the 'value of z' to the place 'from where' the method was called
    }


    // 'void' when a function/method is void
    // it means it does not return anything

    // the 'main method' is 'always static',
    // this is important because the main method is the entry point of a Java program,
    // and the JVM needs to execute it before creating any object
    public static void main(String[] args) { // program only runs in the 'main' method of a class

        int a = 2;
        int b = 3;
        int c = logic(a,b);
        // ch7_methods_01 ojb = new ch7_methods_01(); // calling using object creation
        // c = obj.logic(a,b);                        // 'non-static' method calling within the same class

        int a1 = 3;
        int b1 = 2;
        int c1 = logic(a1,b1); // method called, the only logic of the method is copied here;

        System.out.println("c = "+c);
        System.out.println("c1 = "+c1);

    }
}

