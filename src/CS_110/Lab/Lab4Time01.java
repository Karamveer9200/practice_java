package CS_110.Lab;
import java.util.Scanner;

public class Lab4Time01 {
    public static void main(String[] args) {
        System.out.println("Enter the hour: ");
        Scanner sc = new Scanner(System.in);
        int hour = sc.nextInt();

        if (hour > 1 && hour < 12) {
            System.out.println("Good Morning");
        } else if (hour >= 12 && hour < 17) {
            System.out.println("Good Afternoon");
        } else if (hour >= 17 && hour < 24) {
            System.out.println("Good Night");
        } else{
            System.out.println("Invalid Input");
        }

    }
}

