/**
 * @author Heather Santos
 */

import java.util.Scanner;

/**
 * Handles ticket payments for a customer, including selection of a ticket type
 * and payment processing by card or cash
 */

public class TicketPayment extends Payment {

    private byte normalTicket;
    private byte imaxTicket;
    private static byte normalPrice = 10;
    private static byte imaxPrice = 15;
    private Scanner input;

    /**
     * Constructs a TicketPayment object for a specified customer
     * @param customer the customer making the ticket purchase
     */

    public TicketPayment(Customer customer) {
        super(customer); 
        this.input = new Scanner(System.in);
    }

    /**
     * Handles ticket selection and payment process
     * Interacts with the customer to choose ticket type, payment method,
     * and generates a receipt
     */

    public void chooseTicket() {
        byte[] ticketOrder = Order.takeTicketOrder();

        this.normalTicket = ticketOrder[0];
        this.imaxTicket = ticketOrder[1];

        this.setPaymentAmount();

        do {
			// ask for payment method
			System.out.println("How would you like to pay?");
			System.out.println("1. With card");
			System.out.println("2. With cash");
			byte paymentOption = this.input.nextByte();
			if (paymentOption>0 && paymentOption<=2) {
				if (paymentOption==1) {
					//super.setPaymentType("card");
					this.processPaymentWithCard();
				} else {
					//super.setPaymentType("cash");
					this.processPaymentWithCash();
				}
				break;
			}
			System.out.println("Invalid input!");
		} while (true);

        // generate the ticket receipt
		String paymentId = ReceiptGenerator.generateTicketReceipt(ticketOrder, super.getCustomer().getName(), super.getPaymentType(), super.getPaymentAmount(), normalPrice, imaxPrice);

		this.setPaymentId(paymentId);

		// updates the tickets sales report file with the new transaction
		FilesUpdateManager.updateTicketSalesFile(super.getPaymentId(), super.getPaymentAmount(), ticketOrder);
    }

    /**
     * Calculates and sets the total ticket payment amount
     * Only computes if all ticket types and prices are valid
     */

    @Override
    protected void setPaymentAmount() {
        if(this.hasNormalTicket() && this.hasImaxTicket() && this.hasNormalPrice() && this.hasImaxPrice()) {
            this.paymentAmount = (short)((this.normalTicket * normalPrice) + (this.imaxTicket * imaxPrice));
        } 
    }

    /**
     * 
     * @return Number of normal tickets purchased
     */

    public byte getNormalTicket() {
        return this.normalTicket;
    }

    /**
     * 
     * @return number of IMAX tickets purchased
     */

    public byte getImaxTicket() {
        return this.imaxTicket;
    }

    /**
     * 
     * @return the current price of a normal ticket
     */

    public byte getNormalPrice() {
        return this.normalPrice;
    }

    /**
     * 
     * @return the current price of a IMAX ticket
     */

    public byte getImaxPrice() {
        return this.imaxPrice;
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
        this.normalPrice = newPrice;
    }

    /**
     * Sets the new price for an IMAX ticket
     * @param newPrice new price to be set
     */

    public void setImaxPrice(byte newPrice) {
        this.imaxPrice = newPrice;
    }

    /**
     * 
     * @return true if normal ticket price is valid
     */

    public boolean hasNormalPrice() {
        return this.normalPrice > 0;
    }

    /**
     * 
     * @return true if IMAX ticket price is valid
     */

    public boolean hasImaxPrice() {
        return this.imaxPrice > 0;
    }

    /**
     * 
     * @return true if any normal tickets were selected
     */

    public boolean hasNormalTicket() {
        return this.normalTicket > 0;
    }

    /**
     * 
     * @return true if any IMAX tickets were selected
     */

    public boolean hasImaxTicket() {
        return this.imaxTicket > 0;
    }
}
