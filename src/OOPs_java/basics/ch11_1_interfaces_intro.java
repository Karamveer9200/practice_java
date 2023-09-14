package OOPs_java.basics;

// Interface: Interface is a point where two systems meet and interact.
// E.g. tv remote(BUTTONS) is an interface between you and TV.
//    |tv|   ---buttons--->  |human|
//            (interface)

// In JAVA interface is a 'group of related methods' with 'empty bodies'.
// E.g.

interface motorbike{

    // all methods related to motorbike
    void accelerate(int increment);
    void applyBrake(int decrement);
    void auto_headlight(boolean sunlight);

    // variables can also be declared in interfaces, but their values become fixed
    int a = 50; // the value of int a is final and cannot be changed

}

// 'implements' keyword is used after class name to access interface
// every method of the interface must be defined (otherwise error)
// overridden interface methods should be 'public'
// * multiple interfaces can be used by a class, unlike abstract class (only one class can be inherited)
class royal_enfield implements motorbike{
    int speed =10;
    @Override
    public void accelerate(int increment) { //must be public
    speed = speed + increment;
    }
    @Override
    public void applyBrake(int decrement) {
        speed= speed - decrement;
    }
    @Override
    public void auto_headlight(boolean sunlight) {
        if(sunlight){//true
            System.out.println("Headlight on");
        }
    }
    public void auto_start(){
        System.out.println("Starting engine");
    }

}
public class ch11_1_interfaces_intro {
    public static void main(String[] args) {
        royal_enfield bullet = new royal_enfield();
        bullet.auto_start();
        bullet.accelerate(20);

        bullet.speed=30;
        System.out.println(bullet.speed);

        // bullet.a = 60; // error: declared inside an interface, fixed(constant)
        System.out.println(bullet.a);
    }
}
