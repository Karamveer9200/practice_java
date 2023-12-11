package cs110.etc;

/*
feedback:
...
 */
import java.text.DecimalFormat;
import java.util.ArrayList;
public class Planet {
    private final String name;
    private final long correctionFactor;
    private final ArrayList<Moon> object = new ArrayList<>();

   // ...
    Planet(String bodyName, long cf) {
        name = bodyName;
        correctionFactor = cf;
    }

   // ...
    public void addMoon(String name, double distanceFromEarth) {
        object.add(new Moon(name, distanceFromEarth));
    }

    // adds a new moon object in the arraylist moon(with more parameters)
    public void addMoon(String bodyName, double distance, double mass, double diameter) {
        object.add(new Moon(bodyName, distance, mass, diameter));
    }

   // ...
    private String getPeriod(double distance, long correctionFactor) {
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");
        double periodCalc;

        periodCalc = Math.sqrt(distance * distance * distance) / correctionFactor;
        return decimalFormat.format(periodCalc);
    }

    // ...
    public Moon closest() {
        Moon moon = object.get(0);
        double distance = object.get(0).getDistance();
        for (int i = 1; i < object.size(); i++) {
            if (object.get(i).getDistance() < distance) {
                distance = object.get(i).getDistance();
                moon = object.get(i);
            }
        }
        return moon;
    }

    // ...
    public Moon furthest() {
        Moon moon = object.get(0);
        double distance = object.get(0).getDistance();
        for (int i = 1; i < object.size(); i++) {
            if (object.get(i).getDistance() > distance) {
                distance = object.get(i).getDistance();
                moon = object.get(i);
            }
        }
        return moon;
    }

    // ...
    public Moon getMoonByName(String name) {
        for (int i = 0; i < object.size(); i++) {
            Moon all = object.get(i);
            if (name.equals(all.getName())) {
                return all;
            }
        }
        return null;
    }

    public String toString() {
        String string = "Planet " + name + " has moons:\n";
        for (int i = 0; i < object.size(); i++) {
            if (object.get(i).getMass().equals("0.00") && object.get(i).getDiameter() == 0) {
                string += object.get(i).getName() + " is " + Math.round(object.get(i).getDistance())
                        + " km from its planet, and orbits in "
                        + getPeriod(object.get(i).getDistance(), correctionFactor) + " days\n";
            } else {
                DecimalFormat decimalFormat = new DecimalFormat("#0.00");
                string += object.get(i).getName() + " is " + Math.round(object.get(i).getDistance())
                        + " km from it's planet, orbits in "
                        + getPeriod(object.get(i).getDistance(), correctionFactor) + " days, has a mass of "
                        + object.get(i).getMass() + " * 10e15 kg, a diameter of " + Math.round(object.get(i).getDiameter())
                        + " km, and a density of " + decimalFormat.format(object.get(i).getDensity())
                        + " g/cm^2 - it is probably "
                        + object.get(i).getBodyType() + "\n";
            }

        }
        return string;
    }
}
