package C2Basics;

public class ch10_9_Static_Keyword2 {

    // value of field pi will be same for all the objects of the class ch10_9_Static_Keyword2
    private static  double pi = 3.14;

    // method getPi() is static and can be called by using the <classname>.<static method name> from another class

    static double getPi() {
        return pi;
    }
}
