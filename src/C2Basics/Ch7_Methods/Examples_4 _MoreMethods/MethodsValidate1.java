
import java.util.Scanner;
/*
This is an improvement - it uses a method (validateInput) to read in integers,
but it's not very flexible because it doesn't use parameters
*/
public class MethodsValidate1 {
    
    public static void main(String[] args){
        System.out.println("Enter the number of lemons between 1 and 7");
        int lemons = validateInput();
        System.out.println("Enter the number of kiwis between 1 and 7");
        int kiwis = validateInput();
        
        System.out.println(lemons + " lemons and " + kiwis + " kiwis.");
        
    }

    public static int validateInput() {
        int returnValue;
        Scanner in = new Scanner(System.in);
        do {
            System.out.print("Enter the number of things you want, between 1 and 7: ");
            while (!in.hasNextInt()) {
                System.out.print("I said a number between 1 and 7: ");
                in.nextLine();
            }
            returnValue = in.nextInt();
        } while (returnValue < 1 || returnValue > 7);
        return returnValue;
    }

}
