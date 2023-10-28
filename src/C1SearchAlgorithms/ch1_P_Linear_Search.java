package C1SearchAlgorithms;

import java.util.Arrays;

public class ch1_P_Linear_Search {
    public static void main(String[] args) {
        String name  = "Harry";
        char target = 'r';
        boolean result = linearSearch(name, target);
        System.out.println(result);

        // printing a String of character array that we created
        // the function Arrays.toString()
        System.out.println(Arrays.toString(name.toCharArray()));

    }

    static boolean linearSearch(String name, char target) {
        if (name.length() == 0) {
            return false;
        }
        for(int i = 0; i < name.length(); i++) {
        // using for each loop
        // for (char ch : name.toCharArray()) {
           // if (ch == target) {
            if(target == name.charAt(i)) {
                return true;
            }
        }

        return false;

    }
}
