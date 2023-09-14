package OOPs_java.report_card;

import java.util.Scanner;

public class Marks_2 {
    public static void main(String[] args) {

        System.out.println("Enter the marks  ");
        System.out.println("********************************************************");
        Scanner sc=new Scanner(System.in);
        System.out.print("English   (Theory 100)  : ");
        input ei = new input();
        ei.enter();
        System.out.print("Physics   (Theory 70)   : ");
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
        float total= ei.e+p+pp+c+cp+m+g;

        // practise part (function calling & object creation)
        compute eng = new compute();
        eng.decision100(ei.e);
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

        System.out.println(" ");
        System.out.println("                     Final Result "+School.year);// 'static' variable
        System.out.println("                  "+School.school); // 'static' variable(no class object creation needed)
        System.out.println("*********************************************************");
        System.out.println("  subjects      theory         practical      result");
        System.out.println("---------------------------------------------------------");
        System.out.println("  English        "+ei.e+"            n/a           "+eng.s_1);// variable 's_1' from class 'compute' called by the obj. 'eng';
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
