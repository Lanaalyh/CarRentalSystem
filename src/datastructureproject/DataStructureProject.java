package datastructureproject;

import java.util.Scanner;

public class DataStructureProject {

    public static void main(String[] args) {

        LLQueue<Booking> queue = new LLQueue<>();
        SinglyLinkedList<Car> list = new SinglyLinkedList<>();

        Car c1 = new Car("BMW7", 123, true, 150);
        Car c2 = new Car("Tesla-X", 333, true, 125.0);
        Car c3 = new Car("Lucid Air Grand", 789, false, 145.6);
        Car c4 = new Car("Audi A8", 222, true, 145.6);
        Car c5 = new Car("Mercedes", 397, true, 120);
        Car c6 = new Car("Lucid Air Grand", 265, true, 145.6);
        Car c7 = new Car("Jeep", 339, true, 80.3);
        Car c8 = new Car("Ford", 111, true, 75.8);
        Car c9 = new Car("Honda CR-V", 456, true, 98);
        Car c10 = new Car("Toyota Crown", 777, true, 110);

        list.addFirst(c1);
        list.addLast(c2);
        list.addLast(c3);
        list.addLast(c4);
        list.addLast(c5);
        list.addLast(c6);
        list.addLast(c7);
        list.addLast(c8);
        list.addLast(c9);
        list.addLast(c10);

        System.out.println("--------------------------------------------------");
        System.out.println("Welcome to the Car Rental Management System");
        System.out.println("--------------------------------------------------");

        int option = 0;
        Scanner input = new Scanner(System.in);

        do {
            System.out.println(
               "--------------------------------------------------\n" +
                "1 - Display List of Cars\n" +
                "2 - Search for a Car by ID\n" +
                "3 - Show the Car with the Highest Price\n" +
                "4 - Make a Booking\n" +
                "5 - Show Booking Information\n" +
                "6 - Check Next Customer Booking\n" +
                "7 - Cancel a Booking\n" +
                "8 - Display Cars Within a Price Range\n" +
                "9 - Exit\n" +
                "--------------------------------------------------\n" +
                "Please choose an option: "
            );

            option = input.nextInt();
            switch (option) {

                case 1:
                    System.out.println("Available Cars:");
                    list.DisplaySpecialFeatures();
                    System.out.println("--------------------------------------------------");
                    break;

                case 2:
                    System.out.println("Enter Car ID you want to find:");
                    int carId = input.nextInt();
                    System.out.println(list.searchProduct(carId));
                    break;

                case 3:
                    System.out.println("The highest price is: " + list.highestPrice());
                       System.out.println("--------------------------------------------------");
                    break;

                case 4:
                    makeBooking(list, queue);
                    System.out.println("\nBooking Process Complete!");
                    System.out.println("--------------------------------------------------");
                    break;

                case 5:
                    System.out.println("Enter the Booking ID you want to show:");
                    int bookingId = input.nextInt();
                    Booking booking = queue.SearchBookingByID(bookingId);
                    if (booking != null) {
                        System.out.println("Booking Found:");
                        System.out.println(booking);
                    } else {
                        System.out.println("No booking found with ID: " + bookingId);
                    }
                    System.out.println("--------------------------------------------------");
                    break;

                case 6:
                    queue.CheckNextcustomerBooking();
                    break;

                case 7:
                    System.out.print("Enter the Booking ID you want to cancel: ");
                    int cancelId = input.nextInt();
                    queue.CancelBookingByID(cancelId);
                    break;

                case 8:
                    System.out.println("Enter minimum price: ");
                    double minPrice = input.nextDouble();
                    System.out.println("Enter maximum price: ");
                    double maxPrice = input.nextDouble();
                    list.displayCarsWithinPriceRange(minPrice, maxPrice);
                    break;

                case 9:
                    System.out.println("Exiting the system. Thank you!");
                    break;

                default:
                    System.out.println("Invalid option! Please try again.");
            }
        } while (option != 9);
    }
public static void makeBooking(SinglyLinkedList<Car> cars, LLQueue<Booking> bookings) {
    Scanner input = new Scanner(System.in);
    System.out.println("Please enter the car ID you want to rent:");
    int carId = input.nextInt();
    input.nextLine(); 

    Car car = cars.searchProduct(carId);
    if (car != null) {
        System.out.print("Enter Your Full Name: ");
        String fullName = input.nextLine();

        System.out.print("Enter Your ID: ");
        int id = input.nextInt();
        input.nextLine();

        System.out.print("Enter Phone Number: ");
        String phoneNumber = input.nextLine();

        System.out.print("Enter Your Email: ");
        String email = input.nextLine();

        System.out.print("Enter Number of Days You Want to Rent: ");
        int numDays = input.nextInt();

        Customer customer = new Customer(fullName, id, phoneNumber, email);
        Booking booking = new Booking(numDays, car, customer);

        double totalPrice = booking.calculateAmount(); // Calculate total price

     
        System.out.println(booking);
        System.out.println("Total Price: " + totalPrice);

        bookings.enqueue(booking);
        System.out.println("\nThe Booking has been successfully registered!");
    } else {
        System.out.println("Invalid car ID. Try again later!");
    }
    System.out.println("--------------------------------------------------");
}

}
