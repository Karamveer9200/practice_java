package OOPs_java.basics;

//----------------------------------------------------------
// make two threads and delay the execution of second thread by 2 seconds
// use setPriority(), getPriority() methods.
// Use getState() method.
// Get the reference of currently running thread using Thread.currentThread().

class thr_a extends Thread{
    public void run(){

        for(int i = 1; i < 100; i++){
            System.out.println("Welcome");
        }
    }
}
class thr_b extends Thread{
    public void run(){

        try{
            Thread.sleep(2000); // trying to delay execution by 2 seconds
        }
        catch(Exception e){
            System.out.println(e);
        }

        for(int i = 1; i < 100; i++){
            // sleep() can also be used inside this loop to delay execution of each loop by sometime
            // e.g. loop may hava a gap of five min between each execution (like auto save feature)
            System.out.println("Good Morning");
        }
    }
}

public class ch14_practice {
    public static void main(String[] args) {
        thr_a t1 = new thr_a();
        thr_b t2 = new thr_b();
        //setting priority
        t1.setPriority(6);
        t2.setPriority(3);
        //setting name
        t1.setName("thread 1");
        t2.setName("thread 2");

        // thread execution
        t1.start();
        t2.start(); // delayed execution by 2 seconds

        // getting priority
        System.out.println("Priority of t1 is :"+t1.getPriority());
        System.out.println("Priority of t2 is :"+t2.getPriority());
        // getting state
        // getState() method returns the state of the thread
        // i.e. NEW, RUNNABLE, RUNNING, TIMED_WAITING, BLOCKED, WAITING, TERMINATED
        System.out.println("Priority of t1 is :"+t1.getState());
        System.out.println("Priority of t2 is :"+t2.getState());

        // Getting 'reference' of currently running thread using Thread.currentThread()
        // current thread is 'main' thread, we are giving reference of the main thread to methods
        System.out.println("Currently running thread is : "+Thread.currentThread().getName()+
                "| Priority : "+Thread.currentThread().getPriority()+
                "| State : "+Thread.currentThread().getState());

    }
}

