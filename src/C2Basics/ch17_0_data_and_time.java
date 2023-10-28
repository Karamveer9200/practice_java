package C2Basics;

public class ch17_0_data_and_time {
    // java.time package for date and time from java 8 onwards
    // how java stores date and time?
    // date in java is stored as the number of milliseconds since 1970-01-01 00:00:00 UTC
    // Java assumes that 1900 is the start year and calculates the number of years passed
    // since then, when we ask for years.
    // System.currentTimeMillis() returns the number of milliseconds since 1970-01-01 00:00:00 UTC
    // We can then calculate minutes, seconds and years passed.

    public static void main(String[] args) {
        // printing milliseconds passed since 1970-01-01 00:00:00 UTC
        System.out.println(System.currentTimeMillis());
        // for seconds
        System.out.println(System.currentTimeMillis()/1000);
        // for minutes
        System.out.println(System.currentTimeMillis()/1000/60);
        // for hours
        System.out.println(System.currentTimeMillis()/1000/3600);
        // for days
        System.out.println(System.currentTimeMillis()/1000/3600/24);
        // for years
        System.out.println(System.currentTimeMillis()/1000/3600/24/365);

    }
}
