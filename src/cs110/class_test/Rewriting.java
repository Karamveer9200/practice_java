package cs110.class_test;

public class Rewriting {
    public static void main(String[] args) {
        String originalString = "The king stole the lemon";

        // Replace anything after "the " with "N"
        String newString = originalString.replaceAll("(?i)the\\s+\\w+", "the N");
        System.out.println("Original String: " + originalString);
        System.out.println("Modified String: " + newString);
        newString = originalString.replaceAll("(?i)the\\s+\\w+", "NP");
        System.out.println("Modified String: " + newString);

        newString = newString.replaceAll("NP\\s+\\w+", "NP V");
        System.out.println("Modified String: " + newString);

    }
}

