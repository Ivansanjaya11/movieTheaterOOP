/**
 * Represents an abstract payment made by a customer
 */

public abstract class Payment {

    protected String paymentId;
    protected short paymentAmount;
    protected String paymentType;
    protected Customer customer;

    /**
     * COnstructs a Payment object for a given customer
     * @param customer the customer making the payment
     */

    public Payment(Customer customer) {
        this.customer = customer;
        this.paymentType = "Undeclared";
        this.paymentAmount = 0;
    }

    /**
     * Gets the payment ID
     * @return the payment ID
     */

        public String getPaymentId() {
            return paymentId;
        }

        /**
         * Gets the amount of the payment
         * @return the payment amount
         */

        public short getPaymentAmount() {
            return paymentAmount;
        }

        /**
         * Gets the payment type
         * @return the payment type
         */

        public String getPaymentType() {
            return paymentType;
        }

        /**
         * Gets the customer associated with the payment
         * @return the customer
         */

        public Customer getCustomer() {
            return customer;
        }

        /**
         * sets the payment ID
         * @param paymentId the new payment ID
         */

        public void setPaymentId(String paymentId) {
            this.paymentId = paymentId;
        }

        /**
         * sets the payment type
         * @param paymentType the type of payment ie card or cash
         */

        public void setPaymentType(String paymentType) {
            this.paymentType = paymentType;
        }

        /**
         * sets the customer associated with the payment
         * @param customer the customer
         */

        public void setCustomer(Customer customer) {
            this.customer = customer;
        }

        /**
         * checks if the payment type has been set
         * @return true if payment type is not null or empty, false otherwise
         */

        public boolean hasPaymentType() {
            return paymentType != null && !paymentType.isEmpty();
        }

        /**
         * Checks if payment amount is greater than 0
         * @return true if payment amount is greater than 0, false otherwise
         */

        public boolean hasPaymentAmount() {
            return paymentAmount > 0;
        }

        /**
         * Processes payment using a card
         */

        public void processPaymentWithCard() {
            this.paymentType = "Card";
            System.out.println("Payment processed with card.");
        }

        /**
         * Processes payment using cash
         */

        public void processPaymentWithCash() {
            this.paymentType = "Cash";
            System.out.println("Payment processed with cash.");
        }

        /**
         * Abstract method to set the payment amount
         * subclasses must implemtn this based on the specific payment logic
         */

        protected abstract void setPaymentAmount();
    }

