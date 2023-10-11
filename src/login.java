import java.util.Objects;
import java.util.Scanner;

public class login {
    static String number1;
    static String password1;

    public static void log(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Username : ");
        number1 = scanner.nextLine();
        System.out.println("Passcode : ");
        password1 = scanner.nextLine();
        check();

    }
    public static void check(){
        if(Objects.equals(signUp.password, login.password1)){
            System.out.println("Successfully login!!");
        }
    }
}
