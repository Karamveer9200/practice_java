package C2Basics;
// 'super()' keyword --> calls the '(desired)' constructor from the parent class with the same parameters as itself

//  super(a,b) --> calls parent constructor base(int a, int b)
//  super(object) --> calls parent constructor base(object)
class base1{
    base1(){
        System.out.println("I am a base class constructor");
    }
    base1(int x){ // constructor overloading
        System.out.println("I am an overloaded base class constructor with value of x: "+x);
    }
}

class derived1 extends base1{
    derived1(){
        System.out.println("I am a derived class constructor");
    }
    derived1(int x, int y){
        super(x); // calls parent constructor which takes 1 variable
        System.out.println("I am an overloaded derived class constructor with value of y: "+y);
    }
}

class child_of_derived extends derived1 {
    child_of_derived() {
        System.out.println("I am a child of derived class constructor");
    }

    child_of_derived(int x, int y, int z) {
        super(x, y); // calls parent constructor which takes 2 variables
        System.out.println("I am an overloaded child of derived class constructor with value of z: " + z);
    }
}


public class ch10_0_inheritance_03_constructor_overloading {
    public static void main(String[] args) {
        // constructor of the base class executes before the constructor of derived class
//        derived1 empty1 = new derived1();
//        derived1 with_values1 = new derived1(12,33);
        child_of_derived empty = new child_of_derived();
        System.out.println("\n");
        child_of_derived with_values = new child_of_derived(12,33,45); // will initiate super keyword inside itself,
                                                                           // to execute parent constructor with parameters
                                                                           // int x, int y
    }
}

