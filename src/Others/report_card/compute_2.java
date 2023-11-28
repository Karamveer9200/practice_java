package Others.report_card;

public class compute_2 { // OVERALL decision(P/F), division;
    String div, s_1;
    float per, cgpa;

    void final_result(float marks, String e1, String p1, String c1, String m1, String g1) {

        per = (marks / 500) * 100;
        cgpa = marks / 50;
        if ((marks >= 175) && (e1.equals(p1)) && (c1.equals(m1)) && g1.equals("PASS")) {
            s_1 = "PASS";
        } else {
            s_1 = "FAIL";
        }
        // division calc
        if (s_1.equals("PASS")) {
            if (per >= 90) {
                div = "DISTINCTION";
            } else if (per >= 75) {
                div = "FIRST";
            } else if (per >= 65) {
                div = "SECOND";
            } else if (per >= 45) {
                div = "THIRD";
            } else {
                div = "FOURTH";
            }
        } else {
            div = "N/A";
        }
    }
}
