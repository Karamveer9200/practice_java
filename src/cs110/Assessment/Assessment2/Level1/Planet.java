package cs110.Assessment.Assessment2.Level1;

import java.util.ArrayList;
import java.text.DecimalFormat;
public class Planet {
    private String name;
    private long correctionFactor;
    private ArrayList<Moon> moon = new ArrayList<>();

    Planet(String name, long correctionFactor) {
        this.name = name;
        this.correctionFactor = correctionFactor;
    }

    public void addMoon(String name, double distance) {
        moon.add(new Moon(name, distance));
    }

    private String getPeriod(double distance, long correctionFactor) {
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        double round;
        int decimalPlaces = 2;

        round = Math.sqrt(distance * distance * distance) / correctionFactor;
        return decimalFormat.format(round);
        // return Math.round(round* Math.pow(10, decimalPlaces)) / Math.pow(10, decimalPlaces);
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
