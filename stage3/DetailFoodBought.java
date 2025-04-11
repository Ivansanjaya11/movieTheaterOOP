import java.util.Map;
import java.util.TreeMap;

public class DetailFoodBought extends Detail{

    // Initializes variables for food bought by the customer
    private TreeMap<Food, Byte> orderedFood;

    /**
     * Constructs DetailFoodBought method
     */

    public DetailFoodBought() {
        super();
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
    @Override
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
}
