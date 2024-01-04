package cs110.Assessment.Assessment2.Level2;

public class testing {
    public static void main(String[] args) {
        Planet jupiter = new Planet("Jupiter", 155000000);
        jupiter.addMoon("Io", 421800.0);
        jupiter.addMoon("Amalthea", 181400.0);

        System.out.println(jupiter);

    }


}
