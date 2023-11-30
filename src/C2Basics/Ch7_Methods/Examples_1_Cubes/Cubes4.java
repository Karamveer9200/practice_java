/*
 * Version 5 - on the other hand if you're repeating a call you might be better off
 * storing the result - in this case we are calling the method twice with the same
 * arguments (so the result will be the same)
 */
public class Cubes4
{
		
   public static void main(String[] args)
   { 
	 
	  System.out.println("A cube with side length 11 has volume " + cubeVolume(11));
 
	  System.out.println("Another cube with side length 11 has volume "
	                     + cubeVolume(11));
	
	  //Better to do:
	  double val = cubeVolume(11); //especially if the method is 'expensive'
			
	  System.out.println("A cube with side length 11 has volume " + val);
 
	  System.out.println("Another cube with side length 11 has volume "
	                     + val);

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
