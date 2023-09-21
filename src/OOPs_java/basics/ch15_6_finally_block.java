package OOPs_java.basics;

//Java finally block:

// 'finally' block contains the code which is always executed whether the exception is handled or not.
// It is used to execute code containing instructions to release the system resources, close a connection, etc.

public class ch15_6_finally_block {

    public static int divide(){
        try{
            int a = 10;
            int b = 0;
            int c = a/b;
            return c;
        }
        catch(Exception e){
            System.out.println("Exception : "+e);
        }
        // if we don't use 'finally' block, either 'try' or 'catch' will end the program
        // and our message won't be printed
        finally{
            System.out.println("Finally block executed, cleaning up the resources ...");
        }
        return -1;
    }

    public static void main(String[] args) {
        int a = divide();
        System.out.println(a);
    }
}
