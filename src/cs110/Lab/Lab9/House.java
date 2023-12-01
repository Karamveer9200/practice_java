package cs110.Lab.Lab9;

import java.util.ArrayList;
import java.util.Scanner;

public class House {
    private static ArrayList<Room> residency = new ArrayList<>();
    public static void main(String[] args) {
        double totalEnergyRequirement = 0;
        Scanner sc = new Scanner(System.in);
        ArrayList<Double> heatLossAllRooms = new ArrayList<>();
        int i = 0;
        boolean cont = true;
        do {
            Room types = new Room(i);
            residency.add(types);

            types.setName();
            types.setRoomDimensions();
            types.setWallType();
            types.setWindowType();
            types.heatLossFloorOrCeiling();
            types.heatLossCalc();
            heatLossAllRooms.add(types.heatLossCalc());
            System.out.println(types);
            i++;

            // if user want to calculate heat-loss for another room
            System.out.print("do you want to calculate heat-loss data for another room? (y/n): ");
            String choice;
            boolean notValid = true;
            while (notValid) {
                choice = sc.nextLine();
                if (choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("n")) {
                    notValid = false;
                    System.out.println(" ");
                    if (choice.equalsIgnoreCase("n")) {
                        cont = false;
                    }
                } else {
                    System.out.println("Invalid");
                }
            }

        } while (cont);

        // details of all the rooms
        int j = 0;
        for (Room all : residency) {
            System.out.println(all + " " + heatLossAllRooms.get(j)+"W");
            totalEnergyRequirement += heatLossAllRooms.get(j);
            j++;
        }
        System.out.println(" ");
        System.out.println("Total energy requirement: " + totalEnergyRequirement+"W");
    }
}
