package com.exercise_5.shape;

import java.util.Scanner;

public class Rectangle extends Square{
   // inherited variable int length
   // default variable, So can only be accessed within this package
   static int width;
   
   // inherited set_Len() method
   static void set_Wid(int w){
            // this.width = w; cannot use this. since no object creation
            width = w;
        }
   static int areaR(){
            return length * width;
        }    
   
   public static void main(String[] args){
   
            int l ;
            int w;
            // No need to create object of an extended class
            //Square s = new Square(); --error-
            
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the Length");
            l = sc.nextInt();
            set_Len(l);
            System.out.println("Enter the width");
            w = sc.nextInt();
            set_Wid(w);
            
            System.out.println("area of square is "+areaR()+"m/sq");
   
   }

}
