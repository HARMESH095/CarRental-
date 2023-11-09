package CustomerAccessProcess;

import Entity.CustomerLoginEntity;
import main.Options;
import main.UsernamePasswordMatch;

import java.util.HashMap;
import java.util.Scanner;


public class CustomerLoginProcess {
    private final HashMap<String, String> UserPasswordMap = new HashMap<>();
    private final CustomerLoginEntity login = new CustomerLoginEntity();
    private final Scanner input = new Scanner(System.in);

    public void logIn() {

        UsernamePasswordMatch usernamePasswordMatch = new UsernamePasswordMatch();
        Options options = new Options();
        System.out.println("ENTER");
        System.out.println("Username : ");
        login.setUsername(input.nextLine());
        System.out.println("Passcode : ");
        login.setPassword(input.nextLine());

        if(usernamePasswordMatch.check(login.getUsername(), login.getPassword())){
            System.out.println("\n Logged in \n");
            options.Option(login.getUsername());


        }else{
            System.out.println(" ");


        }





    }

}
