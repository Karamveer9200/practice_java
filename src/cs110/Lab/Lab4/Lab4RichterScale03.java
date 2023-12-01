package cs110.Lab.Lab4;

import java.util.Scanner;

public class Lab4RichterScale03 {
    public static void main(String[] args) {

        System.out.println("Magnitude: ");
        Scanner sc = new Scanner(System.in);
        int mag = sc.nextInt();

        switch(mag) {
            case 6:
                System.out.println("Damage to a moderate number of well-built " +
                    "structures in populated areas. Earthquake-resistant structures" +
                    " survive with slight to moderate damage. Poorly designed structures" +
                    " receive moderate to severe damage. Felt in wider areas; up to " +
                    "hundreds of kilometers from the epicenter. Strong to violent " +
                    "shaking in the epicentral area.");
                break;
            case 7:
                System.out.println("Causes damage to most buildings, some to partially or" +
                    " completely collapse or receive severe damage. Well-designed " +
                    "structures are likely to receive damage. Felt across great distances" +
                    " with major damage mostly limited to 250 km from the epicenter.");
                break;
            case 8:
                System.out.println("Major damage to buildings, and structures likely to be" +
                    " destroyed. Will cause moderate to heavy damage to sturdy or earthquake" +
                    "-resistant buildings. Damaging in large areas. Felt in extremely large " +
                    "regions.");
            case 9:
                System.out.println("Near total destruction – severe damage or collapse to all buildings." +
                    " Heavy damage and shaking extend to distant locations. Permanent changes in" +
                    " ground topography.");
                break;
            default:
                System.out.println("Invalid Input");
        }

    }
}


