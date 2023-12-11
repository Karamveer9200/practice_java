package cs110.Assessment.Assessment2.Level3;

/*
Response to the feedback:
I got 83 in coursework 1

Mistakes according to marking rubric:
1. Excessive commenting (wrote a comment after every line).
2. Structure was not proper (did not start form level 1, Hence made my code unnecessarily complicated).

My response:
1. Commented at the starting of important block, avoided useless commenting.
2. Started from Level 1, Hence the code is better structured and readable. It also helped me reduce the number
   of comments because now I don't have to explain my every step because code itself is easily readable now.
 */
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

    // adds a new moon object in the arraylist moon(with more parameters)
    public void addMoon(String name, double distance, double mass, double diameter) {
        moon.add(new Moon(name, distance, mass, diameter));
    }

   // returns the period(rounded)
    private String getPeriod(double distance, long correctionFactor) {
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        double period;

        period = Math.sqrt(distance * distance * distance) / correctionFactor;
        return decimalFormat.format(period);
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
        Moon closestMoon = moon.get(0);
        double closestDistance = closestMoon.getDistance();

        for (Moon currentMoon : moon) {
            double currentDistance = currentMoon.getDistance();
            if (currentDistance < closestDistance) {
                closestDistance = currentDistance;
                closestMoon = currentMoon;
            }
        }
        return closestMoon;
    }

    // returns the furthest moon object
    public Moon furthest() {
        Moon furthestMoon = moon.get(0);
        double furthestDistance = furthestMoon.getDistance();

        for (Moon currentMoon : moon) {
            double currentDistance = currentMoon.getDistance();
            if (currentDistance > furthestDistance) {
                furthestDistance = currentDistance;
                furthestMoon = currentMoon;
            }
        }
        return furthestMoon;
    }

    @Override
    public String toString() {
        String retString = "Planet " + name + " has moons:\n";
        for (Moon all : moon) {
            // when mass and diameter are 0 (not set)
            if (all.getMass().equals("0.00") && all.getDiameter() == 0) {
                retString = retString.concat(String.format("%s is %d km from its planet, and orbits in %s days%n",
                        all.getName(),
                        Math.round(all.getDistance()),
                        getPeriod(all.getDistance(), correctionFactor)));
            } else {
                DecimalFormat decimalFormat = new DecimalFormat("#0.00");
                retString = retString.concat(String.format("%s is %d km from it's planet, orbits in %s days,"
                                + " has a mass of %s * 10e15 kg, a diameter of %s km, and a density of %s g/cm^2 - "
                                + "it is probably %s%n",
                        all.getName(),
                        Math.round(all.getDistance()),
                        getPeriod(all.getDistance(), correctionFactor),
                        all.getMass(),
                        Math.round(all.getDiameter()),
                        decimalFormat.format(all.getDensity()),
                        all.getMoonType()));
            }

        }
        return retString;
    }
}
