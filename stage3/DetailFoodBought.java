import java.util.Map;
import java.util.TreeMap;

public class DetailFoodBought {

    // Initializes variables for food bought by the customer
    private TreeMap<Food, Byte> orderedFood;
    private Customer customer;
    private String paymentType;
    private short paymentAmount;

    /**
     * Constructs DetailFoodBought method
     */

    public DetailFoodBought() {

        this.orderedFood = new TreeMap<>();
    }

    /**
     * Checks if an input food item exists
     * @param aFood item input
     * @return true / false
     */

    public boolean isExist(Food aFood) {

        for (Map.Entry<Food, Byte> anOrder : orderedFood.entrySet()) {
            if (anOrder.getKey().getMenuId() == aFood.getMenuId()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if food ordered is empty
     * @return true / false
     */

    public boolean isEmpty() {

        return orderedFood.isEmpty();
    }

    /**
     * Adds food and quantity to order
     * @param aFood a selected food item
     * @param quantity of the selected food item
     */

    public void addFood(Food aFood, byte quantity) {

        orderedFood.put(aFood, quantity);
    }

    /**
     * Removes selected food from order
     * @param aFood from order
     */

    public void removeFood(Food aFood) {

        orderedFood.remove(aFood);
    }

    /**
     * Gets the ordered food with their corresponding quantities.
     *
     * @return a TreeMap of Food items to quantities ordered
     */

    public TreeMap<Food, Byte> getOrderedFood() {
        return orderedFood;
    }

    /**
     * Sets the ordered food and their corresponding quantities.
     *
     * @param orderedFood a TreeMap of Food items to quantities
     */

    public void setOrderedFood(TreeMap<Food, Byte> orderedFood) {
        this.orderedFood = orderedFood;
    }

    /**
     * Checks if any food has been ordered.
     *
     * @return true if orderedFood is not null and not empty; false otherwise
     */

    public boolean hasOrderedFood() {
        return orderedFood != null && !orderedFood.isEmpty();
    }

    /**
     * Gets the customer who made the order.
     *
     * @return the Customer object
     */

    public Customer getCustomer() {
        return customer;
    }

    /**
     * Sets the customer for this order.
     *
     * @param customer the Customer object to set
     */

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * Checks if a customer has been set.
     *
     * @return true if customerName is not null; false otherwise
     */

    public boolean hasCustomerName() {
        return customer != null;
    }

    /**
     * Gets the payment type used for the order (e.g., cash, credit).
     *
     * @return the payment type as a string
     */

    public String getPaymentType() {
        return paymentType;
    }

    /**
     * Sets the payment type for the order.
     *
     * @param paymentType the payment type to set
     */

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    /**
     * Checks if a payment type has been provided.
     *
     * @return true if paymentType is not null and not empty; false otherwise
     */

    public boolean hasPaymentType() {
        return paymentType != null && !paymentType.isEmpty();
    }

    /**
     * Gets the payment amount for the order.
     *
     * @return the payment amount as a short
     */

    public short getPaymentAmount() {
        return paymentAmount;
    }

    /**
     * Sets the payment amount for the order.
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

}
