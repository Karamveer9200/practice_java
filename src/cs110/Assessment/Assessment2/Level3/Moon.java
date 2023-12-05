package cs110.Assessment.Assessment2.Level3;

import java.text.DecimalFormat;
import java.util.Objects;

public class Moon {
    private final String name;
    private final double distance;
    private double mass = 0;
    private double diameter = 0;


    // constructor to assign name and distance
    Moon(String name, double distance) {
        this.name = name;
        this.distance = distance;
    }

    // constructor to assign name, distance, mass and diameter
    Moon(String name, double distance, double mass, double diameter) {
        this.name = name;
        this.distance = distance;
        this.mass = mass;
        this.diameter = diameter;
    }

    // returns the name
    public String getName() {
        return name;
    }

    // returns distance
    public double getDistance() {
        return distance;
    }

    // returns mass(rounded)
    public String getMass() {
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        return decimalFormat.format(mass);
    }

    // returns diameter
    public double getDiameter() {
        return diameter;
    }

    // returns moon density
    public double getDensity() {
        double radius = diameter / 2;
        final double multiplier = 4/3f;
        final double multiplier2 = 10E2;

        return mass/(Math.PI * multiplier * (radius * radius * radius)) * multiplier2;
    }

    // returns the moon type
    public String getMoonType() {
        final double densityForIce = 0.9;
        final double densityForRock = 2.0;
        String retVal = null;

        if (getDensity() < densityForIce) {
           retVal = "mostly ice";
        } else if (getDensity() > densityForRock) {
            retVal = "mostly rock";
        } else if (getDensity() >= densityForIce && getDensity() <= densityForRock) {
            retVal = "a mixture of rock and ice";
        }
        return retVal;
    }


    // compares the name and distance of two moons
   @Override
    public boolean equals(Object obj) {
        // checking the class of the parameter
       if (obj == null || getClass() != obj.getClass()) {
           return false;
       }
       Moon moon = (Moon) obj;
       return moon.getName().equals(this.name) && (moon.getDistance() == this.distance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, distance);
    }
}
