package datastructureproject;

public class Car {

    private String Car_Model;
    private final int CarID;
    private Boolean avalability;
    private double price;

    
    public Car(String Car_Model, int CarID, Boolean avalability, double price) {
        this.Car_Model = Car_Model;
        this.CarID = CarID;
        this.avalability = avalability;
        this.price = price;
    }

    
    public String getCar_Model() {
        return Car_Model;
    }

    public void setCar_Model(String Car_Model) {
        this.Car_Model = Car_Model;
    }

    public int getCarID() {
        return CarID;
    }

    public Boolean getAvalability() {
        return avalability;
    }

    public void setAvalability(Boolean avalability) {
        this.avalability = avalability;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

   @Override
public String toString() {
    return "\nCar Model: " + Car_Model +
           ", Car ID: " + CarID +
           ", Availability: " + avalability +
           ", Price: " + price;
}

}