package C2_OOPS_and_Basics;

// Constructors in Inheritance
// When a Derived class is extended from the Base class, the constructor
// of the Base class is executed first followed by the constructor of the
// Derived class

// if the Base class has a constructor, it will always be initiated in derived
// class at the time of object creation

class base{
    base(){
        System.out.println("I am a base class constructor");
    }
}
class derived extends base{
    derived(){
        System.out.println("I am a derived class constructor");
    }
}
public class ch10_0_inheritance_02_constructors {
    public static void main(String[] args) {
        // constructor of the base class executes before the constructor of derived class
        derived dc = new derived();
    }
}

// construction execution:
// C1(parent) --> C2(child) --> C3(grand child)

