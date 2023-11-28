package C2Basics;
import java.util.Scanner;
public class ch3_string_methods {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int value;
        String name = "Karamveer Singh Saini";
        // some common string methods
        value = name.length(); // calculates the length of string (including space)
        System.out.println(value);

        String str_lc = name.toLowerCase();// converts the string to lower case
        System.out.println(str_lc);

        String str_uc = name.toUpperCase();// converts the string to upper case
        System.out.println(str_uc);


        // trimming

        System.out.println(name);
        String trimmed_str = name.trim(); // x.trim() , will eliminate blank spaces in the string
        System.out.println(trimmed_str);

        // substrings

        System.out.println(name.substring(2));// print the string starting from 3rd letter : ramveer
        System.out.println(name.substring(3,6));// print the string from 4th letter till 7th letter   : amv

        // replace
        System.out.println(name.replace("K","S"));// replace
        System.out.println(name.replace("ara","T"));// replace multiple characters
        System.out.println(name.replace("a","i"));// replace characters at multiple locations

        // others
        System.out.println(name.startsWith("Kar"));// true/false
        System.out.println(name.endsWith("ini"));  // true/false
        System.out.println(name.equals("karamveer singh saini")); // true/false
        System.out.println(name.equalsIgnoreCase("karamveer singh saini")); // will ignore the case true/false

        // index
        System.out.println(name.charAt(5)); // return 6th letter
        System.out.println(name.indexOf("a")); // return the first occurrence of a
        System.out.println(name.lastIndexOf("a")); // return the last occurrence of a
        System.out.println(name.lastIndexOf("a",18)); // return the last occurrence of a (incl spaces)
                                                                    // searched only in first 19 letters
        System.out.println(name.lastIndexOf("in"));
        System.out.println(name.lastIndexOf("xyz"));// will return -1
        System.out.println(name.lastIndexOf("a",5));// return the last occurrence of a (incl spaces)
                                                                   // searched only in first 6 letters
        // escape sequences
        System.out.println("\"I am an escape sequence\"");// double quotes with \"
        System.out.println("I\tam\tan\tescape\tsequence");  // space with '\t'
        System.out.println("I am an escape \n sequence");// new line after '\n'
        System.out.println("I am an escape sequence\\");// '\\' to print \


    }
}
