import util.DateAndPaymentTracker;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class ReceiptGenerator {

    private ReceiptGenerator() {}

    /**
     * creates the payment ID
     * @param date current date
     * @param customerCount customer count
     * @return payment ID
     */
    private static String createPaymentID(LocalDate date, short customerCount) {
        // uses four digits to display the customer count in the payment ID
        byte numOfZeroes = (byte) (4-String.valueOf(customerCount).length());
        String zeroes = "";

        for (int i=0; i<numOfZeroes; i++) {
            zeroes += "0";
        }

        // set the payment ID
        String paymentId = date + "-" + zeroes + customerCount;

        return paymentId;
    }

    /**
     * checks the date and update the customer counter if needed
     * @return current date
     */
    private static LocalDate checkDate() {
        // check the date (and update if needed)
        LocalDate date = LocalDate.now();

        if (DateAndPaymentTracker.currentDate.isBefore(date)) {
            DateAndPaymentTracker.currentDate = date;
            DateAndPaymentTracker.foodCustomerNumOfTheDay = 0;
            DateAndPaymentTracker.ticketCustomerNumOfTheDay = 0;
        }

        return date;
    }

    /**
     * Generates the receipt for the customer's order, displaying the ordered food and total price.
     */
    public static String generateFoodReceipt(DetailFoodBought detail) {
        // get all the necessary data to create the receipt
        TreeMap<Food, Byte> orderedFood = detail.getOrderedFood();
        String customerName = detail.getCustomer().getName();
        String paymentType = detail.getPaymentType();
        short paymentAmount = detail.getPaymentAmount();

        // check the date
        LocalDate date = checkDate();

        // increment the number of food customer
        DateAndPaymentTracker.foodCustomerNumOfTheDay++;

        // sets the payment ID
        String paymentId = createPaymentID(date, DateAndPaymentTracker.foodCustomerNumOfTheDay);

        // updates the inventory (reduce the number of certain ingredients used for the ordered food)
        InventoryManager.updateInventory(orderedFood);

        byte width = 40;

        IntStream.range(0, width).forEach(i -> System.out.print("-"));
        System.out.println();

        // prints out the detail of the transaction on screen
        System.out.println("Order #" + paymentId);
        System.out.println("This order is for " + customerName);

        IntStream.range(0, width).forEach(i -> System.out.print("-"));
        System.out.println();

        // prints out the header of the table
        System.out.println("Food\t\tQty\t\tprice per qty");

        IntStream.range(0, width).forEach(i -> System.out.print("-"));
        System.out.println();

        // display all the food ordered
        for (Food aFood : orderedFood.keySet()) {
            System.out.print(aFood.getMenuName() + "\t\t");
            System.out.print(orderedFood.get(aFood) + "\t\t");
            System.out.println("$" + aFood.getPrice());
        }

        IntStream.range(0, width).forEach(i -> System.out.print("-"));
        System.out.println();

        // prints out the price and payment type
        System.out.print("Total price is $" + paymentAmount);
        System.out.print(", paid with " + paymentType);
        System.out.println("\nThank you for eating with us!");

        // after receipt is printed on the screen, the method returns the payment ID
        return paymentId;
    }

    /**
     * Generates and prints a ticket order receipt for a given customer
     * @return unique payment ID for this transaction
     */

    public static String generateTicketReceipt(DetailTicketBought detail) {
        // get all the necessary data to create the receipt
        byte normalNum = detail.getNormalNum();
        byte imaxNum = detail.getImaxNum();

        byte normalPrice = detail.getNormalPrice();
        byte imaxPrice = detail.getImaxPrice();

        ArrayList<byte[]> chosenSeats = detail.getChosenSeats();
        String customerName = detail.getCustomer().getName();
        String paymentType = detail.getPaymentType();
        short paymentAmount = detail.getPaymentAmount();

        // check the date
        LocalDate date = checkDate();

        //Increment the customer count for the day
        DateAndPaymentTracker.ticketCustomerNumOfTheDay++;

        // sets the payment ID
        String paymentId = createPaymentID(date, DateAndPaymentTracker.ticketCustomerNumOfTheDay);

        byte width = 40;

        IntStream.range(0, width).forEach(i -> System.out.print("-"));
        System.out.println();

        //Print the receipt
        System.out.println("Order #" + paymentId);
        System.out.println("Order Name: " + customerName);

        IntStream.range(0, width).forEach(i -> System.out.print("-"));
        System.out.println();

        // prints the detail of the showtime
        System.out.println("Movie: '" + detail.getShowtime().getMovie().getTitle() + "'");
        System.out.println("Start time: " + detail.getShowtime().getStartTime().toString());
        System.out.println("Screen room #" + detail.getShowtime().getScreen().getScreenID());

        IntStream.range(0, width).forEach(i -> System.out.print("-"));
        System.out.println();

        System.out.println("Ticket type\t\tQty\tTotal price");

        IntStream.range(0, width).forEach(i -> System.out.print("-"));
        System.out.println();

        // print the ticket bought

        if (normalNum > 0) {
            System.out.println("Normal ticket\t " + normalNum + "\t$" + (normalNum * normalPrice));
        }

        if (imaxNum > 0) {
            System.out.println("IMAX ticket\t\t" + imaxNum + "\t$" + (imaxNum * imaxPrice));
        }

        IntStream.range(0, width).forEach(i -> System.out.print("-"));
        System.out.println();

        // prints the seats ordered
        System.out.println("Seats ordered:");

        for (byte[] aSeat : chosenSeats) {
            System.out.println("\t- Seat at (" + (aSeat[0]+1) + ", " + (aSeat[1]) + ")");
        }

        IntStream.range(0, width).forEach(i -> System.out.print("-"));
        System.out.println();

        // prints the total price and payment type
        System.out.print("Total price is $" + paymentAmount);
        System.out.println(", paid with " + paymentType);
        System.out.println("Thank you for watching with us!");

        // after receipt is printed on the screen, the method returns the payment ID
        return paymentId;
    }
}
