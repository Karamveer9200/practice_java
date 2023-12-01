package cs110.Lab.Lab9;

import java.util.ArrayList;
import java.util.Scanner;

class Room {
    private int id;
    private String name;
    private double length;
    private double width;
    private double height;

    private OutsideWall[] outsideWalls = new OutsideWall[1];
    private ArrayList<Window> roomWindows = new ArrayList<>();

    private static final double U_VALUE_FLOORS = 0.3;
    private static final int TEMP_DIFFERENCE = 22;

    private static double totalHeatLossWindows = 0;
    private static double totalHeatLossWalls = 0;
    private static double totalHeatLossFloorOrCeiling = 0;

    private static double totalHeatLoss;

    private static double totalAreaWindows = 0;


    // string messages
    private static final String DISP_INV_INPUT_2 = "Invalid input";

    private Scanner sc = new Scanner(System.in);

    // constructor for making objects with a loop
    Room(int id) {
        this.id = id;
    }

    // set name
    public void setName() {
        System.out.print("Room name: ");
        name = sc.next();
    }

    // setting the room dimensions
    public void setRoomDimensions() {
        // Room, Wall dimensions
        System.out.print("Room height (meters): ");
        height = getDouble();
        System.out.print("Room width  (meters): ");
        width = getDouble();
        System.out.print("Room length (meters): ");
        length = getDouble();
    }

    public void setWindowType() {
        int totalWindows;

        System.out.print("Total windows: ");
        totalWindows = getInt();

        for (int i = 0; i < totalWindows; i++) {
            Window allWindow = new Window(i);
            roomWindows.add(allWindow);

        }
        int i = 0;
        for (Window all : roomWindows) {
            all.uValueWindow(i);
            all.setDimensions(height, i);
            totalAreaWindows += all.getAreaOfWindow();
            totalHeatLossWindows += all.totalHeatLossWindow();
            i++;
        }

    }

    public void setWallType() {
        OutsideWall wall1 = new OutsideWall();
        outsideWalls[0] = wall1;

        outsideWalls[0].uValueWall();
        outsideWalls[0].setDimensions(height, width, length);
        outsideWalls[0].outsideWalls();
        totalHeatLossWalls = outsideWalls[0].heatLossWalls(totalAreaWindows);
    }

    void heatLossFloorOrCeiling() {
        // area calculation
        double areaOfFloorOrCeiling = length * width;
        // heat-loss calculation
        totalHeatLossFloorOrCeiling = areaOfFloorOrCeiling * U_VALUE_FLOORS * TEMP_DIFFERENCE;
    }

    public double heatLossCalc() {
        totalHeatLoss = totalHeatLossWalls + totalHeatLossWindows + totalHeatLossFloorOrCeiling;
        return totalHeatLoss;
    }

    @Override
    public String toString() {
        return "Total energy requirement of " + name + " is " + totalHeatLoss+"W";
    }

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


