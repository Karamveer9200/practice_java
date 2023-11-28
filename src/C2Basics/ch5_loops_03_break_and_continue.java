package C2Basics;

public class ch5_loops_03_break_and_continue {
    public static void main(String[] args) {
    //break and continue in loops / or by using loops

//----------------------------------------------------------
// Break statement
//----------------------------------------------------------

        //below for loop should have run 5 times, but we inserted a
        //specific condition, so loop will exit at 3 runs

//    for( int i=0; i<5; i++ ){
//        System.out.println(i);
//        System.out.println("java is great");
//        if(i==2){
//            System.out.println("ending the loop");
//            break;
//        }
//        System.out.println("loop ends here");
//    }

//----------------------------------------------------------

        // same example for a while loop
        // this time loops exits after 2 runs
        // because if statement is used earlier

//        int i=0;
//        while(i<5){
//            if(i==2){
//                System.out.println("ending the loop");
//                break;
//            }
//            System.out.println(i);
//            System.out.println("java is great");
//            i++;
//        }
//        System.out.println("loop ends here");

//----------------------------------------------------------

        //same example using do-while loop

//        int i=0;
//        do {
//            System.out.println(i);
//            System.out.println("java is great");
//            if (i == 2) {
//                System.out.println("ending the loop");
//                break;
//            }
//            i++;
//        } while(i<5);
//        System.out.println("loops ends here");


//----------------------------------------------------------
// Continue statement
//----------------------------------------------------------

        //below for-loop will execute 5 times
        //when condition is met, it will 'skip that iteration'
        //and control will be taken to the next iteration

//    for( int i=0; i<5; i++ ){
//        if(i==2){
//            System.out.println("\n condition met 'skipping'\n");
//            continue;
//        }
//        System.out.println(i);
//        System.out.println("java is great");
//    }

//----------------------------------------------------------

        //same example using do-while loop
        //will execute 5 times

        int i=0;
        do {
            i++;// above continue .: continue will skip increment++
            if (i == 3) {
                System.out.println("\ncondition met 'skipping'\n");
                continue;
            }
            System.out.println(i);
            System.out.println("java is great");
        } while(i<5);
    }
}
