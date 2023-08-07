package beginning.basics.report_card;

import java.util.*;

public class Marks {
    public static void main(String[] args) {

        System.out.println("Enter the marks  ");
        System.out.println("********************************************************");
        Scanner sc=new Scanner(System.in);
        System.out.print("English   (Theory 100)  : ");
        float e = sc.nextFloat();                             // insert code to re-type invalid input !!
        System.out.print("Physics   (Theory 70)   : ");       // make a fn. to only accept values within 100,70,30
        float p = sc.nextFloat();
        System.out.print("Physics   (Practical 30): ");
        float pp = sc.nextFloat();
        System.out.print("Chemistry (Theory 70)   : ");
        float c = sc.nextFloat();
        System.out.print("Chemistry (Practical 30): ");
        float cp = sc.nextFloat();
        System.out.print("Maths     (Theory 100)  : ");
        float m = sc.nextFloat();
        System.out.print("Geography (Theory 100)  : ");
        float g = sc.nextFloat();
        float total= e+p+pp+c+cp+m+g;

       // practise part (function calling & object creation)
        compute eng = new compute();
        eng.decision100(e);
        compute phy = new compute();
        phy.decision70(p);
        compute chem = new compute();
        chem.decision70(c);
        compute math = new compute();
        math.decision100(m);
        compute geo = new compute();
        geo.decision100(g);

        compute_2 fin = new compute_2();
        fin.final_result(total, eng.s_1, phy.s_1, chem.s_1, math.s_1, geo.s_1);

       /* individual subject decision without function calling method
        String e1,p1,c1,m1,g1;
        if(e>=45){
            e1 = "Pass";
        } else {
            e1 = "Comp.";
        }if(p>=30){
            p1 = "Pass";
        } else {
            p1 = "Comp.";
        }if(c>=30){
            c1 = "Pass";
        } else {
            c1 = "Comp.";
        }if(m>=45){
            m1 = "Pass";
        } else {
            m1 = "Comp.";
        }if(g>=45){
            g1 = "Pass";
        } else {
            g1 = "Comp.";
        }*/

        System.out.println(" ");
        System.out.println("                     Final Result "+School.year);// 'static' variable
        System.out.println("                  "+School.school); // 'static' variable(no class object creation needed)
        System.out.println("*********************************************************");
        System.out.println("  subjects      theory         practical      result");
        System.out.println("---------------------------------------------------------");
        System.out.println("  English        "+e+"            n/a           "+eng.s_1);// variable 's_1' from class 'compute' called by the obj. 'eng';
        System.out.println("  Physics        "+p+"            "+pp+"          "+phy.s_1);
        System.out.println("  Chemistry      "+c+"            "+cp+"          "+chem.s_1);
        System.out.println("  Maths          "+m+"            n/a           "+math.s_1);
        System.out.println("  Geography      "+g+"            n/a           "+geo.s_1);
        System.out.println("*********************************************************");
        System.out.println("  Total marks obtained : "+total+" out of 500");
        System.out.println("  Total percentage is  : "+Math.round(fin.per)+"%");    // rounded off
        System.out.println("  Calculated  CGPA is  : "+fin.cgpa);
        System.out.println("*********************************************************");
        System.out.println("  FINAL RESULT         : "+fin.s_1);// variable 's_1' from class 'compute_2' called by the obj.'fin';
        System.out.println("  DIVISION             : "+fin.div);
        System.out.println(" ");
    }
}