package C2Basics;

// Some important thread Constructors:
// Thread()               - Allocates a new thread object
// Thread(String name)    - Allocates a new thread object
// Thread(Runnable r)     - Allocates a new thread object
// Thread(Runnable r, String name)  - Allocates a new thread object
// Thread(ThreadGroup group, String name) - Allocates a new thread object(used to group similar threads)

class class_a extends Thread{
    // Creating constructor Thread(String name)
    public class_a(String name){
        // class Thread already has a constructor that takes a String and names a thread,
        // super will execute it with our string
        super(name);
    }

    // Creating constructor Thread(ThreadGroup group, String name)
    public class_a(ThreadGroup group, String name) {
        super(group, name);
    }
    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            System.out.println("Thread 1: auto-save");
        }
    }
}

// Thread 2
class class_b implements Runnable {
    // void run() {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread 2 : auto-correct");
        }
    }
}


public class ch14_4_thread_constructors {
    public static void main(String[] args) {

        // Using constructor Thread(String name)

        class_a a = new class_a("Tommy");
        a.start();
        System.out.println("Name of the thread is :"+a.getName());
        //System.out.println("Name of the thread is :"+a.getId()); // ERROR: getId() feature appreciated to threadId()
        System.out.println("ID of the thread is   :"+a.threadId());

        // Using constructor Thread(Runnable r,String name)

        class_b b = new class_b();
        Thread t = new Thread(b, "CJ");
        System.out.println("Name of the thread is :"+t.getName());
        System.out.println("ID of the thread is   :"+t.threadId());


        //----------------------------------------------------------

        // Using constructor Thread(ThreadGroup group, String name)
        // creating ThreadGroup object
        ThreadGroup tg1 = new ThreadGroup("Group gta");
        class_a x = new class_a(tg1, "Tommy");
        class_b y = new class_b();
        Thread t1 = new Thread(tg1, y, "CJ");
        // We grouped two threads together under the name "Group 1"

        System.out.println("Thread Group Name: "+tg1.getName());

        // class ThreadGroup has its own methods like:
        // list(), suspend(), resume(), waiting(), terminated(), stop(), interrupt(), activeCount(), etc
        // we can use these methods on grouped threads


    }
}
