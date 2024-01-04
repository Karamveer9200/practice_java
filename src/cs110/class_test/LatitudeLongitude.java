package cs110.class_test;

import java.math.BigDecimal;

public class LatitudeLongitude {
    public static void main(String[] args) {

        System.out.println(conversion(51, 37, 01.5, 'N'));

    }
    static double conversion(double degree, double minutes, double seconds, char x) {
        double min;
        double sec;
        double result;

        min = minutes / 60;
        sec = seconds / 3600;
        result = degree + min + sec;

        BigDecimal original = new BigDecimal(Double.toString(result));
        BigDecimal rounded = original.setScale(6, BigDecimal.ROUND_HALF_EVEN);
        result = rounded.doubleValue();

        if (x == 'S' || x == 'W') {
            return result * -1;
        }

        return result;
    }
}


