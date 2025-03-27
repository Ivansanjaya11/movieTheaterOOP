public class TicketPayment extends Payment {

    private byte normalTicket;
    private byte imaxTicket;
    private byte normalPrice;
    private byte imaxPrice;

    public TicketPayment(byte normalTicket, byte imaxTicket) {
        super(null); 
        this.normalTicket = normalTicket;
        this. imaxTicket = imaxTicket;

        this.normalPrice = 10;
        this.imaxPrice = 15;

        short total = (short)((normalTicket * normalPrice) + (imaxTicket * imaxPrice));
        setPaymentAmount(total);
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
        return (short)((normalTicket * normalPrice) + (imaxTicket * imaxPrice));
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

    /*
     * this should be setPaymentAmount overriding from parent class
     * doesnt require arguments
     * will check if all 4 fields are filled correctly
     * if true, calcuate the total amount
     * access the paymentAmount in the parent class directly and assign the total price to it
     */
    public void setTotalPrice(short totalPrice) {
        setPaymentAmount(totalPrice);
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
