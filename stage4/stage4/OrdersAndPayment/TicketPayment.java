package stage4.OrdersAndPayment; /**
 * @author Heather Santos
 */

import stage4.AnalyticsAndFiles.FilesUpdateManager;
import stage4.Customer;
import stage4.util.Color;
import stage4.util.LogPrinter;
import stage4.util.LogType;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Handles ticket payments for a customer, including selection of a ticket type
 * and payment processing by card or cash
 */

public class TicketPayment extends Payment {

    // Initializes normal and IMAX tickets quantity
    private byte normalTicket;
    private byte imaxTicket;
    private static byte normalPrice = 10;
    private static byte imaxPrice = 15;
    private final Scanner input;

    /**
     * Constructs a TicketPayment object for a specified customer
     * @param customer the customer making the ticket purchase
     */
    public TicketPayment(Customer customer) {
        super(customer);
        this.input = new Scanner(System.in);

        LogPrinter.println(Color.GREEN, Color.GREEN, LogType.TICKET_PAYMENT,
                "A new ticket payment session has been created!");
    }

    /**
     * Handles ticket selection and payment process
     * Interacts with the customer to choose ticket type, payment method,
     * and generates a receipt
     */
    public boolean chooseTicket() {

        DetailTicketBought detail = new DetailTicketBought(normalPrice, imaxPrice);
        detail = OrderTicket.takeTicketOrder(detail);

        if (detail.isEmpty()) {
            System.out.println("Transaction cancelled!");
            return false;
        }

        ArrayList<byte[]> chosenSeats = detail.getChosenSeats();

        this.normalTicket = detail.getNormalNum();
        this.imaxTicket = detail.getImaxNum();

        this.setPaymentAmount();

        detail.setPaymentAmount(super.getPaymentAmount());

        do {
			// ask for payment method
			System.out.println("How would you like to pay?");
			System.out.println("1. With card");
			System.out.println("2. With cash");
			byte paymentOption = this.input.nextByte();
			if (paymentOption>0 && paymentOption<=2) {
				if (paymentOption==1) {
                    detail.setPaymentType("card");
					this.processPaymentWithCard();
				} else {
                    detail.setPaymentType("cash");
					this.processPaymentWithCash();
				}
				break;
			}
			System.out.println("Invalid input!");
		} while (true);

        detail.setCustomer(this.getCustomer());

        // generate the ticket receipt
		String paymentId = ReceiptGenerator.generateTicketReceipt(detail);

		this.setPaymentId(paymentId);

		// updates the tickets sales report file with the new transaction
		FilesUpdateManager.updateTicketSalesFile(super.getPaymentId(), detail);

        return true;
    }

    /**
     * Calculates and sets the total ticket payment amount
     * Only computes if all ticket types and prices are valid
     */
    @Override
    protected void setPaymentAmount() {

        if((this.hasNormalTicket() || this.hasImaxTicket()) && (this.hasNormalPrice() || this.hasImaxPrice())) {
            this.paymentAmount = (short)((this.normalTicket * normalPrice) + (this.imaxTicket * imaxPrice));
        } 
    }

    /**
     * Returns the number of normal tickets
     *
     * @return Number of normal tickets purchased
     */
    public byte getNormalTicket() {
        return this.normalTicket;
    }

    /**
     * Returns the number of IMAX tickets
     *
     * @return number of IMAX tickets purchased
     */
    public byte getImaxTicket() {
        return this.imaxTicket;
    }

    /**
     * Returns the price of normal tickets
     *
     * @return the current price of a normal ticket
     */
    public byte getNormalPrice() {
        return normalPrice;
    }

    /**
     * Returns the price of IMAX tickets
     *
     * @return the current price of a IMAX ticket
     */
    public byte getImaxPrice() {
        return imaxPrice;
    }

    /**
     * Sets the number of normal tickets and updates payment amount
     * @param normalTicket number of normal tickets
     */
    public void setNormalTicket(byte normalTicket) {
        this.normalTicket = normalTicket;
    }

    /**
     * Sets the number of IMAX tickets and updates the payment amount
     * @param imaxTicket number of IMAX tikets
     */
    public void setImaxTicket(byte imaxTicket) {
        this.imaxTicket = imaxTicket;
    }

    /**
     * Stes the new price for a normal ticket
     * @param newPrice new price to be set
     */
    public void setNormalPrice(byte newPrice) {
        normalPrice = newPrice;
    }

    /**
     * Sets the new price for an IMAX ticket
     * @param newPrice new price to be set
     */
    public void setImaxPrice(byte newPrice) {
        imaxPrice = newPrice;
    }

    /**
     * Checks if the normal screen tickets have a price
     *
     * @return true if normal ticket price is valid
     */
    public boolean hasNormalPrice() {
        return normalPrice > 0;
    }

    /**
     * Checks if the IMAX tickets have a price
     *
     * @return true if IMAX ticket price is valid
     */
    public boolean hasImaxPrice() {
        return imaxPrice > 0;
    }

    /**
     * Checks if the normal screen tickets were selected
     *
     * @return true if any normal tickets were selected
     */
    public boolean hasNormalTicket() {
        return this.normalTicket > 0;
    }

    /**
     * Checks if the IMAX screen tickets were selected
     *
     * @return true if any IMAX tickets were selected
     */
    public boolean hasImaxTicket() {
        return this.imaxTicket > 0;
    }

}
