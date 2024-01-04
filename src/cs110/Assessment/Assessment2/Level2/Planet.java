package cs110.Assessment.Assessment2.Level2;

import java.text.DecimalFormat;
import java.util.ArrayList;
public class Planet {
    private final String name;
    private final long correctionFactor;
    private final ArrayList<Moon> moon = new ArrayList<>();

   // constructor to assign name and correctionFactor
    Planet(String name, long correctionFactor) {
        this.name = name;
        this.correctionFactor = correctionFactor;
    }

   // adds a new moon object in the arraylist moon
    public void addMoon(String name, double distance) {
        moon.add(new Moon(name, distance));
    }

   // returns the period
    private String getPeriod(double distance, long correctionFactor) {
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        double round;
        int decimalPlaces = 2;

        round = Math.sqrt(distance * distance * distance) / correctionFactor;
        return decimalFormat.format(round);
    }

   // returns the moon object whose name matches the String argument
    public Moon getMoonByName(String name) {
    for (Moon all : moon) {
        if (name.equals(all.getName())) {
            return all;
        }
    }
    return null;
    }

    // returns the closest moon object
    public Moon closest() {
        Moon closest = moon.get(0);
        double closestDistance = moon.get(0).getDistance();
        for (int i = 1; i < moon.size(); i++) {
            if (moon.get(i).getDistance() < closestDistance) {
                closestDistance = moon.get(i).getDistance();
                closest = moon.get(i);
            }
        }
        return closest;
    }

    // returns the furthest moon object
    public Moon furthest() {
        Moon furthest = moon.get(0);
        double furthestDistance = moon.get(0).getDistance();
        for (int i = 1; i < moon.size(); i++) {
            if (moon.get(i).getDistance() > furthestDistance) {
                furthestDistance = moon.get(i).getDistance();
                furthest = moon.get(i);
            }
        }
        return furthest;
    }

    @Override
    public String toString() {
        String retString = "Planet " + name + " has moons:\n";
        for (Moon all : moon) {
            retString += all.getName() + " is " + Math.round(all.getDistance()) + " km from its planet, and orbits in "
                    + getPeriod(all.getDistance(), correctionFactor)  + " days\n";

        }
        return retString;
    }

}
