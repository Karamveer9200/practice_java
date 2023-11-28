package C2Basics;
public class ch7_methods_02_overloading {
// 'Arguments' = Actual
// 'Static' keyword is used to associate a method of a given class with
// class rather than the object.
// Static method in a class is shared by all the objects.

// Void return type - when we don't want our method to return anything.
// We use void ad the return type

//----------------------------------------------------------
// Creating a static method

//    static void tellJoke(){// method returns nothing
//        System.out.println("I invented a new word! \n"+
//                "Plagiarism!");
//    }
//
//    public static void main(String[] args) {
//        tellJoke();//method called
//    }
//}

//----------------------------------------------------------
// Important, what a method can change, what it cannot change
//    static void change(int a){ // *pass by value
//        a = 45;
//    }
//    static void change(int[]a){ // *pass by reference
//        a[0] = 95;
//    }
//
//    public static void main(String[] args) {
//
//        int[] array = {1, 2, 3, 4, 5, 6};
//        int x = 45;
//        change(x);
//        change(array);
//        System.out.println("the value of x after running change is: "+x);
//        // the value of datatype will not change .: the argument we passed is a copy
//        // of the original, since it's a void function, it will not return anything
//        System.out.println("the value of array[0] after running change is: "+array[0]);
//        // But here, elements of an array will change because the argument we passed is an address/reference
//        // of the array in the memory, the original array will be modified at that memory location
//
//    }

//----------------------------------------------------------
// Method overloading

// Two or more methods can have the 'same name but different parameters'.
// Such methods are called 'Overloaded Methods'.

    // Example of overloaded functions :
    //void foo()
    //void foo(int a)
    //void foo(float a)
    //void foo(int a, int b)
    //void foo(int[] x)

// Method overloading cannot be performed by changing the return type of methods

    static void foo() {
        System.out.println("Good Morning Bro!");
    }

    static void foo(int a) {
        System.out.println("Good Morning " + a + " bro!");
    }

    static void foo(int a, int b) {
        System.out.println("Good Morning " + a + " bro!");
        System.out.println("Good Morning " + b + " bro!");
    }

    public static void main(String[] args) {

        // Method Overloading
        // Overloaded function foo
        foo();
        foo(1000);
        foo(3000, 5000);
        // 'Arguments' are 'Actual'
    }




}





