package CS_110.Exercises;
/*
Write a loop that outputs the sum of all squares of numbers between 0 and 100 (remember to pick the correct kind of
loop - you know in advance how many times the loop will go around?)
 */
public class Ch6Ex1Sqaures {
    public static void main(String[] args) {
        int square;
        for(int i = 1; i<=100 ; i++) {
            square = i * i;
            System.out.println("square of "+i+" : "+square);
        }
    }
}
