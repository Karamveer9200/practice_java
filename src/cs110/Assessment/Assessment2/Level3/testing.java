package cs110.Assessment.Assessment2.Level3;

public class testing {
    public static void main(String[] args) {
        Planet jupiter = new Planet("Jupiter", 155000000);
        jupiter.addMoon("Io", 421800.0, 89319000.0, 3643.2);
        jupiter.addMoon("Amalthea", 181400.0, 2080.0, 167.0);
        jupiter.addMoon("Ganymede", 1070400, 148190000.0, 5268.2);
        jupiter.addMoon("Metis", 128000.0, 36.0, 43.0);
        jupiter.addMoon("Pasiphae", 23468200.0, 100.0, 57.8);
        jupiter.addMoon("Calisto", 1882700.0, 107590000.0, 4820.6);
        jupiter.addMoon("Europa", 4799800.0, 47998000.0, 3121.6);
        jupiter.addMoon("Mneme", 20821000.0, 0.0042, 2);

        //System.out.println(jupiter.closest().getMass());
        System.out.println(jupiter);

    }


}
