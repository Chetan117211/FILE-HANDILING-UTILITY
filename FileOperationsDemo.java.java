import java.io.*;
import java.util.Scanner;

/**
 * Internship Task-1: File Handling Utility
 * This Java program performs:
 * 1. Writing text to a file
 * 2. Reading text from a file
 * 3. Modifying text in a file (word replacement)
 * 
 * Deliverable: Demonstration of file operations with clear documentation.
 * Author: [Your Name]
 * Date: [Today's Date]
 */
public class FileOperationsDemo {

    static final String filePath = "sample.txt"; // File name/path

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // 1. Writing data into file
            System.out.println("Enter text to write into the file:");
            String inputText = scanner.nextLine();
            writeFile(inputText);
            System.out.println("Data successfully written to file.\n");

            // 2. Reading data from file
            System.out.println("Reading data from file:");
            readFile();

            // 3. Modifying data in file
            System.out.println("\nEnter the word to be replaced:");
            String oldWord = scanner.nextLine();
            System.out.println("Enter the new word:");
            String newWord = scanner.nextLine();
            modifyFile(oldWord, newWord);
            System.out.println("File modified successfully.\n");

            // 4. Display modified file
            System.out.println("Modified file content:");
            readFile();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        scanner.close();
    }

    // Method to write into file
    public static void writeFile(String content) throws IOException {
        FileWriter writer = new FileWriter(filePath);
        writer.write(content);
        writer.close();
    }

    // Method to read file content
    public static void readFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while((line = reader.readLine()) != null){
            System.out.println(line);
        }
        reader.close();
    }

    // Method to modify file content
    public static void modifyFile(String oldWord, String newWord) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        StringBuilder contentBuilder = new StringBuilder();
        String line;
        while((line = reader.readLine()) != null){
            line = line.replaceAll(oldWord, newWord);
            contentBuilder.append(line).append("\n");
        }
        reader.close();

        FileWriter writer = new FileWriter(filePath);
        writer.write(contentBuilder.toString());
        writer.close();
    }
}
