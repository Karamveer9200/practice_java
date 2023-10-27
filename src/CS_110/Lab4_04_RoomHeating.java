package CS_110;

import java.util.Scanner;

public class Lab4_04_RoomHeating {
    static final double U_VALUE_WALL_SOLID = 2;
    static final double U_VALUE_WALL_NO_INSULATION = 1;
    static final double U_VALUE_WALL_INSULATED = 0.5;
    static final double U_VALUE_WINDOW_SINGLE_GLAZED = 5.7;
    static final double U_VALUE_WINDOW_DOUBLE_GLAZED = 3;
    static final double U_VALUE_FLOORS = 0.3;
    static final double TEMP_DIFFERENCE = 22;

    // outside walls length-side
    static int lengthWalls;
    // outside walls width-side
    static int widthWalls;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        // WALL and WINDOW type selection
        double uValueWall = uValueWall();
        double uValueWindow = uValueWindow();

        System.out.println("Room height (meters): ");
        double height = 2;//in.nextFloat();
        System.out.println("Room width (meters): ");
        double width = 3;//in.nextFloat();
        System.out.println("Room length (meters): ");
        double length = 4;//in.nextFloat();
        System.out.println("Window side a (meters): ");
        double windowSideA = 1;//in.nextFloat();
        System.out.println("Window side b (meters): ");
        double windowSideB = 1.5f;//in.nextFloat();

        // Total outside walls
        outsideWalls();


        double areaOfWindow = windowSideA * windowSideB;
        double lengthSide = (length * height) * lengthWalls ;
        double widthSide = (width * height) * widthWalls;

        double areaOfWalls =  lengthSide + widthSide - areaOfWindow;
        double areaOfFloor_Ceiling = length * width;
        double heatLossToWindow = areaOfWindow * uValueWindow * TEMP_DIFFERENCE;
        double heatLossToWalls = areaOfWalls * uValueWall * TEMP_DIFFERENCE;
        double heatLossToFloor = areaOfFloor_Ceiling * U_VALUE_FLOORS * TEMP_DIFFERENCE;
        double totalEnergyRequired = heatLossToWalls + heatLossToWindow + heatLossToFloor;

        System.out.println("Total energy required: "+ totalEnergyRequired);

    }

    // to figure out the type of wall and its U value
    static double uValueWall() {
        System.out.println("Select the wall type:");
        System.out.println("1. Solid");
        System.out.println("2. Cavity No insulation");
        System.out.println("3. Cavity + Insulated");
        Scanner sc = new Scanner(System.in);

        double uValue = 0;
        boolean flag = true;
        while (flag) {
            int a = sc.nextInt();
            if (a == 1) {
                uValue = U_VALUE_WALL_SOLID;
                flag = false;
            } else if (a == 2) {
                uValue = U_VALUE_WALL_NO_INSULATION;
                flag = false;
            } else if (a == 3) {
                uValue = U_VALUE_WALL_INSULATED;
                flag = false;
            } else {
                System.out.println("Invalid input");
            }
        }
        return uValue;
    }

    // to figure out the type of window and its U value
    static double uValueWindow() {
        System.out.println("Select the window type:");
        System.out.println("1. Single Glazed");
        System.out.println("2. Double Glazed");
        Scanner sc = new Scanner(System.in);

        double uValue = 0;
        boolean flag = true;
        while (flag) {
            int a = sc.nextInt();
            if (a == 1) {
                uValue = U_VALUE_WINDOW_SINGLE_GLAZED;
                flag = false;
            } else if (a == 2) {
                uValue = U_VALUE_WINDOW_DOUBLE_GLAZED;
                flag = false;
            } else {
                System.out.println("Invalid input");
            }
        }
        return uValue;
    }

    // outside walls and what side wall
    static void outsideWalls() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Total outside walls: ");
        int totalWalls = sc.nextInt();
        int lengthSideWalls;

        if(totalWalls >0 && totalWalls <5 ) {
            switch (totalWalls) {
                case 1:
                    System.out.println("Total length-side walls: ");
                    lengthSideWalls = sc.nextInt();
                    if (lengthSideWalls == 1) {
                        lengthWalls = 1;
                        widthWalls = 0;
                    }
                    break;
                case 2:
                    System.out.println("Total length-side walls: ");
                    lengthSideWalls = sc.nextInt();
                    if (lengthSideWalls == 1) {
                        lengthWalls = 1;
                        widthWalls = 1;
                    } else if (lengthSideWalls == 2) {
                        lengthWalls = 2;
                        widthWalls = 0;
                    }
                    break;
                case 3:
                    System.out.println("Total length-side walls: ");
                    lengthSideWalls = sc.nextInt();
                    if (lengthSideWalls == 1) {
                        lengthWalls = 1;
                        widthWalls = 2;
                    } else if (lengthSideWalls == 2) {
                        lengthWalls = 2;
                        widthWalls = 0;
                    }
                    break;
                case 4:
                    lengthWalls = 4;
                    widthWalls = 0;
                    break;
            }
        } else {
            System.out.println("Invalid input");
            outsideWalls();
        }
    }

}


