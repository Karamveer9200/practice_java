package OOPs_java.basics;

// Exception class in Java
// We can write and 'throw' our custom exceptions using Exception class in Java.
// For that, we have to 'extend' Exception class and override its methods

//  public class MyException extends Exception{
//  overridden methods
//  }

// We cannot randomly throw our exceptions, it will halt the program's execution.
// It is always better to 'throw' our own exception inside a try-catch block
import java.util.Scanner;

// writing a custom exception
class MaxAgeException extends Exception{

    @Override
    public String toString(){ //return type: always String, executed when sout(e) is ran
        return "(e) Age should be less than 125";
    }
    @Override
    public String getMessage(){ // prints the exception message
        return "Make sure the age entered is correct";
    }

}

public class ch15_4_exception_class {
    public static void main(String[] args) {
        int age;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the age : ");
        age=sc.nextInt();
        // if age is greater than 125, we will throw our custom exception
        if(age>125){

            try{ // thrown our custom exception

                // to throw our custom exception,
                // we have to make an object of out exception class

                // new MaxAgeException(); --> (object created without a reference)
                throw new MaxAgeException(); //object thrown directly, reference not needed, not created.

                // MaxAgeException yoyo = new MaxAgeException(); // will work the same
                // throw yoyo;         // why throw the reference, if we can just throw the object directly?

            }
            catch (Exception e){ //handling exception

                System.out.println(e.toString()); // = sout(e)
                System.out.println(e.getMessage());
                // System.out.println(e); will always print the message of toString() method
                System.out.println(e);
                // e.printStackTrace(); will print the exact location of the exception
                e.printStackTrace();
            }
        }

    }
}
