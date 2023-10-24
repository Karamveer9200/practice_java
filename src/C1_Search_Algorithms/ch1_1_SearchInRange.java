package C1_Search_Algorithms;

public class ch1_1_SearchInRange {

    // Linear search, but we provide a STARTING index and ENDING index
    public static void main(String[] args) {

            String name  = "Dhruv Madhu";
            char target = 'r';
            // here starting index is 1 and ending index is 2
            boolean result = linearSearch(name, target,1,3);
            System.out.println(result);

        }

        // function linearSearch will only search between index 1 and 3
        static boolean linearSearch(String name, char target, int startIndex, int endIndex) {
            if (name.length() == 0) {
                return false;
            }
            for(int i = startIndex; i < endIndex; i++) {
                if(target == name.charAt(i)) {
                    return true;
                }
            }

            return false;

        }

}

