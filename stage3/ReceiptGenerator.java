import util.DateAndPaymentTracker;

import java.time.LocalDate;
import java.util.TreeMap;
import java.util.stream.IntStream;

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

        IntStream.range(0, 25).forEach(i -> System.out.print("-"));
        System.out.println();

        for (Food aFood : orderedFood.keySet()) {
            System.out.print(aFood.getMenuId() + ". ");
            System.out.print(aFood.getMenuName() + "\t");
            System.out.print(orderedFood.get(aFood) + "\t");
            System.out.println("$" + aFood.getPrice());
        }

        IntStream.range(0, 25).forEach(i -> System.out.print("-"));
        System.out.println();

        System.out.print("Total price is $" + paymentAmount);
        System.out.print(", paid with " + paymentType);
        System.out.println("\nThank you for eating with us!");

        DateAndPaymentTracker.foodCustomerNumOfTheDay++;

        return paymentId;
    }

    /**
     * Generates and prints a ticket order receipt for a given customer
     * @param ticketOrder array with [0] = normal ticket count, [1] IMAX ticket count
     * @param customerName name of customer
     * @param paymentType type of payment used ("card" or "cash")
     * @param paymentAmount total amount paid
     * @return unique payment ID for this transaction
     */

    public static String generateTicketReceipt(byte[] ticketOrder, String customerName, String paymentType, short paymentAmount, byte normalPrice, byte imaxPrice) {

        LocalDate date = LocalDate.now();

        //Resets daily counters if the date has changed
        if(DateAndPaymentTracker.currentDate.isBefore(date)) {
            DateAndPaymentTracker.currentDate = date;
            DateAndPaymentTracker.foodCustomerNumOfTheDay = 1;
            DateAndPaymentTracker.ticketCustomerNumOfTheDay = 1;
        }

        //Create zero padded ticket order number (ie., 0001, 0010)
        byte numOfZeroes = (byte) (4 - String.valueOf(DateAndPaymentTracker.ticketCustomerNumOfTheDay).length());
        String zeros = "";

        for(int i = 0; i < numOfZeroes; i++) {
            zeros += "0";
        }

        String paymentId = date + "-" + zeros + DateAndPaymentTracker.ticketCustomerNumOfTheDay;

        //Print the receipt
        System.out.println("Order #" + paymentId);
        System.out.println("Order Name: " + customerName);

        IntStream.range(0, 25).forEach(i -> System.out.print("-"));
        System.out.println();

        if (ticketOrder[0] > 0) {
            System.out.println("Admission\t " + ticketOrder[0] + "\t$" + (ticketOrder[0] * normalPrice));
        }

        if (ticketOrder[1] > 0) {
            System.out.println("IMAX Admission\t\t" + ticketOrder[1] + "\t$" + (ticketOrder[1] * imaxPrice));
        }

        IntStream.range(0, 25).forEach(i -> System.out.print("-"));
        System.out.println();

        System.out.print("Total price is $" + paymentAmount);
        System.out.println(", paid with " + paymentType);
        System.out.println("\nThank you for watching with us!");

        //Increment the customer count for the day
        DateAndPaymentTracker.ticketCustomerNumOfTheDay++;

        return paymentId;
    }
}
