package cs110.Lab.Lab9;

import java.util.Scanner;

public class OutsideWall {
    private final int id;

    // constructor for making objects with a loop
    OutsideWall(int id) {
        this.id = id;
    }
    static final double U_VALUE_WALL_SOLID = 2;
    static final double U_VALUE_WALL_NO_INSULATION = 1;
    static final double U_VALUE_WALL_INSULATED = 0.5;
    static final double TEMP_DIFFERENCE = 22;


    private double uValueWalls;
    private double height;
    private double length;

    private static double totalAreaOutsideWalls = 0;

    // String messages
    static final String DISP_INV_INPUT = "Invalid input, enter an integer between 1 - %d";
    static final String DISP_INV_INPUT_2 = "Invalid input";

    public void setDimensions(double roomHeight, double periphery, double totalRoomLength) {
        System.out.print("Wall height (meters): ");
        height = validHeight(roomHeight);
        System.out.print("Wall length (meters): ");
        length = validLength(periphery, totalRoomLength);

        setAreaOfWalls();
    }

    public double getLength() {
        return length;
    }

    // to input valid wall height
    private double validHeight(double roomHeight) {
        double size;
        boolean notValid = true;
        do {
            size = getDouble();
            if (size < roomHeight) {
                notValid = false;
            }else {
                System.out.println("Wall height >= Room height !");
            }
        } while (notValid);
        return size;
    }

   // to input valid wall length
    private double validLength(double periphery, double totalWallLength) {
        double size;
        boolean notValid = true;
        do {
            size = getDouble();
            if ((size + totalWallLength) < periphery) {
                notValid = false;
            }else {
                System.out.println("Total wall length > room periphery  !");
            }
        } while (notValid);
        return size;
    }

    private void setAreaOfWalls() {
        totalAreaOutsideWalls += length * height;
    }

    static double getTotalAreaOutsideWalls() {
        return totalAreaOutsideWalls;
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
     public void uValueWall() {
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

    public double getUValue() {
        return uValueWalls;
    }

    public double getTempDiff() {
        return TEMP_DIFFERENCE;
    }
}
