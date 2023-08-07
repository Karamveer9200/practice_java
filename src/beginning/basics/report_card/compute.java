package beginning.basics.report_card;

public class compute { // INDIVIDUAL subject (PASS/COMPARTMENT)
    String s_1;

    void decision100(float marks) { // SUBJECTS 100 marks
        if (marks >= 45) {
            s_1 = "PASS";
        } else {
            s_1 = "COMP.";
        }
    }

    void decision70(float marks) { // SUBJECTS 70 marks
        if (marks >= 30) {
            s_1 = "PASS";
        } else {
            s_1 = "COMP.";
        }
    }
}
