import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== TRAVEL AGENCY SYSTEM ===\n");
        
        try {
            //GET CUSTOMER INPUT
            System.out.println("--- Enter Customer Details ---");
            
            System.out.print("Enter User ID: ");
            String userId = scanner.nextLine();
            
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            
            System.out.print("Enter Passport Number: ");
            String passport = scanner.nextLine();
            
            // Create customer
            Customer customer = new Customer(userId, name, passport);
            
            //GET PACKAGE INPUT
            System.out.println("\n--- Enter Package Details ---");
            
            System.out.print("Enter Package ID: ");
            String packageId = scanner.nextLine();
            
            System.out.print("Enter Destination: ");
            String destination = scanner.nextLine();
            
            System.out.print("Enter Price: ");
            double price = scanner.nextDouble();
            
            System.out.print("Enter Available Seats: ");
            int seats = scanner.nextInt();
            scanner.nextLine(); 
            
            // Create package 
            TourPackage tourPackage = new TourPackage(packageId, destination, price, seats);
            
            //  GET PAYMENT INPUT 
            System.out.println("\n--- Enter Payment Details ---");
            
            System.out.print("Enter Transaction ID: ");
            String txnId = scanner.nextLine();
            
            System.out.print("Enter Phone Number: ");
            String phone = scanner.nextLine();
            
            MpesaPayment payment = new MpesaPayment(txnId, phone);
            
            //display details and process booking/payment
            System.out.println("\n========== Customer, Package, Booking & Payment Details ==========");
            
            System.out.println("\nCustomer:");
            customer.displayDetails();
            
            System.out.println("\nPackage:");
            tourPackage.showServiceInfo();
            
            System.out.println("\nBooking:");
            if (tourPackage.checkAvailability()) {
                tourPackage.reserveSeat();
            }
            
            System.out.println("\nPayment:");
            payment.processPayment(tourPackage.getPrice());
            payment.generateReceipt();
            
        } catch (Exception e) {
            //catches any errors from invalid input and displays a user-friendly message
            System.out.println("\n!!! ERROR: " + e.getMessage());
            System.out.println("Please enter valid data.");
            
        } finally {
            
            System.out.println("\n=== Thank you for using the Travel Agency System! ===");
            scanner.close();
        }
    }
}