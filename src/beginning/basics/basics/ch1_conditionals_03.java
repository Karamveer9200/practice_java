package beginning.basics.basics;
import java.util.Scanner;
public class ch1_conditionals_03 {
    public static void main(String[] args) {
        // switch case
        Scanner sc = new Scanner(System.in);
        double s,r,l,w,c;

        System.out.println("1. area of a cube");
        System.out.println("2. area of a circle");
        System.out.println("3. area of a rectangle");
        System.out.println("Enter the choice");
        int choice = sc.nextInt();
        if (choice==1 || choice==2 || choice==3){
            switch (choice) {
                case 1: // case x , x can be variable, char, string or boolean.
                    System.out.print("Enter side: ");
                    s = sc.nextDouble();
                    double sq = s * s;
                    System.out.println("area is : " +sq+ " sq units");
                    break;
                case 2:
                    System.out.println("Enter the radius:");
                    r = sc.nextDouble();
                    c = (3.14)*(r*r);
                    System.out.println("area is : "+c+ " sq units");
                    break;
                case 3:
                    System.out.println("Enter height:");
                    l = sc.nextDouble();
                    System.out.println("Enter width:");
                    w = sc.nextDouble();
                    double ar2 = l*w;
                    System.out.println("area is : "+ar2 + " sq units");
                    break;
            }
        }
            else{
                System.out.println("Choice un-valid");

               // 'ENHANCED' switch (no 'break;' required at the end)                 (case x -> {})
               /* switch (choice) {
                    case 1 -> {
                        System.out.print("Enter side: ");
                        s = sc.nextDouble();
                        double sq = s * s;
                        System.out.println("area is : " + sq);
                    }
                    case 2 -> {
                        System.out.println("Enter the radius:");
                        r = sc.nextDouble();
                        c = (3.14) * (r * r);
                        System.out.println("area is : " + c);
                    }
                    case 3 -> {
                        System.out.println("Enter height:");
                        l = sc.nextDouble();
                        System.out.println("Enter width:");
                        w = sc.nextDouble();
                        double ar2 = l * w;
                        System.out.println("area is : " + ar2);
                    }
               */
                }
        }
    }
