package cs110.Lab.Lab8.signOff;

import java.util.Scanner;
import java.util.ArrayList;

public class Lab8SignOffRoomHeating {
    static final double U_VALUE_FLOORS = 0.3;
    static final double TEMP_DIFFERENCE = 22;

    // String messages
    static final String DISP_INV_INPUT_2 = "Invalid input";

    // main method

    public static void main(String[] args) {
        ArrayList<Double> totalEnergyRequiredRoom = new ArrayList<>();

        double totalEnergyPreviousRoom = 0;
        double combinedEnergyAllRooms;
        boolean anotherRoom = true;

        OutsideWall walls = new OutsideWall();
        Window window = new Window();

        Scanner in = new Scanner(System.in);
        do {
            // WALL and WINDOW type selection
             walls.uValueWall();
             window.uValueWindow();

            System.out.println("Room height (meters): ");
            double height = getDouble();
            System.out.println("Room width (meters): ");
            double width = getDouble();
            System.out.println("Room length (meters): ");
            double length = getDouble();
            System.out.println("Window side a (meters): ");
            double sideA = getDouble();
            System.out.println("Window side b (meters): ");
            double sideB = getDouble();

            // Total outside walls
            walls.outsideWalls();

            // area calculation
            walls.areaOfWalls(length, height, width, window.areaOfWindow(sideA, sideB));
            window.areaOfWindow(sideA, sideB);
            double areaOfFloorOrCeiling = length * width;

            // heat-loss calculation
            double heatLossToFloor = areaOfFloorOrCeiling * U_VALUE_FLOORS * TEMP_DIFFERENCE;
            double totalEnergyRequired = walls.heatLossWalls() + window.totalHeatLossWindow()
                    + heatLossToFloor;

            combinedEnergyAllRooms = totalEnergyRequired + totalEnergyPreviousRoom;
            totalEnergyRequiredRoom.add(totalEnergyRequired);

            System.out.println("Total energy required: " + totalEnergyRequired);

            totalEnergyPreviousRoom = combinedEnergyAllRooms;

            // if user want to calculate heat-loss for another room
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
}



