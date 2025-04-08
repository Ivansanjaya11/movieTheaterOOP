import java.util.ArrayList;
import java.util.TreeMap;

public class Food implements Comparable<Food>{
	private byte menuId;
	private String menuName;
	private byte price;
	private TreeMap<Item, Byte> recipe;

	/**
	 * Constructs a Food object with the specified menu ID, name, and price.
	 * @param menuId - The unique ID of the menu.
	 * @param menuName The name of the menu item.
	 * @param price The price of the menu item.
	 */
	public Food(byte menuId, String menuName, byte price) {
		this.menuId = menuId;
		this.menuName = menuName;
		this.price = price;
		this.recipe = new TreeMap<>();
	}

	/**
	 * Gets the menu ID.
	 * @return The menu ID.
	 */
	public byte getMenuId() {
		if (hasMenuId()) {
			return this.menuId;
		}
		return -1;
	}

	/**
	 * Gets the menu name.
	 * @return The menu name.
	 */
	public String getMenuName() {
		if (hasMenuName()) {
			return this.menuName;
		}
		return "Menu name not assigned!";
	}

	/**
	 * Gets the price of the menu item.
	 * @return The price.
	 */
	public byte getPrice() {
		if (hasPrice()) {
			return this.price;
		}
		return -1;
	}

	/**
	 * Gets the recipe as a HashMap of items and their quantities.
	 * @return The recipe HashMap.
	 */
	public TreeMap<Item, Byte> getRecipe() {
		return this.recipe;
	}

	/**
	 * Sets the menu ID.
	 * @param menuId The new menu ID.
	 */
	public void setMenuId(byte menuId) {
		this.menuId = menuId;
	}

	/**
	 * Sets the menu name.
	 * @param menuName The new menu name.
	 */
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	/**
	 * Sets the price of the menu item.
	 * @param price The new price.
	 */
	public void setPrice(byte price) {
		this.price = price;
	}

	/**
	 * Adds an item and its quantity to the recipe.
	 * @param item The item to be added.
	 * @param quantityUsed The quantity of the item used.
	 */
	public void addRecipe(Item item, byte quantityUsed) {
		// have to add the unavailable items in the item list in the inventory
		if (InventoryManager.getInventory().getItem(item.getItemId())==null) {
			InventoryManager.getInventory().addItem(item);
		}

		System.out.println("Creating the item in the inventory and add to the recipe...");
		this.recipe.put(item, quantityUsed);

		ArrayList<Item> itemList = Inventory.getItemList();
		FilesUpdateManager.updateInventoryFile(itemList);
	}

	/**
	 * Removes an item from the recipe based on its ID.
	 * @param itemId The ID of the item to be removed.
	 */
	public void removeRecipe(byte itemId) {
		// no need to remove items in the inventory. Save the stock for possible usage in the future and not waste money
		for (Item item : recipe.keySet()) {
			if (item.getItemId() == itemId) {
				recipe.remove(item);
				break;
			}
		}
	}

	/**
	 * Checks if the menu ID is set.
	 * @return True if the menu ID is not zero, otherwise false.
	 */
	public boolean hasMenuId() {
		return !(this.menuId == 0);
	}

	/**
	 * Checks if the menu name is set.
	 * @return True if the menu name is not empty, otherwise false.
	 */
	public boolean hasMenuName() {
		return !(this.menuName.length() == 0);
	}

	/**
	 * Checks if the price is set.
	 * @return True if the price is not zero, otherwise false.
	 */
	public boolean hasPrice() {
		return !(this.price == 0);
	}

	/**
	 * Displays information about the menu item.
	 */
	public void aboutMenu() {
		System.out.println("This is menu number " + this.menuId);
		System.out.println("The name is " + this.menuName);
		System.out.println("The price for 1 portion is " + this.price);
	}

	/**
	 * method to compare 2 Food objects using the menu id
	 * @param otherFood the object to be compared.
	 * @return
	 */
	@Override
	public int compareTo(Food otherFood) {
		return Integer.compare(this.menuId, otherFood.getMenuId());
	}
}
