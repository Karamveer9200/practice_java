package Others.practice.methods;

import java.util.Scanner;

class user{

    private String result_id; // 'private' - used within the class
    private String result_password;

    private void set_id(String id) {

        if (id.equals( "harry1234@gmail.com")) {

            result_id="true";
        } else {
            result_id="false";
        }
    }
   private void set_password(int password) {

        if (password == 1234) {
            result_password="true";
        } else {
            result_password="false";
        }
    }

    // id and password assigned by their respected setters, but only 'thought' verify() method
    void verify(String id, int password) {
        set_id(id);
        set_password(password);

        if (result_id.equals( "true" ) && result_password.equals( "true") ) {
            welcome_page obj = new welcome_page();
            obj.welcome();
        }else{
            System.out.println("Invalid id or password");
        }
    }
}
 class welcome_page{
    void welcome(){
        System.out.println("Welcome Harry");
    }
}

public class login {
    public static void main(String[] args) {
        String id;
        int password;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your email id: ");
        id=sc.next();
        System.out.print("\n");
        System.out.print("Enter your password: ");
        password=sc.nextInt();

        user a = new user();
        a.verify(id, password);

    }
}
