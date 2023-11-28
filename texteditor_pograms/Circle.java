package com.exercise_5.shape;

import java.util.Scanner;

public class Circle{
   
    // double radius; // --ERROR: can't access instance variable .: no object creation
    // So, we have to make them 'static' to make it accessible to this class 
       // default variable, So can only be accessed within this package
       static double radius;


        // area method
        // public double area(){ // --ERROR: can't access .: 'no object creation'
        // So, we have to make it static to make it accessible to this class
        static double area(){
            return 3.14*(radius*radius);
        }

        // setters for length 
        static void set_Radius(double r){
            // this.radius = length; cannot use 'this.' .: 'no object creation'
            // is happening in the main method
            radius = r;
        }
        


        public static void main(String[] args){
            
            double r ; // local variable, wont be inherited by subclass
      
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the radius");
            r = sc.nextDouble();
            set_Radius(r);
            
            System.out.println("area of Circle is "+area()+" m/sq");
        }

}
