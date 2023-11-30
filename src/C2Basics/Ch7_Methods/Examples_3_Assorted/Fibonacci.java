
public class Fibonacci {

    private static int FIB_SIZE = 46;

    public static void main(String[] args) {
        System.out.println("Fibonacci " + FIB_SIZE + " - using a loop");
        long start = System.currentTimeMillis();
        System.out.println(fibIter(FIB_SIZE));
        double timeInSeconds = ((double) System.currentTimeMillis() - start)/1000;
        System.out.println("Takes " + timeInSeconds + " seconds");
        System.out.println("Fibonacci " + FIB_SIZE + " - recursively");
        start = System.currentTimeMillis();
        System.out.println(fibRec(FIB_SIZE));
        timeInSeconds = ((double) System.currentTimeMillis() - start)/1000;
        System.out.println("Takes " + timeInSeconds + " seconds");

    }

    public static int fibIter(int num) {
        if (num == 1 | num == 2) {
            return 1;
        } else {
            int f1 = 1;
            int f2 = 1;
            for (int i = 3; i <= num; i++) {
                int temp = f2;
                f2 += f1;
                f1 = temp;
            }
            return f2;
        }
    }

    public static int fibRec(int num) {
        if (num == 1 || num == 2) {
            return 1;
        } else {
            return fibRec(num - 1) + fibRec(num - 2);
        }
    }
}
