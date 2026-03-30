public class MpesaPayment implements Payment {
    private String transactionId;
    private String phoneNumber;

    public MpesaPayment(String transactionId, String phoneNumber) throws Exception {
        InputValidator.checkNotEmpty(transactionId, "Transaction ID");
        InputValidator.checkPhoneNumber(phoneNumber);
        
        this.transactionId = transactionId;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void processPayment(double amount) {
        try {
            InputValidator.checkPositive(amount, "Amount");
            System.out.println("Processing M-Pesa payment of KSH" + amount + " via " + this.phoneNumber);
        } catch (Exception e) {
            System.out.println("Payment Error: " + e.getMessage());
        }
    }

    @Override
    public void generateReceipt() {
        System.out.println("M-Pesa Receipt - TXN: " + this.transactionId);
    }
}