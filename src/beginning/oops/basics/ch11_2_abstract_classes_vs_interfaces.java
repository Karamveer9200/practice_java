package beginning.oops.basics;
// abstract class - 'only one' abstract class can be inherited by a subclass
// interface - 'multiple interfaces' can be implemented by a class


// interface 1
interface featuresBicycle {
    void brake();
    void shiftGear();
}


// interface 2
interface HornBicycle{
    void horn1();
    void horn2();
}

class hero implements featuresBicycle,HornBicycle{
//class hero extends bicycleInfo implements featuresBicycle,HornBicycle{
// a class can extend another class at the same time implementing interfaces

    // Implementing Interface1
    @Override
    public void brake() {
        System.out.println("Brake");
    }

    @Override
    public void shiftGear() {
        System.out.println("Shifting gear");
    }

    // Implementing Interface 2
    @Override
    public void horn1() {
        System.out.println("Normal horn");
    }

    @Override
    public void horn2() {
        System.out.println("Musical horn");
    }
}

public class ch11_2_abstract_classes_vs_interfaces {
    public static void main(String[] args) {
        hero classic = new hero();
        classic.shiftGear();
        classic.horn2();
    }
}
class bicycleInfo{
    String tyreBrand = "MRF";
    int model = 2023;
}
