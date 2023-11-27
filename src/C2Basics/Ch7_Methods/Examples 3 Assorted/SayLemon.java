//Version of Say Lemon using do loop
import java.util.Scanner;

public class SayLemon2 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("I'll keep saying Lemon, if you say yes...");
		
		String yesNo;
		
		do{
			System.out.println("lemon");
			System.out.print("Say lemon again? ");
			yesNo = in.nextLine();
		}while(yesNo.equals("yes"));
		
		System.out.println("Bye..");
	}
}