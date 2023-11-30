/*
 * Cubes program version 1 - just calculate the value of a fixed integer
 * 
 * We use a *method* called cubeVolume that we have written to calculate and return the volume of cube
 */

public class Cubes
{
		
   public static void main(String[] args)
   {
		
	  //Call the cubeVolume method with *argument* value 5
	  double vol = cubeVolume(5);
		  
	  System.out.println("A cube with side length 5 has volume " + vol);
	
    }

	/*
	 * cubeVolume : double -> double
	 * cubeVolume(sideLength) = sideLength * sideLength * sideLength
	 */

	//cubeVolume method with one *parameter* sideLength - in this case we'll call it
	//with value 5
   public static double cubeVolume(double sideLength)
   {
      double volume = sideLength * sideLength * sideLength;
      return volume;
   }
}
