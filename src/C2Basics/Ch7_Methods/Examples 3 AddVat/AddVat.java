import java.util.Scanner;

/*
 * This is our first attempt at a method that adds VAT to a price
 * It doesn't work:-)
 */

class AddVat {
	public static void main(String[] args) {
		
		final double VAT_RATE = 20; //VAT rate in %
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter the item price: ");
		double price = in.nextDouble();
		
		addTax(price, VAT_RATE);
		
		System.out.println("The price with tax is: " + price);
	}
	
	public static void addTax(double price, double tax){
		price = price + (price*tax/100);
	}
}