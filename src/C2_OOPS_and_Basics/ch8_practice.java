package C2_OOPS_and_Basics;

//----------------------------------------------------------
// practice 1 - class Employee1 with the following properties and methods
// Salary(property)(int)
// getSalary(method returning int)
// name(property)(String)
// getName(method returning String)
// setName(method changing name)

//class Employee1 { // cannot create a class with similar name in this package OOPs_java.basic
//    int Salary;
//    String name;
//    public int getSalary(){
//        return Salary;
//    }
//    public String getName(){
//        return name;
//    }
//    public void setName(String n){
//        name = n;
//    }
//}
//public class ch8_practice {
//    public static void main(String[] args) {
//        Employee1 harry = new Employee1();
//        harry.setName("Haris Babu");
//        harry.Salary = 12000;
//        System.out.println(harry.getName());
//        System.out.println(harry.getSalary());
//
//    }
//}

//----------------------------------------------------------
// practice 2 - class cellphone with methods to print
// "ringing...", " vibrating..." etc

//class cellphone{
//        public void ring(){
//            System.out.println("Ringing...");
//        }
//        public void vib(){
//            System.out.println("Vibrating...");
//        }
//        public void callFriend(){
//            System.out.println("Calling boot...");
//        }
//    }
//public class ch8_practice { // main function inside public class
//        public static void main(String[] args) {
//            cellphone apple = new cellphone();
//            apple.ring();
//            apple.vib();
//            apple.callFriend();
//        }
//}

//----------------------------------------------------------
// practice 3 - class square with method to initialize its
//              side, calculating area, perimeter etc.

//import java.util.Scanner;
//class Rectangle{
//    public void area(float a, float b){
//        System.out.println("area is :" +(a * b)+" m sq");
//    }
//    public void perimeter(float a, float b){
//        System.out.println("Perimeter is :" + ((a*2)+(b*2))+" m");
//    }
//}
//public class ch8_practice {
//    public static void main(String[] args) {
//        float x,y;
//        Scanner side = new Scanner(System.in);
//        System.out.println("Enter height in m ");
//        y = side.nextFloat();
//        System.out.println("Enter width in  m ");
//        x = side.nextFloat();
//        Rectangle calc = new Rectangle();
//        calc.area(x,y);
//        calc.perimeter(x,y);
//    }
//}

//----------------------------------------------------------
// practice 4 - class TommyVercetti for a game company
//              capable of hitting(print hit...), running, firing etc.

class TommyVercetti{
    public void hit(){
        System.out.println("hit...");
    }
    public void walk() {
        System.out.println("walking...");
    }
        public void run() {
            System.out.println("running...");
    }
    public void wepAim() {
        System.out.println("aiming the weapon...");
    }
}
public class ch8_practice {
    public static void main(String[] args) {
        TommyVercetti player1 = new TommyVercetti();
        player1.hit();
        player1.walk();
        player1.run();
        player1.wepAim();
    }
}


