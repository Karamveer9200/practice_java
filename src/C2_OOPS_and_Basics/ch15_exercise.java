package C2_OOPS_and_Basics;
/*
        Exercise 6: You have to create a custom calculator with the following operations:
        1. + -> Addition
        2. - -> Subtraction
        3. * -> Multiplication
        4. / -> Division
        which throws the following exceptions:
        1. Invalid input Exception ex: 8 & 9
        2. Cannot divide by 0 Exception
        3. Max Input Exception if any of the inputs is greater than 100000
        4. Max Multiplier Reached Exception - Don't allow any multiplication input to be greater than 7000
         */

import java.util.InputMismatchException;
import java.util.Scanner;
public class ch15_exercise {
    public static void main(String[] args) throws divide_by_zero, max_multiplier {
        API_CALC api = new API_CALC();

        api.take_inputs();
        
    }
}

// enforcing the set conditions
// calling class inputs to take user inputs then, passing the inputs to class guiding_inputs
class API_CALC {
    float a, b,calc;
    char op;
    InputAndValidation ac = new InputAndValidation();
    InputAndValidation ab = new InputAndValidation();
    guiding_inputs gi = new guiding_inputs();

    public void take_inputs() throws divide_by_zero, max_multiplier {
        System.out.print("\n");
        ac.resetFlags();
        ab.resetFlags();

        a = ac.number_validation();
        op = ab.operator_validation();

        // multiplier > 7000 & divide by 0
        try{
            b = ab.number_validation();
            if(op == '*' && b > 7000){
                throw new max_multiplier();
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            take_inputs(); // reset by recursion
        }
        try{
            b = ab.number_validation();
            if(op == '/' && b == 0){
                throw new divide_by_zero();
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            take_inputs(); // reset by recursion
        }

        // printing the result
        calc = gi.guide(a, op, b);// sending inputs to guide() then,to class compute
        System.out.println("\n " + calc);

        // to keep on taking inputs
        while (true) {
            // -- important --
            // Reset flags for the next iteration
            // after a valid input flags becomes false; Hence, the loop will not execute to get the input
            // we have to reset them to true, For them to be able to run again

            ab.resetFlags(); // flags = true

            a=calc;
            op = ab.operator_validation();

            // multiplier > 7000 & divide by 0
            try{
                b = ab.number_validation();
                if(op == '*' && b > 7000){
                    throw new max_multiplier();
                }
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
                take_inputs(); // reset by recursion
            }
            try{
                b = ab.number_validation();
                if(op == '/' && b == 0){
                    throw new divide_by_zero();
                }
            }
            catch(Exception e){
                System.out.println(e.getMessage());
                take_inputs(); // reset by recursion
            }

            calc = gi.guide(a, op, b);// sending inputs to guide() then,to class compute
            System.out.println("\n " + calc);
        }
    }

}

// taking and validating inputs
class InputAndValidation{
    char operator;
    float a;
    boolean flag_a=true;
    boolean flag_c=true;
    Scanner sc =new Scanner(System.in);


    // validating numbers
    public float number_validation() {
        while (flag_a) {
            try {
                System.out.print(":");
                    a = sc.nextFloat();
                    if (a > 100000) {
                        throw new calculator_display();
                    }
                    flag_a = false;
                }catch(InputMismatchException e){
                    System.out.println("Invalid input!");
                    // -- important --
                    sc.nextLine(); // if we don't consume the invalid input, we will get an infinite loop
                } catch (Exception e){
                System.out.println(e.getMessage());
                }
        }
        return a;
    }

    // validating operator
    public char operator_validation() {
        while (flag_c) {
            try {
                System.out.print(":");
                operator = sc.next().charAt(0);
                if (operator != '+' && operator != '-' && operator != '*' && operator != '/') {
                    throw new calculator_errors();
                }
                flag_c = false;
                }catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            return operator;
    }
    // flag reset to avid infinite loop
    public void resetFlags(){
        flag_a = true;
        flag_c = true;
    }

}



// Guiding inputs to class compute
class guiding_inputs{
    float result;
    compute x = new compute();
    public float guide(float a, char op, float b){
        switch (op){
            case '+':
                result = x.add(a,b);
            break;
            case '-':
                result = x.sub(a,b);
            break;
            case '*':
                result = x.mul(a,b);
            break;
            case '/':
                result = x.div(a,b);
            break;
        }
        return result;
    }
}


// Computing
class compute{

    // GETTERS/OPERATORS
    public float add(float a, float b){
        return a+b;
    }
    public float sub(float a, float b){
        return a-b;
    }
    public float mul(float a, float b){
        return a*b;
    }
    public float div(float a ,float b){
        return a/b;
    }
}

//Custom errors
class calculator_errors extends Exception {
    @Override
    public String getMessage() {
        return "not a valid operator!";
    }
}
class calculator_display extends Exception {

    @Override
    public String getMessage() {
        return "Max limit Exceeded!";
    }
}
class max_multiplier extends Exception{
    @Override
    public String getMessage() {
        return "Max Multiplier Reached!";
    }
}
class divide_by_zero extends Exception{
    @Override
    public String getMessage() {
        return "Cannot divide by 0";
    }
}