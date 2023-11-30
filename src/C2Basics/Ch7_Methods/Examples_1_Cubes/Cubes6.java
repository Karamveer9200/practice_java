/*
 * Version 7 - WRONG!! This one tries to *change* the value of the parameter. That works *inside*
 * the method but the changes are lost when we leave it. That's because the parameter is a *copy*
 * BUT - read the text at the bottom
 */
public class Cubes6
{
		
   public static void main(String[] args)
   {
   	  double temp = 11;
      
	  System.out.println(temp);
		
	  //instead of *returning* temp we try to *change* temp
	  cubeVolume(temp);
		 
	  //Suppose instead of temp we have a constant or final value?
	  System.out.println("A cube with side length 11 has volume " + temp);
	
    }

   public static void cubeVolume(double sideLength)
   {
      
      double volume = sideLength * sideLength * sideLength;
      sideLength = volume; //try to change the actual value of sideLength
	   System.out.println("Inside method " + sideLength);
   }
}

/* When we call a method we make *copies* of the arguments so we *cannot* change them
 * outside the method.
 *
 * BUT...
 * 
 * With simple data type (int, double, boolean, char) the variable contain the
 * *ACTUAL VALUE* - so in this case sideLength actually contains 11.
 * With complex data types (Strings, Arrays, ArrayLists etc.) the variable is just a
 * *REFERENCE* and the actual data is elsewhere. You still cannot change the variable
 * but you CAN change the data it refers to (which is usually what you want).
 *
 */ 
