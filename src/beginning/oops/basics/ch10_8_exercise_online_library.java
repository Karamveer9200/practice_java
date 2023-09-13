package beginning.oops.basics;

// You have to implement a library using Java Class "Library"
// Methods: addBook, issueBook, returnBook, showAvailableBooks
// Properties: Array to store the available books,
// Array to store the issued books

import java.util.Scanner;

class Library {
    String[] books = new String[10];
    Library() { // Initial library
        books[0] = "1. Sapiens";
        books[1] = "2. Bible";
        books[2] = "3. Theory of Everything";
        books[3] = "4. 1984";
        books[4] = "5. Constitution";
    }

    public void options_menu() {

        int a;
        System.out.println("-----------------------------");
        System.out.println("options :");
        System.out.println("1 : See all books (Total 10)");
        System.out.println("2 : Issue a book");
        System.out.println("3 : Return a book");
        System.out.println("4 : Add a book");
        System.out.println("5 : Exit");
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();

        switch (a) {
            case 1 -> AllBooks();
            case 2 -> issueBook();
            case 3 -> returnBook();
            case 4 -> addBook();
            case 5 -> System.exit(0); // normal termination of the program
        }
    }

    public void addBook() {
        for (int i = 0; i < books.length; i++) { // index 0 to n-1
            if (this.books[i] == null) { // null if string is empty, then fill that empty space with book name
                System.out.println("Enter the name of the book");

                String name;
                Scanner sc = new Scanner(System.in);
                name = sc.next();

                this.books[i] = Integer.toString(i + 1) + ". " + name; // stores book no. + name
                showAvailableBooks();// display refreshed book names

                System.out.println("want to add another (y/n)");
                char ch;
                ch = sc.next().charAt(0);
                if (ch == 'n' || ch == 'N') {
                    break;
                }
            }
        }
        options_menu(); // go back to options menu
    }

    public void issueBook() {
        int a;
        showAvailableBooks();
        System.out.println("Enter the book number to Issue(0 to exit)");
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        if (a == 0) {
            options_menu();
        } else {
            this.books[a - 1] = this.books[a - 1]+" --Issued(pending)"; // same book name + pending tag
            showAvailableBooks();
            options_menu();
        }

    }

    public void returnBook() {
        showAvailableBooks();
        int a;
        System.out.println("Enter the book number to Return(0 to exit)");
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        if (a == 0) {
            options_menu();
        } else {
            if (this.books[a - 1].endsWith(" --Issued(pending)")) { // if book has a pending tag
                this.books[a - 1] = this.books[a-1].substring(0, this.books[a-1].length() - 17); // deletes the tag
                showAvailableBooks();
                options_menu();
            }else{
                System.out.println("\n");
                System.out.println("Slot full");
                options_menu();
            }
        }

    }
    public void showAvailableBooks() {
        System.out.println("-----------------------------");
        for (String a : this.books) {
            if (a != null) { // ignores the empty elements during printing
                System.out.println(a);
            }
        }
        System.out.println("\n");

    }

    public void AllBooks() {
        showAvailableBooks();
        System.out.print(" ");
        options_menu();
    }


}
// main
    public class ch10_8_exercise_online_library {
        public static void main(String[] args) {

            Library school = new Library();
            school.options_menu();
        }
    }

