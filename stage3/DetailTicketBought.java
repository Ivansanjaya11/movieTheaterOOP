import java.util.ArrayList;

public class DetailTicketBought {
    private ArrayList<byte[]> chosenSeats;
    private byte normalNum;
    private byte imaxNum;
    private Customer customer;
    private short paymentAmount;
    private byte normalPrice;
    private byte imaxPrice;
    private Showtime showtime;

    public String getPaymentType() {
        return this.paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    private String paymentType;

    public DetailTicketBought(byte normalPrice, byte imaxPrice) {
        this.normalPrice = normalPrice;
        this.imaxPrice = imaxPrice;
        this.normalNum = 0;
        this.imaxNum = 0;
    }

    public boolean isEmpty() {
        return this.imaxNum == 0 && this.normalNum == 0;
    }

    public boolean checkSeat(byte rowNum, byte colNum) {
        return this.showtime.getScreen().getSeating().getSeatStatus(rowNum-1, colNum-1);
    }

    /**
     * Gets the list of chosen seat positions.
     *
     * @return an ArrayList of byte arrays representing chosen seats
     */
    public ArrayList<byte[]> getChosenSeats() {
        return chosenSeats;
    }

    /**
     * Sets the list of chosen seat positions.
     *
     * @param chosenSeats the list of seat positions to set
     */
    public void setChosenSeats(ArrayList<byte[]> chosenSeats) {
        this.chosenSeats = chosenSeats;
    }

    /**
     * Checks if any seats have been chosen.
     *
     * @return true if chosenSeats is not null and not empty; false otherwise
     */
    public boolean hasChosenSeats() {
        return chosenSeats != null && !chosenSeats.isEmpty();
    }

    /**
     * Gets the number of normal tickets selected.
     *
     * @return the number of normal tickets
     */
    public byte getNormalNum() {
        return normalNum;
    }

    public void addNormalNum() {
        this.normalNum++;
    }

    /**
     * Sets the number of normal tickets.
     *
     * @param normalNum the number of normal tickets to set
     */
    public void setNormalNum(byte normalNum) {
        this.normalNum = normalNum;
    }

    /**
     * Checks if any normal tickets were selected.
     *
     * @return true if normalNum is greater than 0; false otherwise
     */
    public boolean hasNormalNum() {
        return normalNum > 0;
    }

    /**
     * Gets the number of IMAX tickets selected.
     *
     * @return the number of IMAX tickets
     */
    public byte getImaxNum() {
        return imaxNum;
    }

    public void addImaxNum() {
        this.imaxNum++;
    }

    /**
     * Sets the number of IMAX tickets.
     *
     * @param imaxNum the number of IMAX tickets to set
     */
    public void setImaxNum(byte imaxNum) {
        this.imaxNum = imaxNum;
    }

    /**
     * Checks if any IMAX tickets were selected.
     *
     * @return true if imaxNum is greater than 0; false otherwise
     */
    public boolean hasImaxNum() {
        return imaxNum > 0;
    }

    /**
     * Gets the customer's name.
     *
     * @return the name of the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Sets the customer's name.
     *
     * @param customer the name of the customer to set
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * Checks if a customer name has been provided.
     *
     * @return true if customerName is not null or empty; false otherwise
     */
    public boolean hasCustomerName() {
        return customer != null;
    }

    /**
     * Gets the total payment amount.
     *
     * @return the payment amount
     */
    public short getPaymentAmount() {
        return paymentAmount;
    }

    /**
     * Sets the payment amount.
     *
     * @param paymentAmount the payment amount to set
     */
    public void setPaymentAmount(short paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    /**
     * Checks if a payment amount has been set.
     *
     * @return true if paymentAmount is greater than 0; false otherwise
     */
    public boolean hasPaymentAmount() {
        return paymentAmount > 0;
    }

    /**
     * Gets the price of a normal ticket.
     *
     * @return the normal ticket price
     */
    public byte getNormalPrice() {
        return normalPrice;
    }

    /**
     * Sets the price of a normal ticket.
     *
     * @param normalPrice the price to set
     */
    public void setNormalPrice(byte normalPrice) {
        this.normalPrice = normalPrice;
    }

    /**
     * Checks if a normal ticket price has been set.
     *
     * @return true if normalPrice is greater than 0; false otherwise
     */
    public boolean hasNormalPrice() {
        return normalPrice > 0;
    }

    /**
     * Gets the price of an IMAX ticket.
     *
     * @return the IMAX ticket price
     */
    public byte getImaxPrice() {
        return imaxPrice;
    }

    /**
     * Sets the price of an IMAX ticket.
     *
     * @param imaxPrice the price to set
     */
    public void setImaxPrice(byte imaxPrice) {
        this.imaxPrice = imaxPrice;
    }

    /**
     * Checks if an IMAX ticket price has been set.
     *
     * @return true if imaxPrice is greater than 0; false otherwise
     */
    public boolean hasImaxPrice() {
        return imaxPrice > 0;
    }

    /**
     * Gets the showtime associated with this ticket selection.
     *
     * @return the Showtime object
     */
    public Showtime getShowtime() {
        return showtime;
    }

    /**
     * Sets the showtime for this ticket selection.
     *
     * @param showtime the Showtime to set
     */
    public void setShowtime(Showtime showtime) {
        this.showtime = showtime;
    }

    /**
     * Checks if a showtime has been set.
     *
     * @return true if showtime is not null; false otherwise
     */
    public boolean hasShowtime() {
        return showtime != null;
    }
}
