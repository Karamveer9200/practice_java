package C2Basics;
// DRY - Do Not Repeat Yourself

// Any real world object = Properties + Behavior
//     Object in OOPs    = Attributes + Methods

// properties/Attributes       (phone) - color, material, shape
// Behavior/Methods/Functions  (phone) - calculator, camera, calling, running apps
 class Employee{ // if we make this class 'public', it will become a different.java file
    int id; // attribute 1 (property)
    int salary;
    String name; // attribute 2 (property)

    public void printDetails(){ // method 1 (behaviour)
        System.out.println("My is id "+ id);
        System.out.println("My name is "+ name);
    }
    public int getSalary(){ // method 2 (behaviour)

        return salary*1000;
    }
}

public class ch8_OOPs_01_class_and_object_creation {
    public static void main(String[] args) {
        System.out.println("This is our custom class");

        // Instantiating a new Employee Object

        //Employee harry;
        //harry = new Employee();        // same thing as below

        Employee harry = new Employee(); // LHS(reference) = RHS(object)
        Employee ram = new Employee();   // an object is created even without a reference (computer knows its location)
                                         // we create a reference to use the object later (like a home address to send and receive mail)

        // Setting attributes for Harry
        harry.id = 12;
        harry.name = "Haris Babu";
        harry.salary = 33;

        // Setting attributes for Harry
        ram.id = 55;
        ram.name = "Ramlal";
        ram.salary = 12;

        // Printing Attributes

        //System.out.println(harry.id);
        //System.out.println(harry.name);
        harry.printDetails();// called method 1
        int salary_h = harry.getSalary(); // called method 2
        System.out.println("Salary is : " +salary_h);

        ram.printDetails();
        int salary_r = ram.getSalary();
        System.out.println("Salary is : " +salary_r);

    }
}
