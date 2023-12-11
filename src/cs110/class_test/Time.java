package cs110.class_test;

import java.time.format.DateTimeFormatter;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class Time {
    public static void main(String[] args) {

        // setting a format for date and Time
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        //System.out.println(df.format(java.time.LocalDateTime.now()));


        // converting String format to milliSeconds(long)
        String date = "2020/01/01 00:00:00";
        long milliSeconds = LocalDateTime.parse(date, df).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        System.out.println(milliSeconds);

        System.out.println(" ");

        // converting milliSeconds(long) to String format
        long milliSeconds2 = 1577836800000L;
        LocalDateTime dmils = LocalDateTime.ofInstant(Instant.ofEpochMilli(milliSeconds2), ZoneId.systemDefault());
        String dateString = dmils.format(df);
        System.out.println(dateString);



    }


}
