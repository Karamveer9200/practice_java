package cs110.Lab.Lab9;

import java.util.ArrayList;
import java.util.Scanner;

class Room {
    private final int id;
    private String name;
    private double length;
    private double width;
    private double height;

    private final ArrayList<OutsideWall> outsideWalls = new ArrayList<>();
    private final ArrayList<Window> roomWindows = new ArrayList<>();

    private static final double U_VALUE_FLOORS = 0.3;
    private static final int TEMP_DIFFERENCE = 22;

    private static double totalHeatLossWalls = 0;
    private static double totalHeatLossFloorOrCeiling = 0;
    private static double totalHeatLoss;

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
            i++;
        }
    }

    // to set the wall type, dimensions
    public void setWallType() {
        double totalWallLength= 0;
        double periphery = 2 * length + 2 * width;
        int totalWalls;
        double uValuePlusTempDiff = 0;
        double heatLossWalls = 0;

        System.out.print("Total walls <max 4> : ");
        totalWalls = getInt();

        for (int i = 0; i < totalWalls; i++) {
            OutsideWall wall = new OutsideWall(i);
            outsideWalls.add(wall);
            outsideWalls.get(i).uValueWall();
            outsideWalls.get(i).setDimensions(height, periphery, totalWallLength);
            totalWallLength= outsideWalls.get(i).getLength();
        }

        for (OutsideWall all : outsideWalls) {
            uValuePlusTempDiff += all.getUValue() * all.getTempDiff();
        }
        totalHeatLossWalls = (OutsideWall.getTotalAreaOutsideWalls() - Window.getTotalAreaWindows())
                * uValuePlusTempDiff;
    }

    void heatLossFloorOrCeiling() {
        // area calculation
        double areaOfFloorOrCeiling = length * width;
        // heat-loss calculation
        totalHeatLossFloorOrCeiling = areaOfFloorOrCeiling * U_VALUE_FLOORS * TEMP_DIFFERENCE;
    }

    // total heat-loss
    public double totalHeatLoss() {
        totalHeatLoss = totalHeatLossWalls + Window.getTotalHeatLossWindows() + totalHeatLossFloorOrCeiling;
        return totalHeatLoss;
    }

    @Override
    public String toString() {
        return "Total energy requirement of " + name + " is " + totalHeatLoss + "W";
    }

    public String toString2() {
        return "Total energy requirement of " + name + " is ";
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


