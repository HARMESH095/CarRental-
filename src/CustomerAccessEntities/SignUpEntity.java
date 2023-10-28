package CustomerAccessEntities;

public class SignUpEntity {

    private String name;
    private double number;
    private String gmail;
    private String password;
    private String recheck;
    public void setName(String name){
        if( name != null && name.matches("^[a-zA-Z ]+$")){
            this.name = name.toLowerCase();
        }
        else{
            throw new IllegalArgumentException("Symbols are not allowed.");
        }
    }
    public String getName(){
        return name;
    }
    public void setNumber(double number){
        if (number > 0) {
            this.number = number;
        }
        else{
            throw new IllegalArgumentException("only numbers");
        }
    }
    public double getNumber(){
        return number;
    }
    public void setGmail(String gmail){
        if(gmail != null && gmail.matches("^[\\w.-]+@[\\w.-]+\\.\\w+$")){
            this.gmail= gmail;
        }
        else {
            throw new IllegalArgumentException("Entered Incorrect Email");
        }
    }
    public String getGmail(){
        return gmail;
    }
    public void setPassword(String password){
        if(password != null && password.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[\\W_])[A-Za-z\\d\\W_]{8,}$\n")){
            this.password = password;
        }
        else{
            throw new IllegalArgumentException("Does not match the requirements");
        }
    }
    public String getPassword(){
        return password;
    }
    public void setRecheck(String recheck){
        if(recheck != null){
            this.recheck = recheck;
        }
        else{
            throw new IllegalArgumentException("should not be null");
        }

    }
    public String getRecheck(){
        return recheck;
    }

    }

