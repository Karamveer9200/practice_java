package OOPs_java.basics;

// We'll be looking at two thread methods
// join()
// sleep()

//there are many more useful methods inside Thread class like:
// setDaemon(), setName(), getName(), getPriority(), setPriority(), start(), toString() etc.

class thr extends Thread {

    @Override
    public void run() {
        for (int i = 1; i < 10000; i++) {
            System.out.println("hi");
            // below sleep() will 'pause' the thread for 1 second(1000ms) before continuing the loop
//            try {
//                Thread.sleep(1000);
//            }catch (Exception e) {
//                System.out.println(e);
//            }
        }
    }
}

class thr2 extends Thread {

    @Override
    public void run() {
        for (int i = 1; i < 10000; i++) {
            System.out.println("hello");
        }
    }
}


public class ch14_6_thread_methods {
    public static void main(String[] args) {
        thr t1 = new thr();
        thr2 t2 = new thr2();

        t1.start();
        // method join() is used to wait for the thread to finish.
        // Below, it join() will 'try' to wait for the thread t1 to finish before executing t2.
        // It won't let t2 start until t1 finishes
        try{
            t1.join();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        t2.start();
    }
}
