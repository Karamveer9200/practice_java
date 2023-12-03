package C2Basics;

public class ch10_9_Static_Keyword {
    // static keyword can be used to declare a method, fields as static
    // static fields remain unchanged even after multiple objects are created from the same class

    // static fields can be accessed without creating an object
    // static methods can be called without creating an object


    // static method from another class can be called by using the <classname>.<static method name>
    public static void main(String[] args) {
        // static method form another class is called without creating an object
        System.out.println(ch10_9_Static_Keyword2.getPi());
    }
}
