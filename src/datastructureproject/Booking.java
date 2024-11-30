package datastructureproject;



public class Booking implements Payment {

    private final int Booking_ID ;
    private String Booking_Status;
    private int NumberOfDays;
    private Car car;
    private Customer customer;

    public Booking( int NumberOfDays, Car car, Customer customer) {
        this.Booking_ID = MakeIdReservation();
        setBooking_Status("New");
        setCustomer(customer);
        setCar(car);
        setNumberOfDays(NumberOfDays);
    }

    public int getBooking_ID() {
        return Booking_ID;
    }

    public String getBooking_Status() {
        return Booking_Status;
    }

    public void setBooking_Status(String Booking_Status) {
        this.Booking_Status = Booking_Status;
    }

    public int getNumberOfDays() {
        return NumberOfDays;
    }

    public void setNumberOfDays(int NumberOfDays) {
        this.NumberOfDays = NumberOfDays;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
   
    private final int MakeIdReservation() {
        int min = 1;
        int max = 1000;
        int id = (int) (Math.random() * ((max - min) + 1)) + min;
        return id;
    }

   @Override
public String toString() {
    return String.format(
              "------" +
        "Booking Details:\n" +
        "Booking ID       : %d\n" +
        "Booking Status   : %s\n" +
        "Customer Details : %s\n" +
        "Car Details      : %s\n" +
        "Number of Days   : %d\n",
        Booking_ID, Booking_Status, customer, car, NumberOfDays
    );
}


    @Override
    public double calculateAmount() {
        
        double price = getNumberOfDays() * car.getPrice() ;
        return ((price * INITAIL_FEE) + price);
       }

    }