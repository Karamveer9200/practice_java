package beginning.oops.basics;
import java.util.Scanner;
public class ch2_strings_01 {
    public static void main(String[] args) {
      /*  String mc;
        mc = new String("shoes");// this is one way to register a string (creating object)

        // second method

        String dc = "boots"; // 'S' is in capital, same string object cannot be changed again in java
                             // it can be changed by creating a duplicate object with a different name
        System.out.print("the name is : "); // 'print' will NOT shift to next line
        System.out.println(mc);             // 'println' will shift to next line
        System.out.print("the name is : ");
        System.out.println(dc);

        // other methods for people familiar to c++/c

        float a = 34.5678f;
        int b = 4;
        System.out.printf(" the number is %f and the other one is %d",a,b);
        System.out.printf(" the number is %9f and the other one is %d",a,b);  // '9f': result take the space of 9 blank spaces when displayed
        System.out.format(" the number is %.2f and the other one is %d",a,b); // '.2f' will only display two
          */                                                                  //  decimal places : 34.56

        // input string
        Scanner sc= new Scanner(System.in);

        System.out.println("ENTER first name");// only register first word
        String fw = sc.next();
        sc.nextLine(); // important*  CANNOT use xx.next.line() after xx.next() : xx.next() will only read
                       // the value when press 'ENTER' and not the 'END OF LINE', use xx.nextLine() to register end of line.
        System.out.println("ENTER full name");   // register full string
        String fn = sc.nextLine();
        System.out.println(fw);
        System.out.println(fn);

    }
}
