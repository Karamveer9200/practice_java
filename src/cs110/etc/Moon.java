package cs110.etc;

import java.text.DecimalFormat;

public class Moon {
    private final String name;
    private final double distance;
    private double mass;
    private double diameter;

    // ...
    public Moon(String bodyName, double distanceFromEarth) {
        name = bodyName;
        distance = distanceFromEarth;
    }

    // ...
    public Moon(String bodyName, double distanceFromEarth, double ms, double dmtr) {
        name = bodyName;
        distance = distanceFromEarth;
        mass = ms;
        diameter = dmtr;
    }

    // ...
    public String getName() {
        return name;
    }

    // ...
    public double getDistance() {
        return distance;
    }

    // ...
    public String getMass() {
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        return decimalFormat.format(mass);
    }

    // ...
    public double getDiameter() {
        return diameter;
    }

    // ...
    public double getDensity() {
        double radius = diameter / 2;
        final double fourByThree = 4/3f;
        final double tenE2 = 10E2;
        double density = mass / (Math.PI * fourByThree * (radius * radius * radius)) * tenE2;

        return density;
    }

    // ...
    public String getBodyType() {
        final double ice = 0.9;
        final double rock = 2;
        String bodyType = null;

        if (getDensity() < ice) {
            bodyType = "mostly ice";
        } else if (getDensity() > rock) {
            bodyType = "mostly rock";
        } else if (getDensity() >= ice && getDensity() <= rock) {
            bodyType = "a mixture of rock and ice";
        }
        return bodyType;
    }

    // ...
    public boolean equals(Moon celestialBody) {
        return celestialBody.getName().equals(name) && (celestialBody.getDistance() == distance);
    }
}