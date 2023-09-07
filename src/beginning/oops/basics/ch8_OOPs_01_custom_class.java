package beginning.oops.basics;
// DRY - Do Not Repeat Yourself

// Any real world object = Properties + Behavior
//     Object in OOPs    = Attributes + Methods

// properties/Attributes       (phone) - color, material, shape
// Behavior/Methods/Functions  (phone) - calculator, camera, calling, running apps
class Employee{
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

public class ch8_OOPs_01_custom_class { // only one class can be 'PUBLIC'
    public static void main(String[] args) {
        System.out.println("This is our custom class");
        Employee harry = new Employee(); // Instantiating a new Employee Object
        Employee ram = new Employee();

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
