package cs110.Lab;

public class Lab6Stage1Squares {
    public static void main(String[] args) {
        int[] squares = new int[10];
        for (int i = 0; i < squares.length; i++) {
            squares[i] = i * i;
        }
        for (int i = 0; i < squares.length; i++) {
            System.out.printf("square of %d is %d \n", i, squares[i]);
        }
    }
}
