package cs110.Assessment.Assessment2.Level2;
/*This is the automatic test class for CS-110 coursework 2 Level 2.
 */
public class AutoTestLevel2 {

    public static final String JUPITER_CORRECT_OUTPUT = """
            Planet Jupiter has moons:
            Io is 421800 km from its planet, and orbits in 1.77 days
            Amalthea is 181400 km from its planet, and orbits in 0.50 days
            Ganymede is 1070400 km from its planet, and orbits in 7.14 days
            Metis is 128000 km from its planet, and orbits in 0.30 days
            Pasiphae is 23468200 km from its planet, and orbits in 733.48 days
            Calisto is 1882700 km from its planet, and orbits in 16.67 days
            Europa is 4799800 km from its planet, and orbits in 67.84 days
            Mneme is 20821000 km from its planet, and orbits in 612.94 days
            """;

    public static final String SATURN_CORRECT_OUTPUT = """
            Planet Saturn has moons:
            Titan is 1221930 km from its planet, and orbits in 15.95 days
            Gridr is 19250700 km from its planet, and orbits in 997.21 days
            Pan is 133584 km from its planet, and orbits in 0.58 days
            Methone is 194440 km from its planet, and orbits in 1.01 days
            Enceladus is 234950 km from its planet, and orbits in 1.34 days
            Iapetus is 3560820 km from its planet, and orbits in 79.33 days
            S/2004 S 24 is 23339900 km from its planet, and orbits in 1331.27 days
            """;

    public static void main(String[] args) {
        //We repeat all the level 1 tests first
        //CHECKSTYLE:OFF
        //Create planets
        Planet jupiter = new Planet("Jupiter", 155000000);
        Planet saturn = new Planet("Saturn", 84700000);

        //Add moons of Jupiter (some of them) - note deliberately out of order
        jupiter.addMoon("Io", 421800.0);
        jupiter.addMoon("Amalthea", 181400.0);
        jupiter.addMoon("Ganymede", 1070400);
        jupiter.addMoon("Metis", 128000.0);
        jupiter.addMoon("Pasiphae", 23468200.0);
        jupiter.addMoon("Calisto", 1882700.0);
        jupiter.addMoon("Europa", 4799800.0);
        jupiter.addMoon("Mneme", 20821000.0);

        //Add moons of Saturn
        saturn.addMoon("Titan", 1221930.0);
        saturn.addMoon("Gridr", 19250700.0);
        saturn.addMoon("Pan", 133584.0);
        saturn.addMoon("Methone", 194440.0);
        saturn.addMoon("Enceladus", 234950.0);
        saturn.addMoon("Iapetus", 3560820.0);
        saturn.addMoon("S/2004 S 24", 23339900.0);
        //CHECKSTYLE:ON

        final String jupiterOutput = jupiter.toString();
        final String saturnOutput = saturn.toString();

        if (jupiterOutput.equals(JUPITER_CORRECT_OUTPUT)) {
            System.out.println("Jupiter Correct!");
        } else {
            System.out.println("""
                    Match failed for Jupiter.
                    The string below starts from THE FIRST POINT WHERE YOUR OUTPUT AND THE EXPECT OUTPUT DIFFER
                    (if blank check that you have a newline at the end of your output:
                    """);
            System.out.println(difference(jupiterOutput, JUPITER_CORRECT_OUTPUT));
            System.out.println("\nYour output:");
            System.out.println(jupiterOutput);
            System.out.println("\nCorrect output:");
            System.out.println(JUPITER_CORRECT_OUTPUT);
        }

        if (saturnOutput.equals(SATURN_CORRECT_OUTPUT)) {
            System.out.println("Saturn Correct!");
        } else {
            System.out.println("""
                    Match failed for Saturn.
                    The string below starts from THE FIRST POINT WHERE YOUR OUTPUT AND THE EXPECT OUTPUT DIFFER
                    (if blank check that you have a newline at the end of your output:
                    """);
            System.out.println(difference(saturnOutput, SATURN_CORRECT_OUTPUT));
            System.out.println("\nYour output:");
            System.out.println(saturnOutput);
            System.out.println("\nCorrect output:");
            System.out.println(SATURN_CORRECT_OUTPUT);
        }

        /*Setup 'fake' versions of the planets and add the closest and furthest planets */
        Planet fakeJupiter = new Planet("some fake name", 0);
        Planet fakeSaturn = new Planet("some fake name", 0);
        //CHECKSTYLE:OFF
        /*The reason we create the names in this strange way is to force the actual strings to be different
         */
        fakeJupiter.addMoon("XMetis".substring(1), 128000.0);
        fakeJupiter.addMoon("XPasiphae".substring(1), 23468200.0);
        fakeSaturn.addMoon("XPan".substring(1), 133584.0);
        fakeSaturn.addMoon("XS/2004 S 24".substring(1), 23339900.0);


        //Handle checking that the closest, furthest, get by name and equals all work
        if (jupiter.closest().equals(fakeJupiter.getMoonByName("Metis"))) {
            System.out.println("Jupiter closest correct!");
        } else {
            System.out.println("Jupiter closest failed: You said " + jupiter.closest().getName() + " but it should be "
                    + fakeJupiter.getMoonByName("Metis").getName());
        }
        if (jupiter.furthest().equals(fakeJupiter.getMoonByName("Pasiphae"))) {
            System.out.println("Jupiter furthest correct!");
        } else {
            System.out.println("Jupiter furthest failed: You said " + jupiter.furthest().getName() + " but it should be "
                    + fakeJupiter.getMoonByName("Pasiphae").getName());
        }

        if (saturn.closest().equals(fakeSaturn.getMoonByName("Pan"))) {
            System.out.println("Saturn closest correct!");
        } else {
            System.out.println("Saturn closest failed: You said " + saturn.closest().getName() + " but it should be "
                    + fakeSaturn.getMoonByName("Pan").getName());
        }
        if (saturn.furthest().equals(fakeSaturn.getMoonByName("S/2004 S 24"))) {
            System.out.println("Saturn furthest correct!");
        } else {
            System.out.println("Saturn furthest failed: You said " + saturn.furthest().getName() + " but it should be "
                    + fakeSaturn.getMoonByName("S/2004 S 24").getName());
        }
        //CHECKSTYLE:ON
    }

    /*These two methods are copied with minor edits from Apache Foundation's StringUtils package, to stop you having
    to download and install all of it
     */
    public static String difference(String str1, String str2) {
        if (str1 == null) {
            return str2;
        }
        if (str2 == null) {
            return str1;
        }
        int at = indexOfDifference(str1, str2);
        if (at == -1) {
            return "";
        }
        return str2.substring(at);
    }

    public static int indexOfDifference(CharSequence cs1, CharSequence cs2) {
        if (cs1 == cs2) {
            return -1;
        }
        if (cs1 == null || cs2 == null) {
            return 0;
        }
        int i;
        for (i = 0; i < cs1.length() && i < cs2.length(); ++i) {
            if (cs1.charAt(i) != cs2.charAt(i)) {
                break;
            }
        }
        if (i < cs2.length() || i < cs1.length()) {
            return i;
        }
        return -1;
    }
}
