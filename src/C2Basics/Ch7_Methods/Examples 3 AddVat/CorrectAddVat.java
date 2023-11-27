import java.util.Scanner;

/*
 * This is our second attempt at a program to add VAT to a price
 * it works, but perhaps isn't as clear as it could be
 */

class CorrectAddVat {
	public static void main(String[] args) {
		
		final double VAT_RATE = 20; //VAT rate in %
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter the item price: ");
		double price = in.nextDouble();
		
		price = addTax(price, VAT_RATE);
		
		System.out.println("The price with tax is: " + price);
	}
	
	public static double addTax(double price, double tax){
		return price + (price*tax/100);
	}
}