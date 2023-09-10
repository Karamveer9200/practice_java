package beginning.oops.basics;

// Dynamic method dispatch
// Consider the following inheritance hierarchy:

// |class Super| --->meth1()
//               --->meth2() #1

// |class  Sub | --->meth2(overridden) #2
//               --->meth3()

// Scenario 1 ---> Super obj = new Sub()  ---> ALLOWED (ref. of Super, ojb. of Sub)
//                 obj.meth2() ---> #2 is called
//                 obj.meth3() ---> NOT ALLOWED X

// Scenario 2 ---> Sub obj = new Super() ---> NOT ALLOWED X (ref. of Sub, ojb. of Super)

class phone{
    public void snake(){
        System.out.println("game_snake __--__-->~");
    }
    public void turnOn(){ // #1
        System.out.println("turning on phone ...");
    }
}
class smartphone extends phone{
    @Override
    public void turnOn(){ // #2
        System.out.println("turning on smartphone ...");
    }
    public void googleMaps(){
        System.out.println("Opening google maps ...");
    }

}
public class ch10_7_dynamic_method_dispatch {
    public static void main(String[] args) {
        // reference of superclass with object of subclass
        // objects formed with the reference of superclass
        // can only execute methods present in the superclass itself
        // or the same methods overridden in the subclass
        phone banana = new smartphone();

        //smartphone mango = new phone(); // not allowed

        banana.snake();  // will execute snake method from phone
        banana.turnOn(); // will execute overridden method turnOn of smartphone
        //banana.googleMaps();// will not run(method not present in phone)

    }
}
