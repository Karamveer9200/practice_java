/*
 * Version 7 - showing you CAN change the data *in* (say) an Array
 * BTW - don't actually *do* silly things like this in practice - if you are
 * only dealing with one value you should use a return value. But if you are doing
 * something to more complex data, then changing it within a method is ofte a good idea
 */
public class Cubes7
{
		
   public static void main(String[] args)
   {
   	  double[] temp = {11};
      
	  System.out.println(temp[0]);
		
	  //instead of *returning* temp we try to *change* temp
	  cubeVolume(temp);
		 
	  //Suppose instead of temp we have a constant or final value?
	  System.out.println("A cube with side length 11 has volume " + temp[0]);
	
    }

   //We pass an array - we can change the data in the array but not the actual array
   public static void cubeVolume(double[] sideLength)
   {
      
      double volume = sideLength[0] * sideLength[0] * sideLength[0];
      sideLength[0] = volume; 
	   //System.out.println("Inside method " + sideLength[0]);
   }
}
