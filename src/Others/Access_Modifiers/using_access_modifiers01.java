package Others.Access_Modifiers;

// Importing class ch13_access_modifiers_01 from package OOPs_java.basics
import C2Basics.ch13_access_modifiers_01;

class checking extends ch13_access_modifiers_01{
    //inheriting the variables from class ch13_access_modifiers_01
    void display() {
            System.out.println(a);

            // int b is 'protected',
            // it is only accessible outside its package .: we 'extended' the class ch13_access_modifiers_01
            System.out.println(b);

            //System.out.println(c);  // ERROR - int c is 'default' cannot be accessed outside package
            //System.out.println(d);  // ERROR - int d is 'private' cannot be accessed outside its class
        }
}

public class using_access_modifiers01 {
    public static void main(String[] args) {
        checking obj = new checking();
        obj.display(); // only prints a and b
    }
}
