package Entity;

public class CustomerSignUpEntity {

    private String name;
    private String number;
    private String gmail;
    private String password;


    public void setName(String name) {
        if (name != null && name.matches("^[a-zA-Z ]+$")) {
            this.name = name.toLowerCase();
        } else {
            throw new IllegalArgumentException("Symbols are not allowed.");
        }
    }

    public String getName() {
        return name;
    }

    public void setNumber(String number) {
        if (number != null && number.matches("^\\d{10,12}")) {
            this.number = number;
        } else {
            throw new IllegalArgumentException("only numbers");
        }
    }

    public String getNumber() {
        return number;
    }

    public void setGmail(String gmail) {
        if (gmail != null && gmail.matches("^[\\w.-]+@[\\w.-]+\\.\\w+$")) {
            this.gmail = gmail;
        } else {
            throw new IllegalArgumentException("Entered Incorrect Email");
        }
    }

    public String getGmail() {
        return gmail;
    }

    public void setPassword(String password) {
        if (password != null && password.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*]).{8,}$")) {
            this.password = password;
        } else {
            throw new IllegalArgumentException("Does not match the requirements");
        }
    }

    public String getPassword() {
        return password;
    }

    public boolean passwordValidate(String password) {
        if (!password.matches(".*[a-z].*") || !password.matches(".*[A-Z].*") || !password.matches(".*\\d.*") || !password.matches(".*[!@#$%^&*?].*")) {
            return false;
        } else {
            return true;
        }
    }

}

