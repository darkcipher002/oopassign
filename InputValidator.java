public class InputValidator {
    
    // Simple check if string is empty
    public static void checkNotEmpty(String input, String fieldName) throws Exception {
        if (input == null || input.trim().isEmpty()) {
            throw new Exception(fieldName + " cannot be empty!");
        }
    }
    
    // Simple check if number is positive
    public static void checkPositive(double number, String fieldName) throws Exception {
        if (number <= 0) {
            throw new Exception(fieldName + " must be greater than zero!");
        }
    }
}