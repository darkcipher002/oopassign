public class InputValidator {
    public static void checkNotEmpty(String input, String fieldName) throws Exception {
        if (input == null || input.trim().isEmpty()) {
            throw new Exception(fieldName + " cannot be empty!");
        }
    }
    
    public static void checkPositive(double number, String fieldName) throws Exception {
        if (number <= 0) {
            throw new Exception(fieldName + " must be greater than zero!");
        }
    }

    public static void checkPhoneNumber(String phone) throws Exception {
        checkNotEmpty(phone, "Phone number");
        if (!phone.startsWith("+") || phone.length() != 13) {
            throw new Exception("Phone number must start with + and have 12 digits (e.g., +254712345678)");
        }
    }
}