public class MpesaPayment implements Payment {
    private String transactionId;
    private String phoneNumber;

    
    public MpesaPayment(String transactionId, String phoneNumber) {
        this.transactionId = transactionId;
        this.phoneNumber = phoneNumber;
    }

    
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing M-Pesa payment of $" + amount + " for phone: " + this.phoneNumber);
    }

    @Override
    public void generateReceipt() {
        System.out.println("Receipt generated. TXN ID: " + this.transactionId);
    }
}