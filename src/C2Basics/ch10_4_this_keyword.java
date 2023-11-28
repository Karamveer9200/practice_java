package C2Basics;

// 'this' keyword - is a way of us to reference an object of the class, which is being created/referenced.

// 'this.i' refers to the current objects which is calling a method
// i.e. when t.setValue(50) passed the value 50 to method setValue(int i), it also passed the reference of the object
// when 'this' keyword is applied to i, which means 'this.i' is referring to the instance variable i in the heap segment
// of the current object
class test {
    int i; // instance variable of class test

    // when instance variable and method parameter share the same variable name
    void setValue(int i) {
        // i below refers to 'local' variable
        // below, local variable is assigning value to itself, value of the instance variable i of object(t)
        // remains unchanged in the heap segment i.e. 0(default)
        //i = i;  // t.show() will return 0

        // this.i below refers to current 'instance' variable i, present in the heap segment of the object
        // with reference variable t.
        this.i=i; // t.show() will return 50 the new value of i, passed as an argument from object t in the main method
    }

    void show() {
        System.out.println(i);
    }
}
public class ch10_4_this_keyword {
    public static void main(String[] args) {
        test t = new test();
        t.setValue(50);
        t.show();
    }
}
