package beginning.oops.basics;
// A member function used to initialize an object while creating it.

// In order write our own constructor, we define a method wtih the
// 'same name' as class name.

class Employee2{
    private int id;
    private int salary;
    private String name;

    // constructors are initiated at the time of class object creation
    //constructor 1
    public Employee2(){ // do not use void
      // these are now the default values

        id=420;
        name="(initial name) no name";
        salary = 10000;
    }

    // Constructor overloading
    // same as method overloading
    //constructor 2
    public Employee2(int a, String n){ // if we don't pass any arguments at the time of object creation
                                       // values of the above constructor will be set a default
        id = a;
        name = n;
        // here salary will be default i.e 0
    }
    public Employee2(int a, String n, int s){
        id = a;
        name = n;
        salary = s;
    }
    // in this example, we are not using any setters
    // values will be passed though the constructor arguments

    public int getId() {
        return id;
    }
    public String getName(){
        return name;
    }
    public int getSalary() {
        return salary;
    }
}
public class ch9_constructors {
    public static void main(String[] args) {
        //Employee2 harry = new Employee2(); // no arguments passed, constructor 1 will be initialized
        Employee2 harry = new Employee2(25, "Haris Babu"); // arguments passed constructor 2 will be implemented
        System.out.println(harry.getId());
        System.out.println(harry.getName());
        System.out.println(harry.getSalary());
    }
}
