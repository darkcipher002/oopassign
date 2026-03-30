public class TourPackage extends TravelService implements Reservable {
    private double price;
    private int availableSeats;

    public TourPackage(String id, String dest, double price, int seats) throws Exception {
        super(id, dest);
        InputValidator.checkPositive(price, "Price");
        this.price = price;
        this.availableSeats = seats;
    }

    @Override
    public void showServiceInfo() {
        System.out.println("[" + getServiceId() + "] " + getDestination() + " - $" + price + " (Seats: " + availableSeats + ")");
    }

    @Override
    public String toString() {
        return "PACKAGE," + getServiceId() + "," + getDestination() + "," + price + "," + availableSeats;
    }

    @Override public boolean checkAvailability() { return availableSeats > 0; }
    @Override public void reserveSeat() { availableSeats--; }
    public double getPrice() { return price; }

    // Reconstruct object from CSV file line
    public static TourPackage fromFileString(String line) throws Exception {
        String[] parts = line.split(",");
        if (parts.length == 5 && parts[0].equals("PACKAGE")) {
            return new TourPackage(parts[1], parts[2], Double.parseDouble(parts[3]), Integer.parseInt(parts[4]));
        }
        throw new Exception("Corrupted package data format in file.");
    }
}