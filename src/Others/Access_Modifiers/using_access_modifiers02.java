package Others.Access_Modifiers;

// Importing class ch13_access_modifiers_01 from package OOPs_java.basics
import C2Basics.ch13_access_modifiers_01;

public class using_access_modifiers02 {
    public static void main(String[] args) {
        ch13_access_modifiers_01 obj = new ch13_access_modifiers_01();

        // int a is 'public', so it is accessible outside its package
        System.out.println(obj.a);

        // int b is 'protected', so it is accessible outside its package only via subclass of ch13_access_modifiers_01
        // since we did not make any class to extend ch13_access_modifiers_01, int b is inaccessible
        //System.out.println(obj.b); // ERROR(protected)

        //System.out.println(obj.c); // ERROR(default)
        //System.out.println(obj.d); // ERROR(private)

    }
}
