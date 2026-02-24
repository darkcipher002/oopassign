public class Customer extends User {
    // Encapsulation: Private attribute
    private String passportNumber;

    // Constructor using 'super' to call the parent (User) constructor
    public Customer(String userId, String name, String passportNumber) {
        super(userId, name);
        this.passportNumber = passportNumber;
    }

    // Getters and Setters
    public String getPassportNumber() { 
        return passportNumber; 
    }
    
    public void setPassportNumber(String passportNumber) { 
        this.passportNumber = passportNumber; 
    }

    // Method Overriding: Providing the specific implementation for the abstract method
    @Override
    public void displayDetails() {
        System.out.println("Customer Name: " + super.getName() + " | Passport: " + this.passportNumber);
    }
}