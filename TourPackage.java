public class TourPackage extends TravelService implements Reservable {
    private double price;
    private int availableSeats;

    // Constructor using 'super'
    public TourPackage(String serviceId, String destination, double price, int availableSeats) {
        super(serviceId, destination);
        this.price = price;
        this.availableSeats = availableSeats;
    }

    public double getPrice() { 
        return price; 
    }

    // Overriding abstract method from TravelService parent class
    @Override
    public void showServiceInfo() {
        System.out.println("Tour to " + super.getDestination() + " | Price: $" + this.price);
    }

    // Implementing Reservable interface methods
    @Override
    public boolean checkAvailability() {
        return availableSeats > 0;
    }

    @Override
    public void reserveSeat() {
        if (checkAvailability()) {
            availableSeats--;
            System.out.println("Seat reserved successfully. Seats left: " + availableSeats);
        } else {
            System.out.println("Sorry, no seats available.");
        }
    }
}