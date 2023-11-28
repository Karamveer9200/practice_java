package Others.practice.conversions;

public class bin_oct extends numbers {    // binary to octal
    void convert(String s) {   // method/function override from super class numbers;

        String s2 = "0" + s;
        String s3 = "00" + s;

        if ((s.length() % 3) != 0) {         // (% is modulus = remainder)

            if ((s2.length() % 3) != 0) {     // if length of original string 's' is not a multiple of 3,(we add one 0)
                c = 2;                            // then if length of string with added zero '0' (s2) still not a multiple of 3
            }                                 // we add 2 zeros '00' to original string s at the end.
            else {
                c = 1;
            }
        } else {
            c = 0;
        }

        switch (c) {
            case 0 -> {
                f = s;
                i = f.length() / 3;
                y = f.length();
                for (m = 1; m <= i; m++) {
                    ch1[m] = f.substring(y - 3, y);
                    y = y - 3;
                }
            }
            case 1 -> {
                f = s2;
                i = f.length() / 3;
                y = f.length();
                for (m = 1; m <= i; m++) {
                    ch1[m] = f.substring(y - 3, y);
                    y = y - 3;
                }
            }
            case 2 -> {
                f = s3;
                i = f.length() / 3;
                y = f.length();
                for (m = 1; m <= i; m++) {
                    ch1[m] = f.substring(y - 3, y);
                    y = y - 3;
                }
            }
        }

        // RESULT conversion and printing
        for (m = 1; m <= i; m++) {

            switch (ch1[m]) {
                case "000" -> ch3[m] = 0;
                case "001" -> ch3[m] = 1;
                case "010" -> ch3[m] = 2;
                case "011" -> ch3[m] = 3;
                case "100" -> ch3[m] = 4;
                case "101" -> ch3[m] = 5;
                case "110" -> ch3[m] = 6;
                case "111" -> ch3[m] = 7;
            }
        }
        for (m = i; m >= 1; m--){ // i.e: if i=3 & m=i, m could not depreciate below 1, it shall always be > or = 1 ;
            fin = fin*10;         // converting int[] array to int
            fin = fin + ch3[m];
        }
        System.out.print("OCTAL is    : "+fin);
    }
}
