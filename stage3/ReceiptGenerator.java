import javafx.util.Pair;
import util.DateAndPaymentTracker;

import java.time.LocalDate;
import java.util.ArrayList;

public class ReceiptGenerator {

    private ReceiptGenerator() {

    }

    static {

    }

    /**
     * Generates the receipt for the customer's order, displaying the ordered food and total price.
     */
    public static String generateFoodReceipt(ArrayList<Pair<Food, Byte>> orderedFood, Customer customer, String paymentType, short PaymentAmount) {

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





        // updates the inventory (reduce the number of certain ingredients used for the ordered food)

        InventoryManager.updateInventory(orderedFood);

        // prints out the detail of the transaction on screen
        System.out.println("Order #" + paymentId);
        System.out.println("This order is for " + customer.getName());
        for (int i=1; i<=orderedFood.size(); i++) {
            System.out.print(i + ". ");
            System.out.print(orderedFood.get(i).getKey().getMenuName() + "\t");
            System.out.print(orderedFood.get(i).getValue() + "\t");
            System.out.println("$" + orderedFood.get(i).getKey().getPrice());
        }
        System.out.print("Total price is $" + paymentAmount);
        System.out.print(", paid by " + paymentType);
        System.out.println("\nThank you for watching with us!");

        DateAndPaymentTracker.foodCustomerNumOfTheDay++;

        return date + "-" + zeroes + DateAndPaymentTracker.foodCustomerNumOfTheDay;
    }

    public static void generateTicketReceipt() {

    }
}
