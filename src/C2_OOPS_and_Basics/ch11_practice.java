package C2_OOPS_and_Basics;
//----------------------------------------------------------
// problem 1

//abstract class Pen {
//    abstract void write();
//
//    abstract void refill();
//}
//
//class FountainPen extends Pen{
//
//    @Override
//    public void write(){
//        System.out.println("Writing");
//    }
//    @Override
//    public void refill(){
//        System.out.println("Refill");
//    }
//    public void changeNib(){
//        System.out.println("Nib change");
//    }
//}
//
//public class ch11_practice {
//    public static void main(String[] args) {
//        FountainPen pilot = new FountainPen();
//        pilot.write();
//        pilot.refill();
//        pilot.changeNib();
//
//    }
//}

//----------------------------------------------------------
// problem 2

abstract class monkey{
    abstract void jump();
    abstract void bite();
}

interface BasicAnimal{
    void eat();
    void sleep();
}

class human extends monkey implements BasicAnimal {
    // defining interface methods
    @Override
    public void eat() {
        System.out.println("eating");
    }

    @Override
    public void sleep() {
        System.out.println("Sleeping");
    }

    // defining abstract class methods
    @Override
    void jump() {
        System.out.println("Jumping");
    }

    @Override
    void bite() {
        System.out.println("Biting");
    }
    public void speak(){
        System.out.println("Speaking");
    }
}


public class ch11_practice {
    public static void main(String[] args) {
        human john = new human();
        // methods of interface
        john.eat();
        john.sleep();
        // methods of abstract class
        john.jump();
        john.bite();
        // method of class human
        john.speak();

        // polymorphism
        monkey dun = new human();
        dun.bite();
        dun.jump();
        //dun.speak(); // error (method of human)
    }
}