
import java.util.Scanner;
/*
This is a better version of validateInput because it uses parameters to enable
it to be more flexible - exercise: improve it further
*/
public class MethodsValidate2 {
    
    public static void main(String[] args){
        int lemons = validateInput(1, 7, "Enter the number of lemons between 1 and 7: ");
        int kiwis = validateInput(1, 4, "Enter the number of kiwis between 1 and 4: ");
        
        System.out.println(lemons + " lemons and " + kiwis + " kiwis.");
        
    }

    public static int validateInput(int lowVal, int highVal, String msg) {
        int returnValue;
        Scanner in = new Scanner(System.in);
        do {
            System.out.print(msg);
            while (!in.hasNextInt()) {
                System.out.print("I said a number between " + lowVal + 
                        " and " + highVal +": ");
                in.nextLine();
            }
            returnValue = in.nextInt();
        } while (returnValue < lowVal || returnValue > highVal);
        return returnValue;
    }

}
