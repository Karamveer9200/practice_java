package beginning.oops.practice.conversions;

import java.util.Scanner;

// program to convert binary to hexadecimal, decimal , and all other formats, binary to real numbers;
abstract class numbers{ // super class
    String f;
    int i=0,m,y,fin=0;
    String fin2;
    String[] ch1 = new String[200];
    char[] ch2 = new char[200];
    int[] ch3 =new int[200];
    int c;
}
public class conversion_all {          /// binary with point . sill need to be written

        public static void main(String[] args) {
            String b;
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter Binary numbers: ");
            b = sc.nextLine();  // single input window to all classes
            // binary to octal
            bin_oct bo = new bin_oct();
            bo.convert(b);
            System.out.println(" ");
            // binary to hexadecimal
            bin_hex bh = new bin_hex();
            bh.convert(b);
            System.out.println(" ");
            // binary to decimal
            bin_dec bd = new bin_dec();
            bd.convert(b);

        }
    }


