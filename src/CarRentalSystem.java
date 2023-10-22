import accessProcess.*;
import java.util.Scanner;


public class CarRentalSystem {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        signUp sign = new signUp();
        loginProcess login = new loginProcess();
       

        System.out.println(" 1. Signup \"If you are new to this website\"");
        System.out.println(" 2. Login \"If you are already a user\"");
        System.out.println("Enter your choice : ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                sign.register();
                break;
            case 2:
                login.log();
                break;
            case 3:
                System.out.println(" -------Thank you!-------");
                System.exit(0);
            default:
                System.out.println("Invalid choice. Please try again.");
        }




    }


}
