package C2_OOPS_and_Basics;

// Specifier where a property/method id accessible,
// there are four types of access modifiers in JAVA:
//1> Private
//1> Default
//1> Protected
//1> Public

// Getters and Setters
// Getter --> Returns the Value      [accessors]
// Setter --> Sets/Updates the Value [mutators]

class MyEmployee{
    private int id; //'Private' variable cannot be accessed outside the class with '.'(dot) operator
                    // it needs a getter to access and setter to assign a value
    private String name;
    // getters and setter make our life easy
    // They act as a checkpoints to access or modify the private variables

    // setters(use-case) - suppose we have conditions, when we enter a name, like it should not contain numbers
    // it should be in upper case or lowercase, etc. So. setters will only pass the value if the
    // conditions are fulfilled.

    // getters(use-case) - suppose we want to implement a password, Getters will only the display the value
    // if the password is correct.

    public int getId(){ // Getter
        return id;
        //return this.id; // also correct
    }
    public String getName(){
        return name;
    }
    public void setId(int a){ // Setter
        this.id = a;
        // id = a; //also correct
    }
    public void setName(String a){
        this.name = a;
    }

}
public class ch9_access_modifiers__getters_and_setters {
    public static void main(String[] args) {
        MyEmployee harry = new MyEmployee();
        harry.setId(420); // setter
        System.out.println("id is   : "+harry.getId()); // getter
        harry.setName("Haris Babu");
        System.out.println("name is : "+harry.getName());
    }
}
