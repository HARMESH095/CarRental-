package Entity;

public class CarReservationEntity {
    private String name;
    private String dateOfBirth;
    private Character gender;
    private Double licenseNumber;
    private String residentialAddress;
    private String number;
    private String emergencyNumber;
    private String fromDate;
    private int days;
    private String address;
    private String username;
    private String password;
    private String reg_car;

    public void setCarReserveRegister(String name, String dateOfBirth, char gender, double licenseNumber,
                                      String residentialAddress, String number, String emergencyNumber, String fromDate, int days, String address,String reg_car) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.licenseNumber = licenseNumber;
        this.residentialAddress = residentialAddress;
        this.number = number;
        this.emergencyNumber = emergencyNumber;
        this.fromDate = fromDate;
        this.days = days;
        this.address = address;
        this.reg_car = reg_car;
    }

    public void setName(String name) {
        if (name != null && name.matches("^[a-zA-Z ]+$")) {
            this.name = name.toLowerCase();
        }
        else{
            throw new IllegalArgumentException("should not enter any symbols");
        }
    }

    public String getName() {
        return name;
    }

    public void setDateOfBirth(String dateOfBirth) {
        if (dateOfBirth != null && dateOfBirth.matches("^\\d{4}-\\d{2}-\\d{2}")) {
            this.dateOfBirth = dateOfBirth;
        }
        else{
            throw new IllegalArgumentException("Should be in this format YYYY-MM-DD");
        }
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setGender(char gender) {

            this.gender = gender;

    }

    public Character getGender() {
        return gender;
    }

    public void setResidentialAddress(String residentialAddress) {
        if (residentialAddress != null) {
            this.residentialAddress = residentialAddress;
        }
    }

    public String getResidentialAddress() {
        return residentialAddress;
    }

    public void setNumber(String number) {
        if(number != null && number.matches("^\\d{10,12}")){
            this.number = number;
        }
        else{
            throw new IllegalArgumentException("only digits");
        }
    }

    public String getNumber() {
        return number;
    }

    public void setEmergencyNumber(String emergencyNumber) {
        if(emergencyNumber != null && emergencyNumber.matches("^\\d{10,12}")){
            this.emergencyNumber = emergencyNumber;
        }
        else{
            throw new IllegalArgumentException("only digits");
        }
    }

    public String getEmergencyNumber() {
        return emergencyNumber;
    }

    public void setFromDate(String fromDate) {
        if (fromDate != null && fromDate.matches("^\\d{4}-\\d{2}-\\d{2}")) {
            this.fromDate = fromDate;
        }
        else{
            throw new IllegalArgumentException("Should be in this format");
        }
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getDays() {
        return days;
    }

    public void setAddress(String address) {
        if (address != null) {
            this.address = address;
        }
    }

    public String getAddress() {
        return address;
    }

    public void setLicenseNumber(Double licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public double getLicenseNumber() {

        return licenseNumber;
    }
    public void setUsername(String username){
        if(username != null){
            this.username = username;
        }
        else{
            throw new IllegalArgumentException("Should not be empty");
        }
    }
    public String getUsername(){

        return username;
    }
    public void setPassword(String password){
        if(password != null){
            this.password = password;
        }
        else{
            throw new IllegalArgumentException("should not be null");
        }
    }
    public String getPassword(){
        return password;
    }

    public String getReg_car() {
        return reg_car;
    }

    public void setReg_car(String reg_car) {
        this.reg_car = reg_car;
    }


}
