package cs110.Lab;

import java.util.ArrayList;

public class Lab6Stage4ArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> squares = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            squares.add(i * i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.printf("square of %d is %d \n", i, squares.get(i));
        }
    }
}
