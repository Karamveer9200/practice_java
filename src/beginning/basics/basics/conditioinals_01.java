package beginning.basics.basics;
import java.util.Scanner;
public class conditioinals_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter your age ");
        int age = sc.nextInt();
        if(age>=18){
            System.out.println("congrats, you can drive!! ");
        }
        else{
            System.out.println("Sorry, you cant drive yet :(");
        }
        // ==, >=, <=, >, <, != are all relational (boolean) operators

        /* other way
        boolean = (age>=18);
        if (cond){      // if cond = true, if statement will execute ,otherwise else.
              System.out.println("congrats, you can drive!! ");
                 }
                 else{ ...
         */
    }
}
