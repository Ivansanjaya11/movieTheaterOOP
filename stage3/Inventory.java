import java.io.*;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;
import javafx.util.Pair;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import util.Path;

public class Inventory {
	private ArrayList<Item> itemList;
	private static File inventoryFile;

	/**
	 * Constructs an Inventory object and initializes the item list by reading
	 * inventory data from the file if it is not empty.
	 */
	public Inventory() {
		this.itemList = new ArrayList<Item>();

		/*
		 * whenever the program starts and the inventory object is initialized,
		 * access the inventory path to get the latest inventory state.
		 * Then, load every information (item id, item name, item quantity, and buying cost)
		 * automatically into the item list array list.
		 * This means that Item objects are automatically created
		 * every time the Inventory object is initialized,
		 * except if the inventory state is empty in the file
		 */

		if (inventoryFile.length() != 0) {
			try (BufferedReader reader = new BufferedReader(new FileReader(Path.INVENTORY_REPORT_PATH))) {
				String line;
				while ((line = reader.readLine()) != null) {
					byte itemId = Byte.parseByte(line.split(",")[0]);
					String itemName = line.split(",")[1];
					short itemQuantity = Short.parseShort(line.split(",")[2]);
					short buyingCost = Short.parseShort(line.split(",")[3]);

					itemList.add(new Item(itemId, itemName, itemQuantity, buyingCost));
				}
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
		}
	}

	/**
	 * Retrieves an item from the inventory based on the provided item ID.
	 *
	 * @param itemId The unique ID of the item.
	 * @return The item with the specified ID, or null if not found.
	 * @throws NoSuchElementException if no item with the given ID exists.
	 */
	public Item getItem(byte itemId) {
		try {
			for (Item item : itemList) {
				if (item.hasItemId() && item.getItemId() == itemId) {
					return item;
				}
			}
			throw new NoSuchElementException("There is no such item in the inventory");
		} catch (NoSuchElementException e) {
			System.err.println(e.getMessage());
		}
		return null;
	}

	/**
	 * Adds a new item to the inventory.
	 *
	 * @param item The item to be added to the inventory.
	 */
	public void addItem(Item item) {
		this.itemList.add(item);
	}

	/**
	 * Removes an item from the inventory based on the provided item ID.
	 *
	 * @param itemId The ID of the item to be removed.
	 * @throws NoSuchElementException if no item with the given ID exists.
	 */
	public void removeItem(byte itemId) {
		try {
			byte i = 0;
			boolean found = false;
			for (Item item : itemList) {
				if (item.hasItemId() && item.getItemId() == itemId) {
					found = true;
					this.itemList.remove(i);
					break;
				}
				i++;
			}
			if (!found) {
				throw new NoSuchElementException("There is no such item in the inventory");
			}
		} catch (NoSuchElementException e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * Updates the inventory based on the food orders provided.
	 * Reduces the quantity of items based on their usage in food recipes.
	 *
	 * @param foodOrder The list of food orders containing food and quantity.
	 */
	public void updateInventory(ArrayList<Pair<Food, Byte>> foodOrder) {
		for (Pair<Food, Byte> anOrder : foodOrder) {
			// for every food object in the order, get the recipe containing ingredients used to make it
			HashMap<Item, Byte> recipe = anOrder.getKey().getRecipe();
			// for every item (ingredients), reduce the quantity in inventory by the amount set in the order
			for (Item recipeItem : recipe.keySet()) {
				byte quantityUsed = recipe.get(recipeItem);
				recipeItem.setQuantity((short) (recipeItem.getQuantity() - quantityUsed * anOrder.getValue()));
			}
		}

		FilesUpdateManager.updateInventoryFile(itemList); // update the state of the inventory file

		// call a method that will alert for low stock if the item is low in quantity
		this.alertLowStock();
	}



	/**
	 * Checks for items with low stock and alerts if their quantity is below the threshold.
	 * If the quantity is low, the system will automatically order more items.
	 */
	private void alertLowStock() {
		byte minimum = 15; // sets the limit of low stock in a certain unit quantity
		for (Item item : this.itemList) {
			if (item.hasQuantity()) {
				// if quantity gets lower than the limit, order more item
				if (item.getQuantity() <= minimum) {
					System.out.println("Item quantity in the inventory is low!");
					this.orderMoreItems(item);
				}
			} else {
				// if item in the inventory is empty, print a different message and order the items
				System.out.println("Item in the inventory is empty!");
				this.orderMoreItems(item);
			}
		}
	}

	/**
	 * Orders more items for the inventory based on the specified item.
	 * A fixed quantity of 250 units will be ordered, and the total price is calculated
	 * based on the buying cost of the item.
	 *
	 * @param item The item that needs to be ordered.
	 */
	private void orderMoreItems(Item item) {
		short buyingQuantity = 250; // sets the quantity bought everytime the item quantity gets low
		short totalPrice = (short) (item.getQuantity() * item.getBuyingCost());

		System.out.println("Ordering item " + item.getItemName() + " by " + buyingQuantity + " quantity unit at $" + totalPrice);

		// update the transaction record of item order
		FilesUpdateManager.updateItemOrderFile(item, buyingQuantity, totalPrice);

		// sets the new quantity after ordering new items
		item.setQuantity((short) (item.getQuantity() + buyingQuantity));
		System.out.println("Order completed");
	}


}
