import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.TreeMap;

import util.Path;

public class Inventory {

	// Initializes Final variables for Inventory
	private static final ArrayList<Item> itemList = new ArrayList<>();

	private static final File inventoryFile = new File(Path.INVENTORY_REPORT_PATH);

	public static final String RESET = "\033[0m";
	public static final String RED = "\033[0;31m";
	public static final String YELLOW = "\u001b[33m";

	private Inventory() {}

	static {
		/*
		 * whenever the program starts and the inventory is loaded,
		 * access the inventory path to get the latest inventory state.
		 * Then, load every information (item id, item name, item quantity, and buying cost)
		 * automatically into the item list array list (data persistence)
		 */
		if (inventoryFile.length() != 0) {

			try (BufferedReader reader = new BufferedReader(new FileReader(Path.INVENTORY_REPORT_PATH))) {
				String line;

				while ((line = reader.readLine()) != null) {
					byte itemId = Byte.parseByte(line.split(",")[0]);
					String itemName = line.split(",")[1];
					short itemQuantity = Short.parseShort(line.split(",")[2]);
					short buyingCost = Short.parseShort(line.split(",")[3]);

					Inventory.addItem(new Item(itemId, itemName, itemQuantity, buyingCost));

					System.out.println(YELLOW + "Item " + itemName + " already exist in inventory. Quantity in stock is pulled" + RESET);
				}
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}

		}

	}

	/**
	 * Ensures item list has items
	 * @return true / false
	 */
	public static boolean hasItems() {
		return !itemList.isEmpty();
	}

	/**
	 * Checks if item list has input item ID
	 * @param id of item in item list
	 * @return true / false
	 */
	public static boolean contains(byte id) {

		for (Item item : itemList) {
			if (item.getItemId() == id) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Returns item list
	 * @return item list
	 */
	public static ArrayList<Item> getItemList() {
		return new ArrayList<>(itemList);
	}

	/**
	 * Retrieves an item from the inventory based on the provided item ID.
	 *
	 * @param itemId The unique ID of the item.
	 * @return The item with the specified ID, or null if not found.
	 * @throws NoSuchElementException if no item with the given ID exists.
	 */
	public static Item getItem(byte itemId) {

		for (Item item : itemList) {
			if (item.hasItemId() && item.getItemId() == itemId) {
				return item;
			}
		}

		System.out.println(RED + "There is no item with id #"+ itemId + " in the inventory" + RESET);
		return null;
	}

	/**
	 * Adds a new item to the inventory.
	 * @param item The item to be added to the inventory.
	 */
	public static void addItem(Item item) {
		itemList.add(item);
	}

	/**
	 * Removes an item from the inventory based on the provided item ID.
	 * @param itemId The ID of the item to be removed.
	 * @throws NoSuchElementException if no item with the given ID exists.
	 */
	public static void removeItem(byte itemId) {

		byte i = 0;
		boolean found = false;

		for (Item item : itemList) {
			if (item.hasItemId() && item.getItemId() == itemId) {
				found = true;
				itemList.remove(i);
				break;
			}

			i++;
		}

		if (!found) {
			System.out.println("There is no such item in the inventory");
		}

	}

	/**
	 * method to update a certain item in the inventory
	 * @param index the position of the item in the list
	 * @param item the new item object to replace the old one
	 */
	public static void updateItem(byte index, Item item) {
		itemList.set(index, item);
	}

	/**
	 * Updates the inventory based on the food orders provided.
	 * Reduces the quantity of items based on their usage in food recipes.
	 * @param foodOrder The list of food orders containing food and quantity.
	 */
	public static void updateInventory(TreeMap<Food, Byte> foodOrder) {

		TreeMap<Item, Short> itemsToBeUpdated = new TreeMap<>();

		for (Food aFood : foodOrder.keySet()) {
			// for every food object in the order, get the recipe containing ingredients used to make it
			TreeMap<Item, Byte> recipe = aFood.getRecipe();

			// get all the items in the recipe that are used to make the food
			// then store the new quantity to the itemsToBeUpdated
			for (Item recipeItem : recipe.keySet()) {
				byte quantityUsed = recipe.get(recipeItem);
				short newQuantity = (short) (recipeItem.getQuantity() - quantityUsed * foodOrder.get(aFood));

				itemsToBeUpdated.put(recipeItem, newQuantity);

				recipeItem.setQuantity(newQuantity);
			}
		}

		// set the new quantity in the list of item
		for (Item item : itemsToBeUpdated.keySet()) {
			ListIterator<Item> iter = itemList.listIterator();

			while (iter.hasNext()) {
				Item anItem = iter.next();

				if (item.getItemId() == anItem.getItemId()) {
					anItem.setQuantity(itemsToBeUpdated.get(item));
				}
			}
		}

		// call a method that will alert for low stock if the item is low in quantity
		alertLowStock();

		FilesUpdateManager.updateInventoryFile(itemList); // update the state of the inventory file
	}



	/**
	 * Checks for items with low stock and alerts if their quantity is below the threshold.
	 * If the quantity is low, the system will automatically order more items.
	 */
	private static void alertLowStock() {

		byte minimum = 15; // sets the limit of low stock in a certain unit quantity

		for (Item item : itemList) {

			if (item.hasQuantity()) {
				if (item.getQuantity() <= minimum) {
					// if quantity gets lower than the limit, order more item
					System.out.println("Item quantity of " + item.getItemName() + " in the inventory is low!");
					orderMoreItems(item);
				}
			} else {
				// if item in the inventory is empty, print a different message and order the items
				System.out.println("Item in the inventory is empty!");
				orderMoreItems(item);
			}

		}
	}

	/**
	 * Orders more items for the inventory based on the specified item.
	 * A fixed quantity of 250 units will be ordered, and the total price is calculated
	 * based on the buying cost of the item.
	 * @param item The item that needs to be ordered.
	 */
	private static void orderMoreItems(Item item) {

		short buyingQuantity = 250; // sets the quantity bought everytime the item quantity gets low
		short totalPrice = (short) (buyingQuantity * item.getBuyingCost()); // calculate the total price

		System.out.println("Ordering item " + item.getItemName() + " by " + buyingQuantity + " quantity unit at $" + totalPrice);

		// update the transaction record of item order
		FilesUpdateManager.updateItemOrderFile(item, buyingQuantity, totalPrice);

		// sets the new quantity after ordering new items
		item.setQuantity((short) (item.getQuantity() + buyingQuantity));

		System.out.println("Order completed");
	}

}
