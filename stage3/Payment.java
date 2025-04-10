/**
 * Represents an abstract payment made by a customer
 */

public abstract class Payment {

    // Initializes variables to be used for customer payment
    private String paymentId;
    protected short paymentAmount;
    private String paymentType;
    private Customer customer;

    /**
     * Constructs a Payment object for a given customer
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
            return this.paymentId;
        }

        /**
         * * Gets the amount of the payment
         * @return the payment amount
         */

        public short getPaymentAmount() {
            return this.paymentAmount;
        }

        /**
         * Gets the payment type
         * @return the payment type
         */

        public String getPaymentType() {
            return this.paymentType;
        }

        /**
         * Gets the customer associated with the payment
         * @return the customer
         */

        public Customer getCustomer() {
            return this.customer;
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
            return this.paymentType != null && !this.paymentType.isEmpty();
        }

        /**
         * Checks if payment amount is greater than 0
         * @return true if payment amount is greater than 0, false otherwise
         */

        public boolean hasPaymentAmount() {
            return this.paymentAmount > 0;
        }

        /**
         * Processes payment using a card
         */

        public void processPaymentWithCard() {

            this.setPaymentType("card");
            System.out.println("Payment processed with card.");
        }

        /**
         * Processes payment using cash
         */

        public void processPaymentWithCash() {

            this.setPaymentType("cash");
            System.out.println("Payment processed with cash.");
        }

        /**
         * Abstract method to set the payment amount
         * subclasses must implemtn this based on the specific payment logic
         */

        protected abstract void setPaymentAmount();
    }

