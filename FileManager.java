import java.io.*;
import java.util.*;

public class FileManager {
    private static final String FILE_NAME = "agency_data.txt";

    public static void saveRecords(List<String> records) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (String record : records) {
                writer.println(record);
            }
            System.out.println("Data saved successfully to " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("File Error: " + e.getMessage());
        }
    }

    public static List<String> loadRecords() {
        List<String> records = new ArrayList<>();
        File file = new File(FILE_NAME);
        
        // Prevent FileNotFoundException on initial run
        if (!file.exists()) {
            return records; 
        }

        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                records.add(fileScanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Error: " + e.getMessage());
        }
        return records;
    }
}