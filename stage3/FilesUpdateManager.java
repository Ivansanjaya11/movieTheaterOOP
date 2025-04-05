import util.Path;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.TreeMap;

public class FilesUpdateManager {

   private FilesUpdateManager() {

   }

    /**
     * Updates the ticket sales file with the current order's details.
     */
    public static void updateTicketSalesFile(String paymentId, short paymentAmount, byte[] ticketOrder) {

    }

    /**
     * Updates the food sales file with the current order's details.
     */
    public static void updateFoodSalesFile(String paymentId, short paymentAmount, TreeMap<Food, Byte> orderedFood) {
        /*
         * adds the information about the transaction in the following format:
         * LocalDateTime object, Payment amount (total price)
         * then separate these two with ";"
         * after that, append in an alternating way, separated by ","
         * the food name, the quantity, and the total price of one food menu
         */

        String line = "";
        line += paymentId;
        line += ",";
        line +=  LocalDateTime.now(ZoneId.of("US/Mountain")).toString();
        line += ",";
        line += paymentAmount;
        line += ";";

        for (Food aFood : orderedFood.keySet()) {
            line += aFood.getMenuName();
            line += ",";
            line += String.valueOf(orderedFood.get(aFood));
            line += ",";
            line += String.valueOf(aFood.getPrice() * orderedFood.get(aFood));
            line += ",";
        }

        // append to a new line in the food sales report file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(Path.FOOD_SALES_REPORT_PATH, true))) {
            writer.newLine();
            writer.write(line);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Updates the inventory file with the current inventory state.
     * Writes the item name and its remaining quantity to the file.
     */
    public static void updateInventoryFile(ArrayList<Item> itemList) {
        // store all the data in an array of Strings
        String[] lines = new String[itemList.size()];
        for (int i = 0; i < itemList.size(); i++) {
            Item item = itemList.get(i);
            if (item.hasItemName() && item.hasQuantity()) {
                lines[i] = item.getItemName() + "," + item.getQuantity();
            }
        }

        // overwrites the previous data with the lines of String already prepared
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(Path.INVENTORY_REPORT_PATH))) {
            for (String aLine : lines) {
                writer.write(aLine);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Updates the item order file with the details of the ordered item, including the
     * item name, quantity ordered, and total price.
     *
     * @param item The item being ordered.
     * @param buyingQuantity The quantity of the item being ordered.
     * @param totalPrice The total price for the ordered quantity.
     */
    public static void updateItemOrderFile(Item item, short buyingQuantity, short totalPrice) {
        LocalDateTime dateTime = LocalDateTime.now(ZoneId.of("US/Mountain"));
        String line = "";
        line += (dateTime + "," + item.getItemName() + "," + buyingQuantity + "," + totalPrice);

        /*
         * stores the item order receipt into a file with the following format:
         * LocalDateTime, item name, quantity bought, and the total price
         */
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(Path.ITEM_ORDER_REPORT_PATH, true))) {
            writer.newLine();
            writer.write(line);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

}
