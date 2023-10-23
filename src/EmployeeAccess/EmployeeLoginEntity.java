package EmployeeAccess;

public class EmployeeLoginEntity {
    private Double employeeId;
    private String password;
    public void setEmployeeId(Double employeeId){
        this.employeeId = employeeId;
    }
    public Double getEmployeeId(){
        return employeeId;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return password;
    }
}
