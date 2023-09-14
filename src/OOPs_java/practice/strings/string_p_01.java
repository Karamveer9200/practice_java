package OOPs_java.practice.strings;
import java.util.Scanner;
public class string_p_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string");
        String ss = sc.nextLine();
        System.out.println(ss.toLowerCase());
        System.out.println(ss.replace(" ","_"));// replacing spaces with _
        System.out.println(ss.replace("  ","**"));
        System.out.println(ss.replace("   ","***"));

        String ss_01 =ss.replace("   ","  ");// correcting double and triple spaces
        System.out.println(ss_01);
        System.out.println(ss_01.replace("  "," "));
        System.out.println("\"Dear\tHarry\tthis\tcourse\tis\tnice,\n\tThanks!\"");// use of escape sequences

    }
}
