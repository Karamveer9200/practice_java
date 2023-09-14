package OOPs_java.basics;
// Abstract - Khayali Pulao/Standard setter
// Abstract - existing in thought or as an idea without concrete existence

// Abstract Method:
// A method that is declared without an implementation
//            abstract void moveTo(double z, double y)
// -- one abstract method will turn whole class abstract

// Abstract Class:
// it sets the standards for all its subclasses
// If a class includes abstract methods, then the class
// itself must be declared abstract, as in:
//           public abstract class Base_Phone{
//                  abstract void switchOn();
//                     // more code
//            }

// When an abstract class is subclassed, the subclass must implement
// 'all the methods in parent class'. If it doesn't, it must be
// declared abstract as well.

import java.security.PublicKey;

abstract class Base_Phone{
    // setting a standard for all the subclasses of Base_Phone 'only'.
    // object of Base_Phone cannot be made
    abstract void switchOn(); // empty no implementation
    abstract void switchOff(); // empty no implementation

}
class Phone1 extends Base_Phone{ // concrete subclass
    // all the methods of parent abstract class must be implemented (otherwise error)
    // otherwise it must be declared abstract as well
    @Override
    public void switchOn() { // implementation
        System.out.println("Switching on ...");
    }
    @Override
    public void switchOff() {
        System.out.println("Switching off ...");
    }
    public void call(){
        System.out.println("Calling ...");
    }
}

// Phone2 automatically inherited all abstract methods of Base_phone from Phone1
class Phone2 extends Phone1{
    public void camera(){
        System.out.println("Camera");
    }
}

// Phone3 is a subclass of Base_Phone but do not override all its methods.
// So the class and its methods must be declared abstract
abstract class Phone3 extends Base_Phone{
    abstract Void Auto_light(boolean sun);
}

public class ch11_0_abstract_class_and_method {
    public static void main(String[] args) {
        //Base_Phone prototype = new Base_Phone(); // error(abstract)
        Phone1 nokia1 = new Phone1();
        Phone2 nokia2 = new Phone2();
        //Phone3 samsung = new Phone3(); // error(abstract)
        nokia2.switchOn();
        nokia2.camera();
        nokia2.switchOff();

        // Reference of an abstract class can be used to make an object of subclass
        Base_Phone prototype2 = new Phone2();
        prototype2.switchOn();
        prototype2.switchOff();
        //prototype2.camera(); // error(method camera() not present in base class)



    }
}
