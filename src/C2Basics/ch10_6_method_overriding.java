package C2Basics;
// method overriding- if the child class implements the same method present
// in the parent class again, it is known as method overriding.

// redefining method of superclass in subclass but the argument list should be same
class A{
    public int meth1(){
        return 4;
    }
    public void meth2(){
        System.out.println("I am method 2 of class A");
    }
}
class B extends A{
    // to override method should not be restrictive, i.e. private
    @Override // keyword used as an indicator to avoid confusion
    public void meth2(){ // meth2 of class B overrides meth2 of class A
        System.out.println("I am method 2 of class B");
    }
}
public class ch10_6_method_overriding {
    public static void main(String[] args) {
        B b = new B();
        b.meth2();// will not run inherited meth2, but redefined meth2

    }
}

// rules of method overriding ... pending
// - cannot override the final method
