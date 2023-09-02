package beginning.oops.problems;
// to encrypt and decrypt a grade by adding number 8
import java.util.Scanner;
public class problem_01 {
    public static void main(String[] args) {
        Scanner dc = new Scanner(System.in);
        char grade;
        System.out.println("enter a grade");
        grade = dc.next().charAt(0);
        //encryption by adding 8
        grade = (char)(grade + 8); //  added'(char)':(TYPECASTING) so that compiler recognises grade as 'char'
        System.out.println(grade); //  because we are adding '8'to the expression which is 'int' by default
        // decryption by removing 8
        grade = (char)(grade - 8); //  because 'char+int = int', we can forcefully typecast one datatype
        System.out.println(grade); //  to another as we did here
    }
}