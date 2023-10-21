import java.util.Scanner;

public class signUp {
    public Scanner scanner = new Scanner(System.in);
    String name;
    double number;
    String gmail;
    static String password;
    String recheck;
    public void register(){
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your name");
            name = scanner.nextLine();
            System.out.println("enter your number");
            number = scanner.nextDouble();
            scanner.nextLine(); // consume the newline character
            System.out.println("Enter gmail");
            gmail = scanner.nextLine();

passwordCheck();        }
        catch(Exception InputMismatchException) {
            System.out.println("Wrong value");
        }
    }
    public void passwordCheck(){
        System.out.println("Enter password : ");
        password = scanner.nextLine();
        System.out.println("reEnter Password");
        recheck = scanner.nextLine();
        if(!(password.equals(recheck))){
            System.out.println("Password Not Matching\nEnter Again\n");
            passwordCheck();
        }
        else{
            System.out.println("Successfully registered");
        }
    }

}
