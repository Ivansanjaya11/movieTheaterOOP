import util.DateAndPaymentTracker;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class ReceiptGenerator {

    private ReceiptGenerator() {

    }

    /**
     * Generates the receipt for the customer's order, displaying the ordered food and total price.
     */
    public static String generateFoodReceipt(DetailFoodBought detail) {
        TreeMap<Food, Byte> orderedFood = detail.getOrderedFood();
        String customerName = detail.getCustomer().getName();
        String paymentType = detail.getPaymentType();
        short paymentAmount = detail.getPaymentAmount();


        // check the date (and update if needed)
        LocalDate date = LocalDate.now();
        if (DateAndPaymentTracker.currentDate.isBefore(date)) {
            DateAndPaymentTracker.currentDate = date;
            DateAndPaymentTracker.foodCustomerNumOfTheDay = 0;
            DateAndPaymentTracker.ticketCustomerNumOfTheDay = 0;
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
     * @return unique payment ID for this transaction
     */

    public static String generateTicketReceipt(DetailTicketBought detail) {

        byte normalNum = detail.getNormalNum();
        byte imaxNum = detail.getImaxNum();

        byte normalPrice = detail.getNormalPrice();
        byte imaxPrice = detail.getImaxPrice();

        ArrayList<byte[]> chosenSeats = detail.getChosenSeats();
        String customerName = detail.getCustomer().getName();
        String paymentType = detail.getPaymentType();
        short paymentAmount = detail.getPaymentAmount();

        LocalDate date = LocalDate.now();

        //Resets daily counters if the date has changed
        if(DateAndPaymentTracker.currentDate.isBefore(date)) {
            DateAndPaymentTracker.currentDate = date;
            DateAndPaymentTracker.foodCustomerNumOfTheDay = 0;
            DateAndPaymentTracker.ticketCustomerNumOfTheDay = 0;
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

        System.out.println("Movie: " + detail.getShowtime().getMovie().getTitle());
        System.out.println("Start time: " + detail.getShowtime().getStartTime().toString());
        System.out.println("Screen room #" + detail.getShowtime().getScreen().getScreenID());

        IntStream.range(0, 25).forEach(i -> System.out.print("-"));
        System.out.println();

        if (normalNum > 0) {
            System.out.println("Normal ticket\t " + normalNum + "\t$" + (normalNum * normalPrice));
        }

        if (imaxNum > 0) {
            System.out.println("IMAX ticket\t\t" + imaxNum + "\t$" + (imaxNum * imaxPrice));
        }

        IntStream.range(0, 25).forEach(i -> System.out.print("-"));
        System.out.println();

        System.out.println("Seats ordered:");

        for (byte[] aSeat : chosenSeats) {
            System.out.println("\t- Seat at (" + aSeat[0] + ", " + aSeat[1] + ")");
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
