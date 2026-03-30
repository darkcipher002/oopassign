public class Customer extends User {
    private String passportNumber;

    public Customer(String userId, String name, String passportNumber) throws Exception {
        super(userId, name);
        InputValidator.checkNotEmpty(passportNumber, "Passport number");
        this.passportNumber = passportNumber;
    }

    public static Customer fromFileString(String line) throws Exception {
        String[] parts = line.split(",");
        return new Customer(parts[1], parts[2], parts[3]);
    }

    @Override
    public String toString() {
        return "CUSTOMER," + getUserId() + "," + getName() + "," + this.passportNumber;
    }

    @Override
    public void displayDetails() {
        System.out.println("Customer Name: " + getName());
        System.out.println("User ID: " + getUserId());
        System.out.println("Passport: " + this.passportNumber);
    }
}