package cs110.Lab.Lab8.signOff;

import java.util.Scanner;

public class Window {
    static final double U_VALUE_WINDOW_SINGLE_GLAZED = 5.7;
    static final double U_VALUE_WINDOW_DOUBLE_GLAZED = 3;
    static final double TEMP_DIFFERENCE = 22;

    static final String DISP_INV_INPUT = "Invalid input, enter an integer between 1 - %d";
    static final String DISP_INV_INPUT_2 = "Invalid input";

    private double areaOfWindow;
    private double uValueWindow;

    public double areaOfWindow(double windowSideA, double windowSideB) {
        areaOfWindow =  windowSideA * windowSideB;

        return windowSideA * windowSideB;
    }

   public double totalHeatLossWindow() {
        return areaOfWindow * uValueWindow * TEMP_DIFFERENCE;
    }

    // to read an integer and figure out the window type
    private int windowType() {
        int windowT = 0;
        boolean isNotValid = true;
        System.out.println("Select the window type:");
        System.out.println("1. Single Glazed");
        System.out.println("2. Double Glazed");
        while (isNotValid) {
            windowT = getInt();
            if (windowT == 1 || windowT == 2) {
                isNotValid = false;
            } else {
                System.out.println(String.format(DISP_INV_INPUT, 2));
            }
        }
        return windowT;
    }


    // to figure out the U value of the window type
    public void uValueWindow() {
        double input = windowType();
        double uValue;
        if (input == 1) {
            uValue = U_VALUE_WINDOW_SINGLE_GLAZED;
        } else {
            uValue = U_VALUE_WINDOW_DOUBLE_GLAZED;
        }
        uValueWindow = uValue;
    }

    // accept int input
    static int getInt() {
        int returnValue;
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNextInt()) {
            System.out.println(DISP_INV_INPUT_2);
            sc.nextLine();
        }
        returnValue = sc.nextInt();
        return returnValue;
    }
}

