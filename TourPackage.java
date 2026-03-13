public class TourPackage extends TravelService implements Reservable {
    private double price;
    private int availableSeats;

    public TourPackage(String serviceId, String destination, double price, int availableSeats) 
            throws Exception {
        super(serviceId, destination);
        
        // Validate inputs
        InputValidator.checkPositive(price, "Price");
        if (availableSeats < 0) {
            throw new Exception("Available seats cannot be negative!");
        }
        
        this.price = price;
        this.availableSeats = availableSeats;
    }

    public double getPrice() { 
        return price; 
    }

    @Override
    public void showServiceInfo() {
        System.out.println("Tour to " + super.getDestination() + " | Price: $" + this.price);
    }

    @Override
    public boolean checkAvailability() {
        return availableSeats > 0;
    }

    @Override
    public void reserveSeat() {
        if (checkAvailability()) {
            availableSeats--;
            System.out.println("Seat reserved! Seats left: " + availableSeats);
        } else {
            System.out.println("Sorry, no seats available.");
        }
    }
}