import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== TRAVEL AGENCY SYSTEM ===\n");
        
        try {
            //  GET CUSTOMER INPUT 
            System.out.println(" Enter Customer Details");
            
            System.out.print("Enter User ID: ");
            String userId = scanner.nextLine();
            
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            
            System.out.print("Enter Passport Number: ");
            String passport = scanner.nextLine();
            
            Customer customer = new Customer(userId, name, passport);
            
            //   GET PACKAGE INPUT     
            System.out.println("\n--- Enter Package Details ---");
            
            System.out.print("Enter Package ID: ");
            String packageId = scanner.nextLine();
            
            System.out.print("Enter Destination: ");
            String destination = scanner.nextLine();
            
            System.out.print("Enter Price: ");
            double price = scanner.nextDouble();
            
            System.out.print("Enter Available Seats: ");
            int seats = scanner.nextInt();
            scanner.nextLine(); // Clear buffer
            
            TourPackage tourPackage = new TourPackage(packageId, destination, price, seats);
            
            // GET PAYMENT INPUT 
            System.out.println("\nEnter Payment Details ");
            
            System.out.print("Enter Transaction ID: ");
            String txnId = scanner.nextLine();
            
            System.out.print("Enter Phone Number (+254...): ");
            String phone = scanner.nextLine();
            
            // 
            MpesaPayment payment = new MpesaPayment(txnId, phone);
            
            
            System.out.println("CUSTOMER DETAILS");
            customer.displayDetails();
            tourPackage.showServiceInfo();
            
            if (tourPackage.checkAvailability()) {
                tourPackage.reserveSeat();
            }
            
            payment.processPayment(tourPackage.getPrice());
            payment.generateReceipt();
            
        } catch (InputMismatchException e) {
            //
            System.out.println("\n!!! ERROR: Please enter a valid number where required!");
            
        } catch (Exception e) {
            // Catches ALL other exceptions (empty fields, invalid phone, etc.)
            System.out.println("\n!!! ERROR: " + e.getMessage());
            
        } finally {
            System.out.println("\nThank you for using the Travel Agency System!");
            scanner.close();
        }
    }
}