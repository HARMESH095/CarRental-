import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        signUp sign = new signUp();
        System.out.println(" 1. Signup If you are new to this website");
        System.out.println(" 2. Login");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if (choice == 1) {
            sign.register();
        } else if (choice == 2) {
            login.log();
        }
        else{
            System.out.println("error");
        }


        


    }


}
