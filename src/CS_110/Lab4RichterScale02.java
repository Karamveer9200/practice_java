package CS_110;

import java.util.Scanner;

public class Lab4RichterScale02 {
    public static void main(String[] args) {

        System.out.println("Magnitude: ");
        Scanner sc = new Scanner(System.in);
        double mag = sc.nextDouble();

        if (mag >= 6.0 && mag <= 6.9) {
            System.out.println("GDamage to a moderate number of well-built " +
                    "structures in populated areas. Earthquake-resistant structures" +
                    " survive with slight to moderate damage. Poorly designed structures" +
                    " receive moderate to severe damage. Felt in wider areas; up to " +
                    "hundreds of kilometers from the epicenter. Strong to violent " +
                    "shaking in the epicentral area.");
        } else if (mag >= 7.0 && mag <= 7.9) {
            System.out.println("Causes damage to most buildings, some to partially or" +
                    " completely collapse or receive severe damage. Well-designed " +
                    "structures are likely to receive damage. Felt across great distances" +
                    " with major damage mostly limited to 250 km from the epicenter.");
        } else if (mag >= 8.0 && mag <= 8.9) {
            System.out.println("Major damage to buildings, and structures likely to be" +
                    " destroyed. Will cause moderate to heavy damage to sturdy or earthquake" +
                    "-resistant buildings. Damaging in large areas. Felt in extremely large " +
                    "regions.");
        } else if (mag >= 9.0 && mag <= 9.9) {
            System.out.println("Near total destruction – severe damage or collapse to all buildings." +
                    " Heavy damage and shaking extend to distant locations. Permanent changes in" +
                    " ground topography.");
        } else {
            System.out.println("Nothing to worry about");
        }

    }
}




