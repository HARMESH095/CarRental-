package EmployeeAccess;

public class EmployeeLoginEntity {
    private Double employeeId;
    private String password;
    private String employeeChoice;
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
    public void setEmployeeChoice(String employeeChoice) {
        if ("exit".equals(employeeChoice)) {
            this.employeeChoice = employeeChoice;
        } else if (employeeChoice.isEmpty()) {
            this.employeeChoice = "entry";
        } else {
            this.employeeChoice = "wrong";
        }
    }

    public String getEmployeeChoice(){
        return employeeChoice;
    }
}
