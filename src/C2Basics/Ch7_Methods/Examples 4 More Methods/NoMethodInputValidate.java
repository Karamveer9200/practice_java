
import java.util.Scanner;
/*
This is a program that reads in and validates two integers - it repeats a lot of code
*/
public class NoMethodInputValidate {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int lemons;
        int kiwis;

        do {
            System.out.print("Enter the number of lemons you want, between 1 and 7: ");
            while (!in.hasNextInt()) {
                System.out.print("I said a number between 1 and 7: ");
                in.nextLine();
            }
            lemons = in.nextInt();
        } while (lemons < 1 || lemons > 7);

        do {
            System.out.print("Enter the number of kiwis you want, between 1 and 4: ");
            while (!in.hasNextInt()) {
                System.out.print("I said a number between 1 and 4: ");
                in.nextLine();
            }
            kiwis = in.nextInt();
        } while (kiwis < 1 || kiwis > 4);

        System.out.println(lemons + " lemons and " + kiwis + " kiwis.");
    }
}
