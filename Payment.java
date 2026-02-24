public interface Payment {
    // Abstract methods by default (no body needed)
    void processPayment(double amount);
    void generateReceipt();
}