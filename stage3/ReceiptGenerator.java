import util.DateAndPaymentTracker;

import java.time.LocalDate;
import java.util.TreeMap;

public class ReceiptGenerator {

    private ReceiptGenerator() {

    }

    /**
     * Generates the receipt for the customer's order, displaying the ordered food and total price.
     */
    public static String generateFoodReceipt(TreeMap<Food, Byte> orderedFood, String customerName, String paymentType, short paymentAmount) {

        // check the date (and update if needed)
        LocalDate date = LocalDate.now();
        if (DateAndPaymentTracker.currentDate.isBefore(date)) {
            DateAndPaymentTracker.currentDate = date;
            DateAndPaymentTracker.foodCustomerNumOfTheDay = 1;
            DateAndPaymentTracker.ticketCustomerNumOfTheDay = 1;
        }

        // set the paymentId
        byte numOfZeroes = (byte) (4-String.valueOf(DateAndPaymentTracker.foodCustomerNumOfTheDay).length());
        String zeroes = "";

        for (int i=0; i<numOfZeroes; i++) {
            zeroes += "0";
        }

        String paymentId = date + "-" + zeroes + DateAndPaymentTracker.foodCustomerNumOfTheDay;

        // updates the inventory (reduce the number of certain ingredients used for the ordered food)

        InventoryManager.updateInventory(orderedFood);

        // prints out the detail of the transaction on screen
        System.out.println("Order #" + paymentId);
        System.out.println("This order is for " + customerName);

        for (Food aFood : orderedFood.keySet()) {
            System.out.print(aFood.getMenuId() + ". ");
            System.out.print(aFood.getMenuName() + "\t");
            System.out.print(orderedFood.get(aFood) + "\t");
            System.out.println("$" + aFood.getPrice());
        }

        System.out.print("Total price is $" + paymentAmount);
        System.out.print(", paid with " + paymentType);
        System.out.println("\nThank you for watching with us!");

        DateAndPaymentTracker.foodCustomerNumOfTheDay++;

        return paymentId;
    }

    public static String generateTicketReceipt(byte[] ticketOrder, String customerName, String paymentType, short paymentAmount) {
        return ""; 
    }
}
