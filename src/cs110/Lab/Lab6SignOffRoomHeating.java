package cs110.Lab;

import java.util.Scanner;
import java.util.ArrayList;

public class Lab6SignOffRoomHeating {
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

        public static void main(String[] args) {
            ArrayList<Double> totalEnergyRequiredRoom = new ArrayList<>();

            double totalEnergyPreviousRoom = 0;
            double combinedEnergyAllRooms = 0;
            boolean anotherRoom = true;
            Scanner in = new Scanner(System.in);
            int i = 1;
            do {
                // WALL and WINDOW type selection
                double uValueWall = uValueWall();
                double uValueWindow = uValueWindow();

                System.out.println("Room height (meters): ");
                // checks for legal double
                while (!in.hasNextDouble()) {
                    in.nextLine();
                }
                double height = in.nextFloat();
                System.out.println("Room width (meters): ");
                double width = in.nextFloat();
                System.out.println("Room length (meters): ");
                double length = in.nextFloat();
                System.out.println("Window side a (meters): ");
                double windowSideA = in.nextFloat();
                System.out.println("Window side b (meters): ");
                double windowSideB = in.nextFloat();

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
                            System.out.println("Invalid input");
                        }
                        // incrementing the value of i
                        i++;
                    }
                } while (notValid);
            } while (anotherRoom);

            // printing the total energy loss for all the rooms separately;
            System.out.println("Total energy required: ");
            for (int j = 0; j < totalEnergyRequiredRoom.size(); j++) {
                System.out.println("Room "+ j +": "  + totalEnergyRequiredRoom.get(j));
            }
            System.out.println("Total energy required (all rooms): " + combinedEnergyAllRooms);
        }

        // to figure out the type of wall and its U value
        static double uValueWall() {
            System.out.println("Select the wall type:");
            System.out.println("1. Solid");
            System.out.println("2. Cavity No insulation");
            System.out.println("3. Cavity + Insulated");
            Scanner sc = new Scanner(System.in);

            double uValue = 0;
            boolean inputNotValid = true;
            while (inputNotValid) {
                while (!sc.hasNextInt()) {
                    System.out.println("Invalid input, enter an integer between 1 - 2");
                    sc.nextLine();
                }
                int a = sc.nextInt();
                if (a == 1) {
                    uValue = U_VALUE_WALL_SOLID;
                    inputNotValid = false;
                } else if (a == 2) {
                    uValue = U_VALUE_WALL_NO_INSULATION;
                    inputNotValid = false;
                } else if (a == 3) {
                    uValue = U_VALUE_WALL_INSULATED;
                    inputNotValid = false;
                } else {
                    System.out.println("Invalid input, enter an integer between 1 - 3");
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
                while (!sc.hasNextInt()) {
                    System.out.println("Invalid input, enter an integer between 1 - 2");
                    sc.nextLine();
                }
                int a = sc.nextInt();
                if (a == 1) {
                    uValue = U_VALUE_WINDOW_SINGLE_GLAZED;
                    flag = false;
                } else if (a == 2) {
                    uValue = U_VALUE_WINDOW_DOUBLE_GLAZED;
                    flag = false;
                } else {
                    System.out.println("Invalid input, enter an integer between 1 - 2");
                }
            }
            return uValue;
        }

        // outside walls and what side wall
        static void outsideWalls() {
            Scanner sc = new Scanner(System.in);
            System.out.println("Total outside walls: ");
            int totalWalls = sc.nextInt();
            boolean notValid = true;
            int lengthSideWalls;

            if (totalWalls >= 1 && totalWalls <= 4) {
                switch (totalWalls) {
                    case 1:
                        System.out.println("Total length-side walls: ");
                        do {
                            lengthSideWalls = sc.nextInt();
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
                            lengthSideWalls = sc.nextInt();
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
                            lengthSideWalls = sc.nextInt();
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
                System.out.println("Invalid input");
                outsideWalls();
            }
        }
    }


