package C1SearchAlgorithms;

public class ch1_2_MinimumNumber {
    public static void main(String[] args) {
        int[] arr = {56,34,5,6,45,7,5,67,18,6,45};
        int min = minNumber(arr);
        System.out.println(min);
    }
    static int minNumber(int[] ourArr) {
        int answer = ourArr[0];
        for (int i = 0; i < ourArr.length; i++) {
            if (ourArr[i] < answer) {
                answer = ourArr[i];
            }
        }
        return answer;

    }
}
