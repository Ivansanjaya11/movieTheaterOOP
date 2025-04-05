import java.util.HashMap;
import java.util.TreeMap;

public class InventoryManager {
    private static Inventory inventory;

    private InventoryManager() {

    }

    static {
        inventory = new Inventory();
    }

    /**
     * Gets the inventory of available food items.
     *
     * @return the inventory of food items
     */
    public static Inventory getInventory() {
        if (hasInventory()) {
            return inventory;
        }
        inventory = new Inventory();
        return inventory;
    }

    /**
     * Sets the inventory of available food items.
     *
     * @param newInventory the new inventory of food items
     */
    public static void setInventory(Inventory newInventory) {
        inventory = newInventory;
    }

   /**
	 * Checks if the inventory has been initialized.
	 *
	 * @return true if the inventory is not null, false otherwise
	 */
	public static boolean hasInventory() {
		return !(inventory==null);
	}


    /**
     * Updates the inventory after the food items have been ordered.
     */
    public static void updateInventory(TreeMap<Food, Byte> orderedFood) {
        try {
            if (hasInventory()) {
                // calls the updateInventory method in Inventory object and passes the ordered food array list
                inventory.updateInventory(orderedFood);
            } else {
                throw new NullPointerException("Inventory has not been assigned yet!");
            }
        } catch (NullPointerException e) {
            System.err.println(e.getMessage());
        }
    }
}
