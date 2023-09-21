package OOPs_java.basics;
// The Throw Keyword:
// The throw keyword is used to throw an exception explicitly by the programmer

//if (b===0) {
//       throw new ArithmeticException("Div by 0");
//          }
//     else{
//             return a/b ;
//         }

//The throw Keyword:
//Throws java throws keyword is used to declare an exception.
//This gives information to the programmer that there might be an exception,
// so it's better to be prepared with a try catch block!

// public void calculate (int a, int b) throws IOException {
//
//            // code
//
//    }
//----------------------------------------------------------

public class ch15_5_throw_vs_throws {

    // we indicated that divide() may throw ArithmeticException

    public static int divide(int a, int b) throws ArithmeticException{
        return a/b;
    }

    // we indicated that area() may throw NegativeRadiusException(custom exception)

    public static double area(double r) throws NegativeRadiusException{
        // when to throw NegativeRadiusException
        if(r<0) {
            throw new NegativeRadiusException();
        }
        return Math.PI * r * r;
    }

    public static void main(String[] args) {

        try{
            System.out.println("a/b is :" +divide(4,0));
        }
        catch (Exception e){
            System.out.println("Exception 1 "+e);
        }

        try{
            System.out.println("area is :" +area(-5));
        }
        catch (Exception e){
            System.out.println("\nException 2 "+e);
            System.out.println("Message:    "+e.getMessage());
        }

        System.out.println("\nEnd of the program");
    }
}

// custom exception for -ve radius
 class NegativeRadiusException extends Exception{

    @Override
    public String toString(){
        return "Radius cannot be a negative number";
    }
    @Override
    public String getMessage(){
        return "Enter a positive number";
    }
}