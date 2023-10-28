package C2Basics;
public class ch7_methods_04_recursion {
// A function in JAVA can 'call itself', Such calling of a function
// is called 'Recursion'

    //factorial(1) = 0
    //factorial(5) = 5 * 4 * 3 * 2 * 1
    //factorial(n) = n * (n-1) *...1
    //factorial(n) = n * factorial(n-1)

    static int factorial(int n){
        if (n==0) {
            return 1;
        }else{
            return n * factorial(n-1);
            // factorial(n-1) will keep calling original factorial(int n) with the value(n-1) until n reaches 1
            // n * factorial(n-1)
            // n * (n-1 * factorial((n-1)-1))
            // 4 * factorial(3) // goes to original function
            // 4 * (3 * factorial(2))  // value if 'new n' here is 3
            // 12 * 2 * factorial(1)
            // 24 * 1 * factorial(0) // factorial(0) will also return 1
            // 24 * 1
            // 24

        }
    }
    static int fib(int n){

        if(n<=1) {
            return n;
        }
        else {
            return fib(n-1)+fib(n-2); // unable to print the complete series yet because
            // of return datatype (either int or string not both)
        }
    }

    public static void main(String[] args) {
        int x = 4;
        System.out.println("The value of factorial 4 is "+factorial(x));
        System.out.println("The fibonacci series of 4 is "+fib(x));
    }

}
