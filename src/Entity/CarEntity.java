package Entity;

public class CarEntity {
    private int carId;
    private String model;
    private String make;
    private int yearOfMake;
    private String color;
    private String plateNumber;
    private int seats;
    private String fuelType;
    private int mileage;
    private int availability;
    private int price;

    public void setCarDetails(int carId, String model, String make, int yearOfMake, String color,String plateNumber,int seats, String fuelType, int mileage,int availability, int price) {
        this.carId=carId;
        this.model=model;
        this.make=make;
        this.yearOfMake=yearOfMake;
        this.color=color;
        this.plateNumber=plateNumber;
        this.seats=seats;
        this.fuelType=fuelType;
        this.mileage=mileage;
        this.availability=availability;
        this.price=price;
    }
    public String toString() {
        return "Car ID: " + carId +
                ", Model: " + model +
                ", Make: " + make +
                ", Year of Make: " + yearOfMake +
                ", Color: " + color +
                ", Plate Number: " + plateNumber +
                ", Seats: " + seats +
                ", Fuel Type: " + fuelType +
                ", Mileage: " + mileage +
                ", Availability: " + availability +
                ", Price: " + price;
    }


    public void setCarId(int carId) {
        if(carId > 0){
            this.carId = carId;
        }
        else{
            throw new IllegalArgumentException("Car Id should not be negative");
        }

    }

    public int getCarId() {
        return carId;
    }
    public void setModel(String model) {
        if(model != null && model.matches("^[a-zA-Z ]+$")){
            this.model = model.toLowerCase();
        }
        else{
            throw new IllegalArgumentException("should not be null");
        }
    }

    public String getModel() {
        return model;
    }


    public void setMake(String make) {
        if(make != null){
            this.make = make.toLowerCase();
        }
        else{
            throw new IllegalArgumentException("Should not be Null");
        }

    }

    public String getMake() {
        return make;
    }

    public void setYearOfMake(int yearOfMake) {
        if(yearOfMake > 0){
            this.yearOfMake = yearOfMake;
        }
        else{
            throw new IllegalArgumentException("should not be negative");
        }
    }

    public int getYearOfMake() {
        return yearOfMake;
    }

    public void setColor(String color) {
        if(color != null && color.matches("^[a-zA-Z ]+$")){
            this.color = color.toLowerCase();
        }
        else{
            throw new IllegalArgumentException("should not be null");
        }
    }

    public String getColor() {
        return color;
    }

    public void setPlateNumber(String plateNumber) {
        if(plateNumber != null && plateNumber.matches("^[A-Z]{2}\\d{1,2}[A-Z]{1,2}\\d{4}$")){
            this.plateNumber = plateNumber;
        }
        else{
            throw new IllegalArgumentException("should follow this case \"TN14AN7248");
        }
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setSeats(int seats) {
        if(seats > 0){
            this.seats=seats;
        }
        else{
            throw new IllegalArgumentException("should not be negative");
        }
    }

    public int getSeats() {
        return seats;
    }

    public void setFuelType(String fuelType) {
        if (fuelType != null && fuelType.matches("(?i)^(petrol|gasoline|electric|diesel|natural gas|lpg)$")) {
            this.fuelType = fuelType.toLowerCase();
        } else {
            throw new IllegalArgumentException("Fuel type should not be null or is of the wrong type");
        }
    }
    public String getFuelType() {
        if (fuelType != null && !fuelType.isEmpty()) {
            return Character.toUpperCase(fuelType.charAt(0)) + fuelType.substring(1);
        }
        return fuelType;
    }

    public void setMileage(int mileage) {
        if(mileage > 0){
            this.mileage = mileage;
        }
        else{
            throw new IllegalArgumentException("Mileage should be a positive value.");
        }
    }

    public int getMileage() {
        return mileage;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    public int getAvailability() {
        return availability;
    }

    public void setPrice(int price) {
        if(price > 0){
            this.price = price;
        }
        else {
            throw new IllegalArgumentException("Price should not be empty");
        }
    }
    public int getPrice() {
        return price;
    }
}

