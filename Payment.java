public interface Payment {
    
    void processPayment(double amount);
    void generateReceipt();
}