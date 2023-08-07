package beginning.basics.basics;
import java.util.Scanner;
public class conditionals_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*char l_0;             // this problem could be solved via array
        boolean i,local;

        System.out.println("are you a LOCAL RESIDENT  Y/N");
        l_0 = sc.next().charAt(0);
        local = ((l_0 == 'y') || (l_0 == 'Y') || (l_0 == 'n') || (l_0 == 'N'));
        for (i=local) {
                System.out.println("Enter again");
                l_0= sc.next().charAt(0);
            }
        }*/
        System.out.println("enter your age ");
        int age = sc.nextInt();

        if (age>=18 && age<=75){
            System.out.println("Congrats, you are ELIGIBLE for a license ");
        }
        else if (age<18 && age>=16) {
            System.out.println("Sorry, you are only ELIGIBLE for a LEARNING license");
        }
        else if (age<16) {
            System.out.println("Sorry, you are UN-ELIGIBLE for a license (UNDER-AGE)");
        }
        else {
            System.out.println("Congrats, you are ELIGIBLE for a license (MEDICAL TEST REQUIRED)");
        }
        // &&(and), ||(or), !(not) are rational (connecting) operators
        //                  !(not) will reverse the value of a boolean : a->true  !a->false
    }
}