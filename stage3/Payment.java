public abstract class Payment {

    protected String paymentId;
    protected short paymentAmount;
    protected String paymentType;
    protected Customer customer;

    public Payment(Customer customer) {
        this.customer = customer;
        this.paymentType = "Undeclared";
        this.paymentAmount = 0;
    }

        public String getPaymentId() {
            return paymentId;
        }

        public short getPaymentAmount() {
            return paymentAmount;
        }

        public String getPaymentType() {
            return paymentType;
        }

        public Customer getCustomer() {
            return customer;
        }

        public void setPaymentId(String paymentId) {
            this.paymentId = paymentId;
        }

        public void setPaymentType(String paymentType) {
            this.paymentType = paymentType;
        }

        public void setCustomer(Customer customer) {
            this.customer = customer;
        }

        public boolean hasPaymentType() {
            return paymentType != null && !paymentType.isEmpty();
        }

        public boolean hasPaymentAmount() {
            return paymentAmount > 0;
        }

        public void processPaymentWithCard() {
            this.paymentType = "Card";
            System.out.println("Payment processed with card.");
        }

        public void processPaymentWithCash() {
            this.paymentType = "Cash";
            System.out.println("Payment processed with cash.");
        }

        protected abstract void setPaymentAmount();
    }

