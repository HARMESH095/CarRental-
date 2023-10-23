package car;

public class CarReserveRegisterEntity {
    private String name;
    private String dateOfBirth;
    private Character gender;
    private Double licenseNumber;
    private String residentialAddress;
    private Double number;
    private Double emergencyNumber;
    private String fromDate;
    private int days;
    private String address;
    private String username;
    private String password;

    public void setCarReserveRegister(String name, String dateOfBirth, Character gender, Double licenseNumber,
                                      String residentialAddress, Double number, Double emergencyNumber, String fromDate, int days, String address) {
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
    }

    public void setName(String name) {
        if (name != null) {
            this.name = name;
        }
    }

    public String getName() {
        return name;
    }

    public void setDateOfBirth(String dateOfBirth) {
        if (dateOfBirth != null) {
            this.dateOfBirth = dateOfBirth;
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

    public void setNumber(Double number) {
        this.number = number;
    }

    public Double getNumber() {
        return number;
    }

    public void setEmergencyNumber(Double emergencyNumber) {
        this.emergencyNumber = emergencyNumber;
    }

    public Double getEmergencyNumber() {
        return emergencyNumber;
    }

    public void setFromDate(String fromDate) {
        if (fromDate != null) {
            this.fromDate = fromDate;
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

    public Double getLicenseNumber() {
        return licenseNumber;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public String getUsername(){
        return username;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return password;
    }
}
