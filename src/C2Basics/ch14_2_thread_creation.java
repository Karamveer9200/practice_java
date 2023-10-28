package C2Basics;
//----------------------------------------------------------
// Method 2: Thread Creation by Implementing Runnable interface
//----------------------------------------------------------

// For that, we implement 'Runnable' interface

class class_A implements Runnable {
    // void fun1() { // only run() will execute the thread
    // we have to 'override run() method' that we are implementing from Runnable


    // start() method of class Thread will execute run() method of interface Runnable
    @Override
    //void run(){ // ERROR : 'default' method from another package
    public void run() {
        for (int i = 1; i < 100; i++) {
            System.out.println("Thread 1 : hello");
        }
    }
}

// Thread creation 2
class class_B implements Runnable {

    // void run() {
    @Override
    public void run() {
        for (int i = 1; i < 100; i++) {
            System.out.println("Thread 2 : hi");
        }
    }
}

public class ch14_2_thread_creation {
    public static void main(String[] args) {

        // Remember 'bullet' and 'gun' analogy

        // bullet (obj. of implemented class)
        class_A bullet1 = new class_A();
        // gun (ojb. of class Thread) // load...
        Thread gun1 = new Thread(bullet1); // bullet loaded

        class_B bullet2 = new class_B();
        Thread gun2 = new Thread(bullet2);

        // Running two threads // fired !!
        gun1.start(); // start() will execute run()
        gun2.start();

    }
}
