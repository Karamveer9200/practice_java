package C2_OOPS_and_Basics;

// Ways to Import packages:
// 1. Using 'import' keyword:

// import java.util.Scanner; ---> used 'full address' to import scanner class specifically
// import java.util.*;       ---> used '*' to import all the classes inside util package

//2. Importing a specific class during object creation:

// 'without' using import keyword:
// java.util.Scanner sc = new java.util.Scanner(System.in);



//import java.util.Scanner; // import scanner class specifically
//import java.util.*;   // import all classes inside util package


public class ch12_4_0_importing_packages {
    public static void main(String[] args) {
        System.out.println("Enter a number");

        // if we imported util package, we can use class name it directly during object creation
        // Scanner sc = new Scanner(System.in);

        // if we don't want to use import keyword,
        // we have to type the 'full address' of scanner class to create an object
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int a = sc.nextInt();
        System.out.println("Input " + a);

    }
}
