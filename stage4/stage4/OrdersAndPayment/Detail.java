package stage4.OrdersAndPayment;

import stage4.Customer;

public abstract class Detail {

    private Customer customer;
    private String paymentType;
    private short paymentAmount;

    public Detail() {}

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
     * Gets payment type from customer
     * @return payment type
     */
    public String getPaymentType() {

        return this.paymentType;
    }

    /**
     * Sets payment type
     * @param paymentType cash / card
     */
    public void setPaymentType(String paymentType) {

        this.paymentType = paymentType;
    }

    /**
     * Gets the total payment amount.
     *
     * @return the payment amount
     */
    public short getPaymentAmount() {
        return this.paymentAmount;
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
     * Checks if payment type has been selected
     * @return true / false
     */
    public boolean hasPaymentType() {

        return this.paymentType != null;
    }

    /**
     * Checks if a customer name has been provided.
     *
     * @return true if customerName is not null or empty; false otherwise
     */
    public boolean hasCustomer() {
        return this.customer != null;
    }

    /**
     * Checks if a payment amount has been set.
     *
     * @return true if paymentAmount is greater than 0; false otherwise
     */
    public boolean hasPaymentAmount() {
        return this.paymentAmount > 0;
    }

    /**
     * Checks if customer order is empty
     *
     * @return true / false
     */
    public abstract boolean isEmpty();

}
