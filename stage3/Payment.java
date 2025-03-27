public class Payment {

    protected short paymentId;
    protected short paymentAmount;
    protected String paymentType;
    protected Customer customer;

    public Payment(short paymentID, Customer customer) {
        this.paymentId = paymentId;
        this.customer = customer;
    }

        public short getPaymentId() {
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

        public void setPaymentId(short paymentId) {
            this.paymentId = paymentId;
        }

        public void setPaymentAmount(short paymentAmount) {
            this.paymentAmount = paymentAmount;
        }

        public void setPaymentType(String paymentType) {
            this.paymentType = paymentType;
        }

        public void setCustomer(Customer customer) {
            this.Customer = Customer;
        }

        public boolean hasPaymentType() {
            return paymentType != null && !paymentType.isEmpty();
        }

        public void processPaymentWithCard() {
            if("Card".equalsIgnoreCase(paymentType)) {
                System.out.println("Processing payment of $" + paymentAmount + " using card.");
            } else {
                System.out.println("You paid with cash.");    ///need help here with the logic
            }
        }

        public void processPaymentWithCash() {
            if("Cash".equalsIgnoreCase(paymentType)) {
                System.out.println("Cash required to pick up tickets in store.");
            } else {
                System.err.println("You paid with card.");
            }
        }

        public void generateReceipt() {

        }

    }

