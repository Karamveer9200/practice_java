package C2Basics;

public class ch2_operators_02 {
    public static void main(String[] args){
        // Precedence and associativity
        int x = 6*5-34/2;
        /*    = 30-34/2
              = 30-17
              = 13
        */
        int y = 60/5-34*2;
        /*    = 12-34*2 (since / and * have same precedence, they are computer
                         on the based on the associativity left to right)
              = 12-68   (/ is on the left, so it will be executed first)
              = -54
         */
        System.out.println(x);
        System.out.println(y);

        /*   ++ and == R->L
             e.g. a = b = 34;
                 b will be assigned the value of 34
                 and then the value of b is assigned to a
         */
        // b square - 4ac divided by 2a (quadratic dividend)
        int a=1,b=2,c=3,p;
        p = (b*b-4*a*c)/2*a;
        System.out.println(p);



        // for more info refer to the chart in the JAVA notes

    }
}
