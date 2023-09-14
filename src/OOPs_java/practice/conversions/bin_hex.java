package OOPs_java.practice.conversions;

public class bin_hex extends numbers {  // binary to hexadecimal
    void convert(String s) {
        String s2 = "0" + s;
        String s3 = "00" + s;
        String s4 = "000" + s;

        if ((s.length() % 4) != 0) {         // (% is modulus = remainder)

            if ((s2.length() % 4) != 0) {     // if length of 's2' is not a multiple of 4,(we add one 00)

                if ((s3.length() % 4) != 0) {
                    c = 3;                    // if length of 's3' still not a multiple of 4,(we add one 000)
                } else {
                    c = 2;
                }
            } else {
                c = 1;
            }
        } else {
            c = 0;
        }

        switch (c) {
            case 0 -> {
                f = s;
                i = f.length() / 4;
                y = f.length();
                for (m = 1; m <= i; m++) {
                    ch1[m] = f.substring(y - 4, y);  // WE CAN START BREAKING AND ADDING FROM THE END
                    y = y - 4;
                }
            }
            case 1 -> {
                f = s2;
                i = f.length() / 4;
                y = f.length();
                for (m = 1; m <= i; m++) {
                    ch1[m] = f.substring(y - 4, y);
                    y = y - 4;
                }
            }
            case 2 -> {
                f = s3;
                i = f.length() / 4;
                y = f.length();
                for (m = 1; m <= i; m++) {
                    ch1[m] = f.substring(y - 4, y);
                    y = y - 4;
                }
            }
            case 3 -> {
                f = s4;
                i = f.length() / 4;
                y = f.length();
                for (m = 1; m <= i; m++) {
                    ch1[m] = f.substring(y - 4, y);
                    y = y - 4;
                }
            }
        }

        // RESULT conversion and printing
        System.out.print("HEXADECIMAL : ");
        for (m = 1; m <= i; m++) {

            switch (ch1[m]) {
                case "0000" -> ch2[m] = '0';
                case "0001" -> ch2[m] = '1';
                case "0010" -> ch2[m] = '2';
                case "0011" -> ch2[m] = '3';
                case "0100" -> ch2[m] = '4';
                case "0101" -> ch2[m] = '5';
                case "0110" -> ch2[m] = '6';
                case "0111" -> ch2[m] = '7';
                case "1000" -> ch2[m] = '8';
                case "1001" -> ch2[m] = '9';
                case "1010" -> ch2[m] = 'A';
                case "1011" -> ch2[m] = 'B';
                case "1100" -> ch2[m] = 'C';
                case "1101" -> ch2[m] = 'D';
                case "1110" -> ch2[m] = 'E';
                case "1111" -> ch2[m] = 'F';
            }
        }
        if (ch1[i].equals("0000")) {
            for (m = i - 1; m >= 1; m--) {  // if last calculated value(at i) is 0000, loop will ignore i
               System.out.print(ch2[m]);
                //fin2= fin2+ch2[m];      char[] to string conversion ...
            }
            //System.out.print(fin2);    // final string to output
        } else {
            for (m = i; m >= 1; m--) {   // i.e: if i=3 & m=i, m could not depreciate below 1, it shall always be > or = 1 ;
                System.out.print(ch2[m]);// we have to print in same .: hex is calculated from right to left
            }                            //                                            written left to right

        }
    }
}
