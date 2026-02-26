public class Customer extends User {
    
    private String passportNumber;

    
    public Customer(String userId, String name, String passportNumber) {
        super(userId, name);
        this.passportNumber = passportNumber;
    }

    
    public String getPassportNumber() { 
        return passportNumber; 
    }
    
    public void setPassportNumber(String passportNumber) { 
        this.passportNumber = passportNumber; 
    }

    
    @Override
    public void displayDetails() {
        System.out.println("Customer Name: " + super.getName() + " | Passport: " + this.passportNumber);
    }
}