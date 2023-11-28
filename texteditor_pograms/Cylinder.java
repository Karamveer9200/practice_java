package com.exercise_5.shape;

import java.util.Scanner;

public class Cylinder extends Circle{
   // inherited double radius
   // default variable, So can only be accessed within this package
   static double height;
   
   // setter for height
   static void set_Height(double h){
          
            height = h;
        }
   // inherited area()     
   static double areaC(){
   
      return  2 * 3.14 * radius * height + 2 * area();
   
   }
   
   static double volume(){
   
      return  area() * height;  // pie r^2 h --> area*h    
   }
   
   
   public static void main(String[] args){
   
            double r;
            double h;
      
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the radius");
            r = sc.nextDouble();
            set_Radius(r);
            System.out.println("Enter the height");
            h = sc.nextDouble();
            set_Height(h);
            
            System.out.println("area of Cylinder is   "+areaC()+" m/sq");   
            System.out.println("volume of Cylinder is "+volume()+" m/sq");  
   }

}
