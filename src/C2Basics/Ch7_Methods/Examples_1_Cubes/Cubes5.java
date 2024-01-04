/*
 * Version 6 - more than one method and 'void'
 */
public class Cubes5
{
		
   public static void main(String[] args)
   {
	  final double LENGTH = 11;
   	  double val = cubeVolume(LENGTH);
	  printCube(val, LENGTH);
	
    }

   /* A method to do the printing - more than one parameter and the return type void
    * This method just 'does something' - it doesn't return a value
    */
   public static void printCube(double volume, double sideLength){
		System.out.println("A cube with side length " + sideLength +
			" has volume " + volume);
		//return;
	}

   public static double cubeVolume(double sideLength)
   {
      
      double volume = sideLength * sideLength * sideLength;
      return volume;
   }
}
