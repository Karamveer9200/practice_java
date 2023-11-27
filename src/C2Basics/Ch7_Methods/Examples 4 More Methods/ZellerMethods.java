import java.util.Scanner;
import javax.annotation.processing.*;

public class ZellerMethods {

    public static void main(String[] args) {

        //Messages
        final String GET_YR = "Enter the year: ";
        final String GET_MTH = "Enter the month number: ";
        final String GET_DAY = "Enter the day of the month: ";
        final String OUT_MSG = " was/is/will be a ";

        Scanner in = new Scanner(System.in);

        /*
		Get the date from the user - call our method 3 times
         */
        //Get the year
        int year = getDatePart(GET_YR, in);
        //Get the month
        int month = getDatePart(GET_MTH, in);
        //Get the day of the month       
        int day = getDatePart(GET_DAY, in);

        //Get the day number
        int dayNumber = getDayNumber(year, month, day);

        //Convert it to a day name
        String dayName = getDayName(dayNumber);
        
        //Print the date out
        printDate(dayName, year, month, day);
    }

    /*
    Method to get a number - prints a message (msg - passed as a parameter), using
    a Scanner (in - passed as another parameter) and returns an integer. You use it
    like (e.g. to get the year) int year = getDatePart("enter the year", in);
     */
    public static int getDatePart(String msg, Scanner in) {
        System.out.print(msg);
        int val = in.nextInt();
        in.nextLine(); //Discard the unread newline
        return val;
    }

    /*
    Method that users Zeller's algorithm to compute the day of the week
    We pass three integer parameters - year, month, day - and return the day 
    number in the range 0-6
     */
    public static int getDayNumber(int year, int month, int day) {

        //Fix month and day if month = Jan or Feb
        if (month == 1 || month == 2) {
            month = month + 12;
            year = year - 1;
        }

        /* Implementation of the Algorithim - the terms
		   year/4 - year/100 + year/400 - corrects for leap years
		   day.+ 13 * (month + 1)/5 - handles different length months
         */
        int leapYrCorrection = year / 4 - year / 100 + year / 400;
        int monthLength = 13 * (month + 1) / 5;

        int dayCount = day + monthLength + year + leapYrCorrection;

        //days must be in the range of 0 - 6
        return dayCount % 7;
    }

    /*
    Convert a day number into a name - one int parameter but this time returns
    a string
     */
    public static String getDayName(int dayNumber) {
        String dayName;
        switch (dayNumber) {
            case 1:
                dayName = "Sunday";
                break;
            case 2:
                dayName = "Monday";
                break;
            case 3:
                dayName = "Tuesday";
                break;
            case 4:
                dayName = "Wednesday";
                break;
            case 5:
                dayName = "Thursday";
                break;
            case 6:
                dayName = "Friday";
                break;
            case 0:
                dayName = "Saturday";
                break;
            default:
                dayName = "Error";
                break;
        }
        return dayName;

    }
    
    /*
    This method does not return anything so the return type is void
    */
    public static void printDate(String dayName, int year, int month, int day){
        System.out.println("This day " + day + "/" + month + "/" + year + 
                " is a " + dayName);
    }
}
