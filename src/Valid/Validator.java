package Valid;

public class Validator {
    public static boolean isValidName(String name){
        return name.matches("^[a-zA-Z ]+$");

    }
}
