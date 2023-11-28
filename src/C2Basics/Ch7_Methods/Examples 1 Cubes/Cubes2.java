/*
 * Version 3 - calling cubeVolume more than once - showing we can reuse methods
 */
public class Cubes2
{
		
   public static void main(String[] args)
   {
   	  double temp = 11;
      
	  double vol = cubeVolume(temp);
		  
	  System.out.println("A cube with side length 11 has volume " + vol);
	
	  vol = cubeVolume(6);
		  
	  System.out.println("A cube with side length 6 has volume " + vol);

	
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
