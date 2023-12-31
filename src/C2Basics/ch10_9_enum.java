package C2Basics;
// enum stands for enumerated type
// enum is a collection of constants
// enum are similar to classes, but they can have instance variables
enum Planets {
    // enum constants
    MERCURY(3.303e+23, 2.4397e6),
    VENUS(4.869e+24, 6.0518e6),
    EARTH(5.976e+24, 6.37814e6),
    MARS(6.421e+23, 3.3972e6),
    JUPITER(1.9e+27, 7.1492e7),
    SATURN(5.688e+26, 6.0268e7),
    URANUS(8.686e+25, 2.5559e7),
    NEPTUNE(1.024e+26, 2.4746e7);

    // instance variables
    private final double mass;
    private final double radius;
    Planets(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
    }
    public double mass() {
        return mass;
    }
    public double radius() {
        return radius;
    }
}
public class ch10_9_enum {
    public static void main(String[] args) {
        Planets earth = Planets.EARTH;
        System.out.println(earth.mass()+"kg");
        System.out.println(earth.radius()+"km");

        Planets jupiter = Planets.JUPITER;
        System.out.println(jupiter.mass()+"kg");
        System.out.println(jupiter.radius()+"km");
    }
}
