package cs110.Lab.Lab8.signOff;

import java.util.Scanner;

public class OutsideWall {
    static final double U_VALUE_WALL_SOLID = 2;
    static final double U_VALUE_WALL_NO_INSULATION = 1;
    static final double U_VALUE_WALL_INSULATED = 0.5;
    static final double TEMP_DIFFERENCE = 22;

    private double height;
    private double width;
    private double length;
    // outside walls length-side
    private static int lengthWalls;
    // outside walls width-side
    private static int widthWalls;
    private static double uValueWalls;

    // String messages
    static final String DISP_INV_INPUT = "Invalid input, enter an integer between 1 - %d";
    static final String DISP_INV_INPUT_2 = "Invalid input";

    public void setDimensions(double height, double width, double length) {
        this.height = height;
        this.width = width;
        this.length = length;
    }

    public double getAreaOfWalls() {
        double lengthSide = (length * height) * lengthWalls;
        double widthSide = (width * height) * widthWalls;
        return lengthSide + widthSide;
    }

    // heat-loss through walls , area of windows needed
    double heatLossWalls(double areaOfWindow) {
        return (getAreaOfWalls() - areaOfWindow) * uValueWalls * TEMP_DIFFERENCE;
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



    // to read an integer and figure out the wall type
    private int wallType() {
        int wallT = 0;
        boolean isNotValid = true;
        System.out.println("Select the wall type:");
        System.out.println("1. Solid");
        System.out.println("2. Cavity No insulation");
        System.out.println("3. Cavity + Insulated");
        while (isNotValid) {
            wallT = getInt();
            if (wallT == 1 || wallT == 2 || wallT == 3) {
                isNotValid = false;
            } else {
                System.out.println(String.format(DISP_INV_INPUT, 3));
            }
        }
        return wallT;
    }

    // // to figure out the U value of the wall type
     void uValueWall() {
        double uValue = 0;
        int input = wallType();
        switch (input) {
            case 1:
                uValue = U_VALUE_WALL_SOLID;
                break;
            case 2:
                uValue = U_VALUE_WALL_NO_INSULATION;
                break;
            case 3:
                uValue = U_VALUE_WALL_INSULATED;
                break;
            default:
                System.out.println("Some Logical Error");
        }
        uValueWalls = uValue;
    }

    // outside walls and what side wall
     public void outsideWalls() {

        System.out.println("Total outside walls: ");
        int totalWalls = getInt();
        boolean notValid = true;
        int lengthSideWalls;

        if (totalWalls >= 1 && totalWalls <= 4) {
            switch (totalWalls) {
                case 1:
                    System.out.println("Total length-side walls: ");
                    do {
                        lengthSideWalls = getInt();
                        if (lengthSideWalls == 1) {
                            lengthWalls = 1;
                            widthWalls = 0;
                            notValid = false;
                        } else if (lengthSideWalls == 0) {
                            lengthWalls = 0;
                            widthWalls = 1;
                            notValid = false;
                        } else {
                            System.out.println("Not a legal number");
                        }
                    } while (notValid);
                    break;
                case 2:
                    System.out.println("Total length-side walls: ");
                    do {
                        lengthSideWalls = getInt();
                        if (lengthSideWalls == 1) {
                            lengthWalls = 1;
                            widthWalls = 1;
                            notValid = false;
                        } else if (lengthSideWalls == 2) {
                            lengthWalls = 2;
                            widthWalls = 0;
                            notValid = false;
                        } else if (lengthSideWalls == 0) {
                            lengthWalls = 0;
                            widthWalls = 2;
                            notValid = false;
                        } else {
                            System.out.println("Not a legal number");
                        }
                    } while (notValid);
                    break;
                case 3:
                    System.out.println("Total length-side walls: ");
                    do {
                        lengthSideWalls = getInt();
                        if (lengthSideWalls == 1) {
                            lengthWalls = 1;
                            widthWalls = 2;
                            notValid = false;
                        } else if (lengthSideWalls == 2) {
                            lengthWalls = 2;
                            widthWalls = 0;
                            notValid = false;
                        } else {
                            System.out.println("Not a legal number");
                        }
                    } while (notValid);
                    break;
                case 4:
                    lengthWalls = 2;
                    widthWalls = 2;
                    break;
                default:
                    System.out.println("Some logical error");
            }
        } else {
            System.out.println(DISP_INV_INPUT_2);
            outsideWalls();
        }
    }
}
