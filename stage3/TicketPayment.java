public class TicketPayment extends Payment {

    private byte normalTicket;
    private byte imaxTicket;
    private byte normalPrice;
    private byte imaxPrice;

    public TicketPayment(byte normalTicket, byte imaxTicket) {
        this.normalTicket = normalTicket;
        this. imaxTicket = imaxTicket;
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

    public short getTotalPrice() {
        return paymentAmount;
    }

    public void setNormalTicket(byte normalTicket) {
        this.normalTicket = normalTicket;
    }

    public void setImaxTicket(byte imaxTicket) {
        this.imaxTicket = imaxTicket;
    }

    public void setNormalPrice(byte normalPrice) {
        this.normalPrice = normalPrice;
    }

    public void setImaxPrice(byte imaxPrice) {
        this.imaxPrice = imaxPrice;
    }

    public void setTotalPrice(short paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public boolean hasNormalPrice() {

    }

    public boolean hasImaxPrice() {

    }

    public boolean hasNormalTicket() {

    }

    public boolean hasImaxTicket() {

    }

    public void generateReceipt() {

    }

    public void reviewOrder() {

    }
}
