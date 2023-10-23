package car;

public class carEntity {
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
        this.carId = carId;
    }

    public int getCarId() {
        return carId;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getMake() {
        return make;
    }

    public void setYearOfMake(int yearOfMake) {
        this.yearOfMake = yearOfMake;
    }

    public int getYearOfMake() {
        return yearOfMake;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getSeats() {
        return seats;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getMileage() {
        return mileage;
    }


    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    public int getAvailability() {
        return availability;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}

