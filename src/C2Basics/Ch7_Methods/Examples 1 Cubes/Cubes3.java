/*
 * Version 4 - skipping the extra variable vol - you can use a method where you need
 * a value and you don't need to store the result in a variable first
 */
public class Cubes3
{
		
   public static void main(String[] args)
   {
   	  double temp = 11;
		  
	  System.out.println("A cube with side length 11 has volume " + cubeVolume(temp));
 
	  System.out.println("A cube with side length 6 has volume " + cubeVolume(6));
	
     System.out.println("With sides 2 & 3: " + (cubeVolume(2) + cubeVolume(3)));
	
    }

	/*
	 * cubeVolume : double -> double
	 * cubeVolume(sideLength) = sideLength * sideLength * sideLength
	 */

   public static double cubeVolume(double sideLength)
   {
      
      double volume = sideLength * sideLength * sideLength;
      return volume;
   }
}
