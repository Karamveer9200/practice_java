package cs110.Lab;
import java.util.Scanner;

public class Lab3RoomHeating01 {
    static final double U_VALUE_WALLS = 0.5;
    static final double U_VALUE_FLOORS = 0.3;
    static final double U_VALUE_WINDOWS = 3;
    static final double TEMP_DIFFERENCE = 22;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Room height (meters): ");
        double height = 2;//in.nextFloat();
        System.out.println("Room width (meters): ");
        double width = 3;//in.nextFloat();
        System.out.println("Room length (meters): ");
        double length = 4;//in.nextFloat();
        System.out.println("Window side a (meters): ");
        double windowSideA = 1;//in.nextFloat();
        System.out.println("Window side b (meters): ");
        double windowSideB = 1.5;//in.nextFloat();


        double areaOfWindow = windowSideA * windowSideB;
        double areaOfWalls =  length*height + width*height - areaOfWindow;
        double areaOfFloor_Ceiling = length * width;
        double heatLossToWindow = areaOfWindow * U_VALUE_WINDOWS * TEMP_DIFFERENCE;
        double heatLossToWalls = areaOfWalls * U_VALUE_WALLS * TEMP_DIFFERENCE;
        double heatLossToFloor = areaOfFloor_Ceiling * U_VALUE_FLOORS * TEMP_DIFFERENCE;
        double totalEnergyRequired = heatLossToWalls + heatLossToWindow + heatLossToFloor;

        System.out.println("Total energy required: "+ totalEnergyRequired);

    }

}
