package OOPs_java.basics;
/*Create a class Game, which allows a user to play "Guess the Number" game once.

        Game should have the following methods:
        Constructor to generate the random number
        takeUserInput() to take a user input of number
        isCorrectNumber() to detect whether the number entered by the user is true
        getter and setter for noOfGuesses
        Use properties such as noOfGuesses(int), etc to get this task done!
 */

import java.util.Scanner;
import java.util.Random;
class Game{
    int guess, generated, tries=0;
   private int noOfGuesses;
   public Game(){  // initialized at the time of object creation
       Random random = new Random();
       generated = random.nextInt(100);
   }
   public void takeUserInput(){ // input
       Scanner sc = new Scanner(System.in);
       guess = sc.nextInt();
   }
   public void isCorrectInput(){ //main logic
       for(int i=0; i<= 100; i++){
           tries +=1;
           if(guess==generated){
               System.out.println("\nBINGO!!! "+guess+" is the correct guess");
               break;
           } else if (guess>generated) {
               System.out.println("Your guess is Bigger  than the number");
               System.out.print(" TRY AGAIN ");
               takeUserInput();
           }else {
               System.out.println("your guess is Smaller than the number");
               System.out.print(" TRY AGAIN ");
               takeUserInput();
           }
       }

   }
   public void SetNoOfGuesses(){ //setter
       noOfGuesses = tries;
   }
    public int GetNoOfGuesses(){ //getter
       return noOfGuesses;
    }
}
public class ch9_exercise_guess_the_number {
    public static void main(String[] args) {
        Game play = new Game();
        System.out.print("Guess the number : ");
        play.takeUserInput();
        play.isCorrectInput();
        play.SetNoOfGuesses();
        System.out.println("Number of tries : "+play.GetNoOfGuesses());

    }
}