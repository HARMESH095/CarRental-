package Valid;

public class SignUpValidator {
    public static boolean isNameValid(String name) {

        return !name.isEmpty();
    }

    public static boolean isEmailValid(String email) {
        // Implement your email validation logic here
        // Example: Check if the email follows a valid format
        return email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }

    public static boolean isPhoneNumberValid(double phoneNumber) {
        // Implement your phone number validation logic here
        // Example: Check if the phone number follows a valid format
        return String.valueOf(phoneNumber).matches("\\d{10}");
    }

    public static boolean isPasswordValid(String password, String reEnteredPassword) {
        // Implement your password validation logic here
        // Example: Passwords should match
        return password.equals(reEnteredPassword);
    }
}
