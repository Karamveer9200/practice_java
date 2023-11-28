import java.util.Scanner;

/*
 * This is our third attempt at a program to add VAT to a price
 * it works, and is clearer than the last one in my opinion (though
 * it's a matter of opinion)
 */

class CorrectAddVat2 {
	public static void main(String[] args) {
		
		final double VAT_RATE = 20; //VAT rate in %
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter the item price: ");
		double price = in.nextDouble();
		
		price += calcTax(price, VAT_RATE);
		
		System.out.println("The price with tax is: " + price);
	}
	
	/* This method *just calculates the tax* and we add the tax in the
	main method - so someone reading the main method can see clearly what
	is happening */
	public static double calcTax(double price, double tax){
		return (price*tax/100);
	}
}