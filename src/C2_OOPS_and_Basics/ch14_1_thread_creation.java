package C2_OOPS_and_Basics;
//----------------------------------------------------------
// Method 1: Thread Creation by Extending Thread class
//----------------------------------------------------------

// For that, we extend 'Thread' class

// Thread creation 1
class classA extends Thread {
    // void fun1() { // only run() will execute the thread
    // we have to 'override run() method' that we are extending from Thread


    // start() method of class Thread will execute run() method of class Thread
    @Override
    //void run(){ // ERROR : 'default' method from another package
    public void run() {
        for (int i = 1; i < 100; i++) {
            System.out.println("Thread 1 : hello");
        }
    }
}

// Thread creation 2
class classB extends Thread {
    // void fun1() {

    // void run() {
    @Override
    public void run() {
        for (int i = 1; i < 100; i++) {
            System.out.println("Thread 2 : hi");
        }
    }
}

public class ch14_1_thread_creation {
    public static void main(String[] args) {
        classA obj1 = new classA();
        classB obj2 = new classB();

        // only start() method of class Thread will execute the thread
        //obj1.fun1(); // simple method calling will only execute one function at a time
        //obj2.fun2();

        // Running two threads

        obj1.start(); // start() will execute run()
        obj2.start();

    }
}
