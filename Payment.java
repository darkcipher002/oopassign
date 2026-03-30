/**
 * Interface for processing standard system payments.
 */
public interface Payment {
    void processPayment(double amount);
    void generateReceipt();
}