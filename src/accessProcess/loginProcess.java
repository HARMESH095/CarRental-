package accessProcess;
import accessEntities.loginEntity;
import java.util.Scanner;

public class loginProcess {

    loginEntity login = new loginEntity();
    Scanner input = new Scanner(System.in);
    public void log(){
        int choice = input.nextInt();
        switch(choice){
            case 1:
                System.out.println("Username : ");
                login.setUsername(input.nextLine());
                break;
            case 2:
                System.out.println("Gmail : ");
                login.setGmail(input.nextLine());
                break;
            case 3:
                System.out.println("Mobile no : ");
                login.setNumber(input.nextDouble());
                break;
        }

        System.out.println("Passcode : ");
        login.setPassword(input.nextLine());


    }

}
