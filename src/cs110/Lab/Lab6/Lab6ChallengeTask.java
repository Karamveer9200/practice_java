package cs110.Lab.Lab6;

import java.util.ArrayList;

public class Lab6ChallengeTask {
    public static void main(String[] args) {
        int[] gaps = {1,2,4,5,8,10,12,13,15,18,24};
        ArrayList<Integer> nogaps = new ArrayList<>();

        for (int withGaps : gaps) {
            nogaps.add(withGaps);
        }

        for (int i = 0; i < (nogaps.size() - 1); i++) {
            if (nogaps.get(i) != nogaps.get(i+1)-1) {
                nogaps.add(i+1, i+2);
            }
        }
        System.out.println(nogaps);
    }
}
