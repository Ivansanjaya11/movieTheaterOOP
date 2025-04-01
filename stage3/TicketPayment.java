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
        this.normalTicket = 0;
        this. imaxTicket = 0;
    }

    public void chooseTicket(byte normalQty, byte imaxQty) {
        this.normalTicket = normalQty;
        this.imaxTicket = imaxQty;
        setPaymentAmount();
    }

    @Override
    protected void setPaymentAmount() {
        if(normalTicket >= 0 && imaxTicket >= 0 && normalPrice > 0 && imaxPrice > 0) {
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
