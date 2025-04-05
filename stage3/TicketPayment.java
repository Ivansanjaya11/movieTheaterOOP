import javafx.util.Pair;

public class TicketPayment extends Payment {

    private byte normalTicket;
    private byte imaxTicket;
    private static byte normalPrice;
    private static byte imaxPrice;

    static {
        normalPrice = 10;
        imaxPrice = 15;
    }

    public TicketPayment(Customer customer) {
        super(customer); 
    }

    public void chooseTicket() {
        Pair<Byte, Byte> ticketOrder = Order.takeTicketOrder();

        this.normalTicket = ticketOrder.getKey();
        this.imaxTicket = ticketOrder.getValue();
        setPaymentAmount();
    }

    @Override
    protected void setPaymentAmount() {
        if(hasNormalTicket() && hasImaxTicket() && hasNormalPrice() && hasImaxPrice()) {
            this.paymentAmount = (short)((normalTicket * normalPrice) + (imaxTicket * imaxPrice));
        } else {
            this.paymentAmount = 0;
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
