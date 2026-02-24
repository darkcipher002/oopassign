public class Main {
    public static void main(String[] args) {
        System.out.println("=== TRAVEL AGENCY SYSTEM ===\n");

        
       //customer, tour package, and payment details
        Customer customer1 = new Customer("23233744", "Mark Kigen Yego", "AK1234567");
        TourPackage package1 = new TourPackage("TP100", "Mombasa", 450000, 2);
        MpesaPayment payment1 = new MpesaPayment("UBLIM7EUYK", "+254117293199");

        //User (Customer) details
        System.out.println("--- User Details ---");
        customer1.displayDetails(); 
        System.out.println();

        //TourPackage details and booking
        System.out.println("--- Package Details & Booking ---");
        package1.showServiceInfo();
        
        System.out.println("Checking availability... Available? " + package1.checkAvailability());
        package1.reserveSeat(); // Reduces seats from 2 to 1
        System.out.println();

        // Process payment for the tour package
        System.out.println("--- Payment Processing ---");
        payment1.processPayment(package1.getPrice());
        payment1.generateReceipt();
        
        System.out.println("\n==thank you for using our travel agency\n ==");
    }
}