package Database;

public class mySqlEntity {
    private String jdbcURL;
    private String username;
    private String database_password;
    private String name;
    private double number;
    private String gmail;
    private String password;
    public void setJdbcURL(String jdbcURL){
        this.jdbcURL = jdbcURL;
    }
    public String getJdbcURL(){
        return jdbcURL;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public String getUsername(){
        return username;
    }
    public void set_database_password(String database_password){
        this.database_password = database_password;
    }
    public String get_database_password(){
        return database_password;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getname(){
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


}
