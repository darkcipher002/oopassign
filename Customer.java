public class Customer extends User {
    
    private String passportNumber;

    // Constructor with throws (tells Java we might throw an exception)
    public Customer(String userId, String name, String passportNumber) throws Exception {
        super(userId, name);
        
        // Validate passport
        InputValidator.checkNotEmpty(passportNumber, "Passport number");
        this.passportNumber = passportNumber;
    }

    public String getPassportNumber() { 
        return passportNumber; 
    }
    
    public void setPassportNumber(String passportNumber) throws Exception {
        InputValidator.checkNotEmpty(passportNumber, "Passport number");
        this.passportNumber = passportNumber;
    }

    @Override
    public void displayDetails() {
        System.out.println("Customer Name: " + super.getName() + " | Passport: " + this.passportNumber);
    }
}