import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Customer> customerMap = new HashMap<>();
        Map<String, TourPackage> packageMap = new HashMap<>();

        System.out.println("=== TRAVEL AGENCY MANAGEMENT SYSTEM ===");

        // 1. Load existing data from file at startup
        try {
            List<String> loadedLines = FileManager.loadRecords();
            for (String line : loadedLines) {
                if (line.startsWith("CUSTOMER")) {
                    Customer cust = Customer.fromFileString(line);
                    customerMap.put(cust.getUserId(), cust);
                    // Also map by passport for dual-validation
                    customerMap.put(line.split(",")[3], cust); 
                } else if (line.startsWith("PACKAGE")) {
                    TourPackage pkg = TourPackage.fromFileString(line);
                    packageMap.put(pkg.getServiceId(), pkg);
                }
            }
        } catch (Exception e) {
            System.out.println("Starting with a fresh database.");
        }

        while (true) {
            System.out.println("\n1. REGISTER NEW CUSTOMER");
            System.out.println("2. VALIDATE CUSTOMER (BY ID/PASSPORT)");
            System.out.println("3. EXIT");
            System.out.print("Select an option: ");
            
            String choice = sc.nextLine();

            try {
                if (choice.equals("1")) {
                    System.out.print("Enter Customer ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter Full Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Passport Number: ");
                    String passport = sc.nextLine();

                    Customer newCust = new Customer(id, name, passport);
                    customerMap.put(id, newCust);
                    customerMap.put(passport, newCust);

                    System.out.print("Enter M-Pesa Transaction ID: ");
                    String txn = sc.nextLine();
                    System.out.print("Enter Phone Number: ");
                    String phone = sc.nextLine();
                    
                    MpesaPayment payment = new MpesaPayment(txn, phone);
                    double regFee = 50.0;
                    payment.processPayment(regFee);

                    System.out.println("\nSUCCESS: " + name + " has paid " + regFee + 
                                       " | ID: " + id + " | Phone: " + phone + " | TXN: " + txn);
                    
                    saveAllData(customerMap, packageMap);

                } else if (choice.equals("2")) {
                    System.out.print("Enter ID or Passport Number to Validate: ");
                    String key = sc.nextLine();

                    if (customerMap.containsKey(key)) {
                        System.out.println("\n--- VALIDATION SUCCESSFUL ---");
                        customerMap.get(key).displayDetails();
                    } else {
                        System.out.println("\n[!] Error: No record found for: " + key);
                    }

                } else if (choice.equals("3")) {
                    System.out.println("Exiting System...");
                    break;
                }
            } catch (Exception e) {
                System.out.println("System Error: " + e.getMessage());
            }
        }
        sc.close();
    }

    private static void saveAllData(Map<String, Customer> customers, Map<String, TourPackage> packages) {
        Set<Customer> distinctCustomers = new HashSet<>(customers.values());
        List<String> data = new ArrayList<>();
        for (TourPackage p : packages.values()) data.add(p.toString());
        for (Customer c : distinctCustomers) data.add(c.toString());
        FileManager.saveRecords(data);
    }
}