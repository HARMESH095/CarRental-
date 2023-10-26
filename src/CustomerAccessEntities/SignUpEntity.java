package CustomerAccessEntities;

public class SignUpEntity {

    private String name;
    private double number;
    private String gmail;
    private String password;
    private String recheck;
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setNumber(double number){
        this.number = number;
    }
    public double getNumber(){
        return number;
    }
    public void setGmail(String gmail){
        this.gmail= gmail;
    }
    public String getGmail(){
        return gmail;
    }
    public void setPassword(String password){
        this.password= password;
    }
    public String getPassword(){
        return password;
    }
    public void setRecheck(String recheck){
        this.recheck = recheck;
    }
    public String getRecheck(){
        return recheck;
    }

    }

