package cs110.etc;

import java.text.DecimalFormat;

// The Moon class
public class Moon {
    // moon's private details
    private String moonName;
    private double distanceFromEarth;
    private double radius;
    private double mass;
    private double diameter;
    private double density;

    // oon name and distance introduction method
    public Moon(String name, double distance) {
        // Assigning the moon's name and distance
        moonName = name;
        distanceFromEarth = distance;
    }

    // more detailed moon introduction method
    public Moon(String name, double distance, double moonMass, double moonDiameter) {
        // Assigning the moon's name, distance, mass, and diameter
        moonName = name;
        distanceFromEarth = distance;
        mass = moonMass;
        diameter = moonDiameter;
        radius = diameter/2;

        // math to find the density
        density = mass / (Math.PI * 4/3f * (radius * radius * radius)) * 10e2;
    }

    // This method gives you the moon's name
    public String name() {
        return moonName;
    }

    // This method gives you the moon's distance
    public double distance() {
        return distanceFromEarth;
    }

    // This method gives you the moon's mass with only two decimal places
    public String mass() {
        String value;
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        value = decimalFormat.format(mass);
        return value;
    }

    // This method gives you the moon's diameter
    public double diameter() {
        return diameter;
    }

    // This method gives you the moon's density
    public double density() {
        return density;
    }

    // This method tells you if the moon is mostly ice, rock, or a mix
    public String composition() {
        final double iceThreshold = 0.9;
        final int rockThreshold = 2;
        double currentDensity = density();
        String type = null;

        // To figure out the type based on the density
        if (currentDensity < iceThreshold) {
            type = "mostly ice";
        } else if (currentDensity > rockThreshold) {
            type = "mostly rock";
        } else if (currentDensity > iceThreshold && currentDensity < rockThreshold) {
            type = "a mix of rock and ice";
        }
        return type;
    }

    // This method checks if two moons are the same based on name and distance
    public boolean equals(Moon otherMoon) {
        boolean isEqual = false;
        // If the names and distances are the same, then the moons are equal
        if (otherMoon.name().equals(moonName) && (otherMoon.distance() == distanceFromEarth)) {
            isEqual = true;
        }
        return isEqual;
    }
}
