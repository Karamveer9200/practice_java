package C2Basics;
// inheritance = Pitaji & Mataji
// Inheritance is used to BORROW 'properties' & 'methods'
// from an 'existing class'

// Phone       --> Smart-Phone
// Super-Class --> Sub-Class    (Sub-Class 'extends' Super-class)

// Animal(base)
class superclass{
    private String name;
    public int salary; // 'private' 'salary' will not be accessible subclass

    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

// Dog(derived)
class subclass extends superclass{ // used keyword 'extends' to derive to inherit
                                   // properties of superclass
// Barking(function)
    public int getIncrement() {   // method inherited the attribute 'salary' from the superclass
        return salary+10000;
    }

}
public class ch10_0_inheritance_01 {
    public static void main(String[] args) {

        // creating an object of subclass
        subclass harry = new subclass();
        // method derived from superclass
        harry.setName("Haris Babu");// dot'.' operator to go into elements of a class
        harry.setSalary(33000);
        System.out.println("Name            "+harry.getName());
        System.out.println("Base salary     "+harry.getSalary());
        // method from subclass
        System.out.println("After increment "+harry.getIncrement());
    }
}

// JAVA does not support multiple inheritance i.e. two classes cannot
// be superclass for a subclass (one father only)
