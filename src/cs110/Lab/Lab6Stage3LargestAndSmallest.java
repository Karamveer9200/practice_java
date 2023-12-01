package cs110.Lab;

public class Lab6Stage3LargestAndSmallest {
    public static void main(String[] args) {

        int[] numbers = {1, 7, -3, 14, 19, 0, 2, -8, 6, 11, 3};
        int max = numbers[0];
        int min = numbers[0];
        // max
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        // min
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        System.out.println("max: "+ max);
        System.out.println("max: "+ min);

    }
}
