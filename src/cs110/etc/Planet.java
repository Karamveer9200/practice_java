package cs110.etc;

/*
feedback:
...
 */
import java.text.DecimalFormat;
import java.util.ArrayList;
// The Planet class
public class Planet {
    // planet's details
    private final String planetName;
    private final long correctionFactor;
    private final ArrayList<Moon> newMoon = new ArrayList<>();

    // Constructor to set the initial values for the planet
    Planet(String bodyName, long correction) {
        planetName = bodyName;
        correctionFactor = correction;
    }

    // Method to create and add a moon to the planet with only name and distance
    public void addMoon(String string, double number) {
        newMoon.add(new Moon(string, number));
    }

    // Method to create and add a moon to the planet with name, distance, mass, and diameter
    public void addMoon(String string, double number, double number2, double number3) {
        newMoon.add(new Moon(string, number, number2, number3));
    }

    // Private method to calculate the orbital period of a moon
    private String period(double base, long divisor) {
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        double result = Math.sqrt(Math.pow(base, 3)) / divisor;
        return decimalFormat.format(result);
    }

    // Method to find the closest moon to the planet
    public Moon closest() {
        if (newMoon.isEmpty()) {
            return null;
        }

        Moon closestMoon = newMoon.get(0);
        double minDistance = closestMoon.distance();

        for (int i = 1; i < newMoon.size(); i++) {
            Moon currentMoon = newMoon.get(i);
            double distance = currentMoon.distance();

            if (distance < minDistance) {
                minDistance = distance;
                closestMoon = currentMoon;
            }
        }

        return closestMoon;
    }

    // Method to find the furthest moon from the planet
    public Moon furthest() {
        if (newMoon.isEmpty()) {
            return null;
        }

        Moon furthestMoon = newMoon.get(0);
        double maxDistance = furthestMoon.distance();

        for (int i = 1; i < newMoon.size(); i++) {
            Moon currentMoon = newMoon.get(i);
            double distance = currentMoon.distance();

            if (distance > maxDistance) {
                maxDistance = distance;
                furthestMoon = currentMoon;
            }
        }

        return furthestMoon;
    }

    // Method to get a moon by its name
    public Moon getMoonByName(String name) {
        for (int i = 0; i < newMoon.size(); i++) {
            Moon obj = newMoon.get(i);
            if (name.equals(obj.name())) {
                return obj;
            }
        }
        return null;
    }

    // Method to generate a string representation of the planet and its moons
    public String toString() {
        String info = "Planet " + planetName + " has moons:\n";

        // Loop through each moon and gather information
        for (int i = 0; i < newMoon.size(); i++) {
            // Check if the moon has no diameter (assumed to be a basic moon)
            if (newMoon.get(i).diameter() == 0) {
                info += newMoon.get(i).name() + " is " + Math.round(newMoon.get(i).distance()) + " km from its planet"
                        + ", and orbits in " + period(newMoon.get(i).distance(), correctionFactor) + " days\n";
            } else {
                // If the moon has a diameter, provide more detailed information
                DecimalFormat decimalFormat = new DecimalFormat("#0.00");
                info += newMoon.get(i).name() + " is " + Math.round(newMoon.get(i).distance())
                        + " km from it's planet, orbits in " + period(newMoon.get(i).distance(), correctionFactor)
                        + " days, has a mass of " + newMoon.get(i).mass() + " * 10e15 kg,"
                        + " a diameter of " + Math.round(newMoon.get(i).diameter())
                        + " km, and a density of " + decimalFormat.format(newMoon.get(i).density()) + " g/cm^2 "
                        + "- it is probably " + newMoon.get(i).composition() + "\n";
            }
        }
        return info;
    }
}