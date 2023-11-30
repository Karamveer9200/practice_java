/*
 * Version 1a - command line arguments. In this version, to get it to work you have to type, say:
 * java Cubes1a 5
 * to calculate the volume of a cube of side length 5 (you can obviously put whatever number you want)
 *
 * The value 5 is stored as a string in args[0]. If you typed more than one paramter after 5, they would
 * go in args[1], args[2] etc.
 */
public class Cubes1a
{
		
   public static void main(String[] args)
   {
	  if (args.length == 0){
		System.out.println("idiot");
		System.exit(0);
	}
   	  double temp = Double.parseDouble(args[0]);
      
	  System.out.println(temp);
		
	  //the name of the argument and parameter do *not* need to be the same
	  double vol = cubeVolume(temp);
		  
	  System.out.println("A cube with side length " + args[0] + " has volume " + vol);
	
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
