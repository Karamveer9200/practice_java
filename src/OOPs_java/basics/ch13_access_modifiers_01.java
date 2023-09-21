package OOPs_java.basics;

/*
Access Modifiers in Java:
  Access modifiers determine whether other classes can use a particular field or invoke a particular
 method can be public, private, protected, or default (no modifier). See the table given below :

Access Modifier  	|within class|	|within package|	|outside package by subclass only|	|outside package|
                                                         (extended from original package)
public                 	Yes	              Yes	                      Yes	                        Yes
protected              	Yes	              Yes	                      Yes	                        No
default                	Yes	              Yes	                      No	                        No
private              	Yes	              No	                      No	                        No

'Default is not an access modifier', it is assigned by default if we don't specify any.

 -- In Java, a class cannot have 'protected' or 'private' access modifier.

*/

public class ch13_access_modifiers_01{ // 'public' - class can be accessed outside this package

    public    int a = 1; // a can be accessed outside the package
    protected int b = 2; // b can be accessed outside the package 'only via subclass' of this class
              int c = 3; // c(default) cannot be accessed outside this package
    private   int d = 4; // d cannot be accessed outside this class
}

class using_access_modifiers {
    public static void main(String[] args) {
        ch13_access_modifiers_01 obj = new ch13_access_modifiers_01();
        System.out.println(obj.a);
        System.out.println(obj.b);
        System.out.println(obj.c);
        // System.out.println(obj.d); // int d is 'private' cannot be accessed in this class
    }
}

// -- IMPORTANT--
// go to package: Others.Access_Modifiers
//         class: using_access_modifiers01(and 02) to see the working further ...
