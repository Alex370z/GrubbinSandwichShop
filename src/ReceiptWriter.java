import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ReceiptWriter {

    public static void writeOrderToFile(ArrayList<String> order, double total) {
        String filename = "receipts.txt";  // fixed filename

        // Get the current date and time
        String timestamp = new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date());

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write("--- Grubbin Sandwich Deli Receipt ---\n");
            writer.write("Order placed: " + timestamp + "\n\n");
            writer.write("Order details:\n");
            for (int i = 0; i < order.size(); i++) {
                writer.write((i + 1) + ". " + order.get(i) + "\n");
            }
            writer.write("\nTotal: $" + String.format("%.2f", total) + "\n");
            writer.write("\nThank you for your order!\n");
            writer.write("=====================================\n"); // separator line
            System.out.println("Receipt saved to " + filename);
        } catch (IOException e) {
            System.out.println("Error saving receipt: " + e.getMessage());
        }
    }
}
