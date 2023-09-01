package beginning.oops.practice.conversions;

public class bin_dec extends numbers {
    void convert(String s) {

        int dec = 0;
        m = 2;
        i = s.length();
        // logic for the first two binary numbers:
        if (s.charAt(i - 1) == '1') {  // here i-1 .: i=s.length();, so i = integer(starts from 1) != whole number,
            if (s.charAt(i - 2) == '1') { // but charAt() method counts from 0, so we have to start counting from i-1
                dec = 3;             // i-1 .: we are checking from the last number(right to left)
            } else {
                dec = 1;
            }
        }
        if (s.charAt(i - 1) == '0') {
            if (s.charAt(i - 2) == '1') {
                dec = 2;
            } else {
                dec = 0;
            }
        }

        // logic for the rest of the binary numbers below:
        for (y = i - 3; y >= 0; y--) {
            m = m * 2;
            if (s.charAt(y) == '1') {
                dec = dec + m;
            }
        }
        // output
        System.out.println("DECIMAL     : " + dec);
    }
}
