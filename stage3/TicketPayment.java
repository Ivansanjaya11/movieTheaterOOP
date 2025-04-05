import java.util.Scanner;

public class TicketPayment extends Payment {

    private byte normalTicket;
    private byte imaxTicket;
    private static byte normalPrice;
    private static byte imaxPrice;
    private Scanner input;

    static {
        normalPrice = 10;
        imaxPrice = 15;
    }

    public TicketPayment(Customer customer) {
        super(customer); 
        this.input = new Scanner(System.in);
    }

    public void chooseTicket() {
        byte[] ticketOrder = Order.takeTicketOrder();

        this.normalTicket = ticketOrder[0];
        this.imaxTicket = ticketOrder[1];
        setPaymentAmount();

        do {
			// ask for payment method
			System.out.println("How would you like to pay?");
			System.out.println("1. With card");
			System.out.println("2. With cash");
			byte paymentOption = input.nextByte();
			if (paymentOption>0 && paymentOption<=2) {
				if (paymentOption==1) {
					//super.setPaymentType("card");
					processPaymentWithCard();
				} else {
					//super.setPaymentType("cash");
					processPaymentWithCash();
				}
				break;
			}
			System.out.println("Invalid input!");
		} while (true);

        // generate the receipt for the order
		String paymentId = ReceiptGenerator.generateTicketReceipt(ticketOrder, super.getCustomer().getName(), super.getPaymentType(), super.getPaymentAmount());

		super.setPaymentId(paymentId);

		// updates the food sales report file with the new transaction
		FilesUpdateManager.updateTicketSalesFile(super.getPaymentId(), super.getPaymentAmount(), ticketOrder);
    }

    @Override
    protected void setPaymentAmount() {
        if(hasNormalTicket() && hasImaxTicket() && hasNormalPrice() && hasImaxPrice()) {
            this.paymentAmount = (short)((normalTicket * normalPrice) + (imaxTicket * imaxPrice));
        } 
    }

    public byte getNormalTicket() {
        return normalTicket;
    }

    public byte getImaxTicket() {
        return imaxTicket;
    }

    public byte getNormalPrice() {
        return normalPrice;
    }

    public byte getImaxPrice() {
        return imaxPrice;
    }

    public void setNormalTicket(byte normalTicket) {
        this.normalTicket = normalTicket;
        setPaymentAmount();
    }

    public void setImaxTicket(byte imaxTicket) {
        this.imaxTicket = imaxTicket;
        setPaymentAmount();
    }

    public void setNormalPrice(byte newPrice) {
        normalPrice = newPrice;
    }

    public void setImaxPrice(byte newPrice) {
        imaxPrice = newPrice;
    }

    public boolean hasNormalPrice() {
        return normalPrice > 0;
    }

    public boolean hasImaxPrice() {
        return imaxPrice > 0;
    }

    public boolean hasNormalTicket() {
        return normalTicket > 0;
    }

    public boolean hasImaxTicket() {
        return imaxTicket > 0;
    }
}
