/*
 * Version 8 - not a cubes program really - just showing you can't change an actual array in a method,
 * just the data in it
 */
public class Cubes8
{
		
   public static void main(String[] args)
   {
   	  String[] favouriteFruit = {"Lemon"};
      
	  System.out.println(favouriteFruit[0]);
		
	  evilFruitChanger(favouriteFruit);
		 
	  System.out.println(favouriteFruit[0]);
	
    }

   public static void evilFruitChanger(String[] fruit)
   {
      	String[] newFruit = {"Kiwi"};

		//does not work
	   	fruit = newFruit;
	
		//but this does
		//fruit[0] = "Kiwi";
   }
}
