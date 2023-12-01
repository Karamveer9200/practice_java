package cs110.Lab;

import java.util.Scanner;
import java.util.ArrayList;

public class Lab7SignOffRoomHeating {
    static final double U_VALUE_WALL_SOLID = 2;
    static final double U_VALUE_WALL_NO_INSULATION = 1;
    static final double U_VALUE_WALL_INSULATED = 0.5;
    static final double U_VALUE_WINDOW_SINGLE_GLAZED = 5.7;
    static final double U_VALUE_WINDOW_DOUBLE_GLAZED = 3;
    static final double U_VALUE_FLOORS = 0.3;
    static final double TEMP_DIFFERENCE = 22;

    // outside walls length-side
    private static int lengthWalls;
    // outside walls width-side
    private static int widthWalls;

    // String messages
    static final String DISP_INV_INPUT = "Invalid input, enter an integer between 1 - %d";
    static final String DISP_INV_INPUT_2 = "Invalid input";

    public static void main(String[] args) {
        ArrayList<Double> totalEnergyRequiredRoom = new ArrayList<>();

        double totalEnergyPreviousRoom = 0;
        double combinedEnergyAllRooms;
        boolean anotherRoom = true;
        Scanner in = new Scanner(System.in);
        do {
            // WALL and WINDOW type selection
            double uValueWall = uValueWall();
            double uValueWindow = uValueWindow();

            System.out.println("Room height (meters): ");
            double height = getDouble();
            System.out.println("Room width (meters): ");
            double width = getDouble();
            System.out.println("Room length (meters): ");
            double length = getDouble();
            System.out.println("Window side a (meters): ");
            double windowSideA = getDouble();
            System.out.println("Window side b (meters): ");
            double windowSideB = getDouble();

            // Total outside walls
            outsideWalls();

            double areaOfWindow = windowSideA * windowSideB;
            double lengthSide = (length * height) * lengthWalls;
            double widthSide = (width * height) * widthWalls;

            double areaOfWalls = lengthSide + widthSide - areaOfWindow;
            double areaOfFloorOrCeiling = length * width;
            double heatLossToWindow = areaOfWindow * uValueWindow * TEMP_DIFFERENCE;
            double heatLossToWalls = areaOfWalls * uValueWall * TEMP_DIFFERENCE;
            double heatLossToFloor = areaOfFloorOrCeiling * U_VALUE_FLOORS * TEMP_DIFFERENCE;
            double totalEnergyRequired = heatLossToWalls + heatLossToWindow + heatLossToFloor;

            combinedEnergyAllRooms = totalEnergyRequired + totalEnergyPreviousRoom;
            totalEnergyRequiredRoom.add(totalEnergyRequired);

            System.out.println("Total energy required: " + totalEnergyRequired);

            totalEnergyPreviousRoom = combinedEnergyAllRooms;

            System.out.println("do you want to calculate heat-loss data for another room? (y/n)");
            String choice;
            boolean notValid = true;
            do {
                choice = in.nextLine();
                if (choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("n")) {
                    notValid = false;
                    if (choice.equalsIgnoreCase("n")) {
                        anotherRoom = false;
                    } else {
                        System.out.println(DISP_INV_INPUT_2);
                    }
                }
            } while (notValid);
        } while (anotherRoom);

        // printing the total energy loss for all the rooms separately;
        System.out.println("Total energy required: ");
        for (int j = 0; j < totalEnergyRequiredRoom.size(); j++) {
            System.out.println("Room " + j + ": " + totalEnergyRequiredRoom.get(j));
        }
        System.out.println("Total energy required (all rooms): " + combinedEnergyAllRooms);
        in.close();
    }

    // accept double input
    static double getDouble() {
        double returnValue;
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNextDouble()) {
            System.out.println(DISP_INV_INPUT_2);
            sc.nextLine();
        }
        returnValue = sc.nextDouble();
        return returnValue;
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
    static int wallType() {
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
    static double uValueWall() {
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
        return uValue;
    }

    // to read an integer and figure out the window type
    static int windowType() {
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
    static double uValueWindow() {
        double input = windowType();
        double uValue;
        if (input == 1) {
            uValue = U_VALUE_WINDOW_SINGLE_GLAZED;
        } else {
            uValue = U_VALUE_WINDOW_DOUBLE_GLAZED;
        }
        return uValue;
    }


    // outside walls and what side wall
    static void outsideWalls() {

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



