package cs110.Lab.Lab9;

import java.util.Scanner;

public class Window {
    private int id;
    static final double U_VALUE_WINDOW_SINGLE_GLAZED = 5.7;
    static final double U_VALUE_WINDOW_DOUBLE_GLAZED = 3;
    static final double TEMP_DIFFERENCE = 22;

    static final String DISP_INV_INPUT = "Invalid input, enter an integer between 1 - %d";
    static final String DISP_INV_INPUT_2 = "Invalid input";

    private double sideA;
    private double sideB;
    private double uValueWindow;

    // constructor for making objects with a loop
    Window(int id) {
        this.id = id;
    }

    // dimensions for the window
    public void setDimensions(double roomHeight, int windowNumber) {
        System.out.println("Dimensions for window" + (windowNumber + 1));

        System.out.print("Window side a (meters): ");
        sideA = validWindowSize(roomHeight);
        System.out.print("Window side b (meters): ");
        sideB = validWindowSize(roomHeight);
    }

  // checks if window height < wall height
    private double validWindowSize(double roomHeight) {
        double size;
        boolean notValid = true;
        do {
            size = getDouble();
            if (size < roomHeight) {
                notValid = false;
            }else {
                System.out.println("Window height >= wall height !");
            }
        } while (notValid);
        return size;
    }

    public double getAreaOfWindow() {
        return sideA * sideB;
    }

   public double totalHeatLossWindow() {
        return getAreaOfWindow() * uValueWindow * TEMP_DIFFERENCE;
    }

    // to read an integer and figure out the window type
    private int windowType(int windowNumber) {
        int windowT = 0;
        boolean isNotValid = true;
        System.out.println("Window" + (windowNumber + 1));
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
    public void uValueWindow(int windowNUmber) {
        double input = windowType(windowNUmber);
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

    // accept double input
    private double getDouble() {
        double returnValue;
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNextDouble()) {
            System.out.println(DISP_INV_INPUT_2);
            sc.nextLine();
        }
        returnValue = sc.nextDouble();
        return returnValue;
    }
}

