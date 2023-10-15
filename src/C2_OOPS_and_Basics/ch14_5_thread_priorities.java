package C2_OOPS_and_Basics;

// There are only there priorities in Java(value 1-10):
// MIN_PRIORITY  = 0
// NORM_PRIORITY = 5(DEFAULT)
// MAX_PRIORITY  = 10

class thr1 extends Thread {
    public thr1(String name) {
        super(name);
    }
    @Override
    public void run() {
        while(true) { // infinite loop
            System.out.println(this.getName());
        }
    }
}
public class ch14_5_thread_priorities {
    public static void main(String[] args) {
        thr1 t1 = new thr1("A");
        thr1 t2 = new thr1("B");
        thr1 t3 = new thr1("C (min priority)");
        thr1 t4 = new thr1("D");
        thr1 t5 = new thr1("E (max priority)");

        //Setting thread priorities

        t5.setPriority(Thread.MAX_PRIORITY);
        t3.setPriority(Thread.MIN_PRIORITY);
        t1.setPriority(Thread.NORM_PRIORITY); // NO NEED TO WRITE THIS .: DEFAULT IS NORM


        // Running threads (remember: this process is highly dependent on OS)
        // results may not display what we expect
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

    }
}
