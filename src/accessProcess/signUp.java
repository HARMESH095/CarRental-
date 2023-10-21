package accessProcess;
import accessEntities.*;
import java.util.Scanner;

public class signUp {
    Scanner input = new Scanner(System.in);
    signUpEntity signUp = new signUpEntity();

    public void register() {
        try {

            System.out.println("Enter your name");
            signUp.setName(input.nextLine());

            System.out.println("enter your number");
            signUp.setNumber(input.nextDouble());

            System.out.println("Enter gmail");
            signUp.setGmail(input.nextLine());

            passwordCheck();
        } catch (Exception InputMismatchException) {
            System.out.println("Wrong value");
        }
    }

    public void passwordCheck() {

        System.out.println("Enter password : ");
        signUp.setPassword(input.nextLine());

        System.out.println("reEnter Password");
        signUp.setRecheck(input.nextLine());
        if (!(signUp.getPassword().equals(signUp.getRecheck()))) {
            System.out.println("Password Not Matching\nEnter Again\n");
            passwordCheck();
        } else {
            System.out.println("Successfully registered");
        }
    }
}
