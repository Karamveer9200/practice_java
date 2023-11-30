import java.util.Scanner;
/**
   This program prints strings in boxes.
*/
public class Boxes
{
   public static void main(String[] args)
   {
      boxString("banana" + " lemon");
      boxString("pineapple");
	  Scanner in = new Scanner(System.in);
	  //boxString(in.next());
	  String str = "apple";
	  boxString(str);
   }

   /**
      Prints a string in a box.
      @param str the string to print
   */
   public static void boxString(String str)
   {
      int n = str.length();
   	  printRow(n);
      System.out.println("*" + str + "*");
	  printRow(n);
   }

   public static void printRow(int length){
	   for (int i = 0; i < length + 2; i++) {
			 System.out.print("*");
	}	  
	System.out.println();
  }
}
