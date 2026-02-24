public class MpesaPayment implements Payment {
    private String transactionId;
    private String phoneNumber;

    // Constructor
    public MpesaPayment(String transactionId, String phoneNumber) {
        this.transactionId = transactionId;
        this.phoneNumber = phoneNumber;
    }

    // Method Overriding from Payment interface
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing M-Pesa payment of $" + amount + " for phone: " + this.phoneNumber);
    }

    @Override
    public void generateReceipt() {
        System.out.println("Receipt generated. TXN ID: " + this.transactionId);
    }
}