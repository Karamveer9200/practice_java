package beginning.oops.basics;
// super keyword
// a reference variable used to refer immediate parent class object.
// -> can be used to refer immediate parent class instance variable.
// -> can be used to invoke parent class methods.
// -> can be used to invoke parent class constructors.

class class1{
    class1(int a, int b){
        System.out.println("i am a class1 constructor ");
    }
}
class class2 extends class1{
    class2(int a){
        // if we do not use 'super(a,40)' here, by default object of class2 with parameter will want to execute
        // a constructor in the class1 first, but there is no constructor with empty parameters, throws error
        // so, we use super keyword to pass some values to the class1 constructor which can accept some values, so it can be
        // executed first
        super(a,40);
        System.out.println("i am a class2 constructor");
    }
}
public class ch10_5_super_keyword {
    public static void main(String[] args) {
        class2 ch = new class2(20);
    }

}
