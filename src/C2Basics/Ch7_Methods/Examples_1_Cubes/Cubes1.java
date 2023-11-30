/*
 * Version 2 - showing we can use a variable as an argument not just a constant
 */
public class Cubes1
{
		
   public static void main(String[] args)
   {
   	  double temp = 11;
      
	  System.out.println(temp);
		
	  //the name of the argument and parameter do *not* need to be the same
	  double vol = cubeVolume(temp);
		  
	  System.out.println("A cube with side length 11 has volume " + vol);
	
    }

	/*
	 * cubeVolume : double -> double
	 * cubeVolume(sideLength) = sideLength * sideLength * sideLength
	 */

   /* When we called the method we called it with the variable temp - the
    * value stored in temp will be copied into sideLength and used in
    * the method
    */
   public static double cubeVolume(double sideLength)
   {
      
      double volume = sideLength * sideLength * sideLength;
      return volume;
   }
}
