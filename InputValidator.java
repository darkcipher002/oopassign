public class InputValidator {
    
    
    public static void checkNotEmpty(String input, String fieldName) throws Exception {
        if (input == null || input.trim().isEmpty()) {
            throw new Exception(fieldName + " cannot be empty!");
        }
    }
    
    // Check if number is positive
    public static void checkPositive(double number, String fieldName) throws Exception {
        if (number <= 0) {
            throw new Exception(fieldName + " must be greater than zero!");
        }
    }
    
    //
    public static void checkOnlyNumbers(String input, String fieldName) throws Exception {
        // Re
        String clean = input.trim();
        
        // Check each character is a digit
        for (int i = 0; i < clean.length(); i++) {
            if (!Character.isDigit(clean.charAt(i))) {
                throw new Exception(fieldName + " must contain only numbers! You entered: " + input);
            }
        }
    }
    
    // NEW: Check phone number format (starts with + and has numbers)
    public static void checkPhoneNumber(String phone) throws Exception {
        checkNotEmpty(phone, "Phone number");
        
        // Must start with +
        if (!phone.startsWith("+")) {
            throw new Exception("Phone number must start with + (e.g., +254712345678)");
        }
        
        // Check rest are numbers only
        String numbersOnly = phone.substring(1); // Remove the +
        checkOnlyNumbers(numbersOnly, "Phone number (after +)");
        
        // Check length (should be 12 digits for +254 format)
        if (numbersOnly.length() != 12) {
            throw new Exception("Phone number must have 12 digits after + (e.g., +254712345678)");
        }
    }
}