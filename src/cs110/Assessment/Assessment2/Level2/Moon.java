package cs110.Assessment.Assessment2.Level2;

public class Moon {
    private final String name;
    private final double distance;

    // constructor to assign name and distance
    Moon(String name, double distance) {
        this.name = name;
        this.distance = distance;
    }

    // returns the name
    public String getName() {
        return name;
    }

    // returns to distance
    public double getDistance() {
        return distance;
    }

    // compares the name and distance of two moons
    public boolean equals(Moon moon) {
        return moon.getName().equals(this.name) && (moon.getDistance() == this.distance);
    }
}
