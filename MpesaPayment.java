public class MpesaPayment implements Payment {
    private String transactionId;
    private String phoneNumber;

    public MpesaPayment(String transactionId, String phoneNumber) throws Exception {
        InputValidator.checkNotEmpty(transactionId, "Transaction ID");
        InputValidator.checkNotEmpty(phoneNumber, "Phone number");
        
        this.transactionId = transactionId;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void processPayment(double amount) {
        try {
            InputValidator.checkPositive(amount, "Amount");
            System.out.println("Processing M-Pesa payment of $" + amount);
            System.out.println("Phone: " + this.phoneNumber);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void generateReceipt() {
        System.out.println("Receipt - TXN: " + this.transactionId);
    }
}