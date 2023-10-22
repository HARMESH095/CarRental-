package Database;

public class mySqlEntity {
    private String databaseJdbcURL;
    private String databaseUsername;
    private String databasePassword;
    private String inputSql;
    public void setDatabaseJdbcURL(String databaseJdbcURL){
        this.databaseJdbcURL = databaseJdbcURL;
    }
    public String getDatabaseJdbcURL(){
        return databaseJdbcURL;
    }

    public void setdatabaseUsername(String databaseUsername){
        this.databaseUsername = databaseUsername;
    }
    public String getDatabaseUsername(){
        return databaseUsername;
    }
    public void setDatabasePassword(String databasePassword){
        this.databasePassword = databasePassword;
    }
    public String getDatabasePassword(){
        return databasePassword;
    }
    public void setInputSql(String inputSql){
        this.inputSql = inputSql;
    }
    public String getInputSql(){
        return inputSql;
    }



}
