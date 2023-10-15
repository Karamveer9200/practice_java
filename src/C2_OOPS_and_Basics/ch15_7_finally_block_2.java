package C2_OOPS_and_Basics;

public class ch15_7_finally_block_2 {
    public static void main(String[] args) {
        int a = 1000;
        int b = 10;
        int c;
        while(true){
            try{
                c=a/b;
                System.out.println(c);
            }
            catch(Exception e){ // breaks the loop when the value of b reaches 0
                System.out.println("\nBreaking the loop");
                System.out.println(e);
                break;
            }
            // 'finally' block will still be executed even if the loop is stopped by the 'break' statement
            finally{
                System.out.println("Value of b is: "+b);
            }
            b--;
        }

    }
}
