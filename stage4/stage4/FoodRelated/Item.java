package stage4.FoodRelated;

public class Item implements Comparable<Item> {

	private byte itemId;
	private String itemName;
	private short quantity;
	private short buyingCost;

	/**
	 * Constructs an stage4.TicketRelated.stage4.FoodRelated.Item with the specified ID and name.
	 * @param itemId The unique ID of the item.
	 * @param itemName The name of the item.
	 */
	public Item(byte itemId, String itemName) {
		this.itemId = itemId;
		this.itemName = itemName;
	}

	/**
	 * Constructs an stage4.TicketRelated.stage4.FoodRelated.Item with the specified ID, name, quantity, and buying cost.
	 * @param itemId The unique ID of the item.
	 * @param itemName The name of the item.
	 * @param quantity The quantity of the item in stock.
	 * @param buyingCost The cost of buying a single unit of the item.
	 */
	public Item(byte itemId, String itemName, short quantity, short buyingCost) {

		this.itemId = itemId;
		this.itemName = itemName;
		this.quantity = quantity;
		this.buyingCost = buyingCost;
	}

	/**
	 * Gets the item ID.
	 * @return The item ID.
	 */
	public byte getItemId() {

		if (this.hasItemId()) {
			return this.itemId;
		}
		return -1;
	}

	/**
	 * Gets the item name.
	 * @return The item name.
	 */
	public String getItemName() {

		if (this.hasItemName()) {
			return this.itemName;
		}
		return "stage4.TicketRelated.stage4.FoodRelated.Item has no name yet!";
	}

	/**
	 * Gets the quantity of the item in stock.
	 * @return The quantity of the item.
	 */
	public short getQuantity() {

		if (this.hasQuantity()) {
			return this.quantity;
		}
		return -1;
	}

	/**
	 * Gets the buying cost of a single unit of the item.
	 * @return The buying cost.
	 */
	public short getBuyingCost() {
		if (this.hasBuyingCost()) {
			return this.buyingCost;
		}

		return -1;
	}

	/**
	 * Sets the item ID.
	 * @param itemId The new item ID.
	 */
	public void setItemId(byte itemId) {
		this.itemId = itemId;
	}

	/**
	 * Sets the item name.
	 * @param itemName The new item name.
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * Sets the quantity of the item in stock.
	 * @param quantity The new quantity.
	 */
	public void setQuantity(short quantity) {
		this.quantity = quantity;
	}

	/**
	 * Sets the buying cost of a single unit of the item.
	 * @param buyingCost The new buying cost.
	 */
	public void setBuyingCost(short buyingCost) {
		this.buyingCost = buyingCost;
	}

	/**
	 * Checks if the item ID is set.
	 * @return True if the item ID is not zero, otherwise false.
	 */
	public boolean hasItemId() {
		return !(this.itemId == 0);
	}

	/**
	 * Checks if the item name is set.
	 * @return True if the item name is not empty, otherwise false.
	 */
	public boolean hasItemName() {
		return !(this.itemName.isEmpty());
	}

	/**
	 * Checks if the item has a quantity greater than zero.
	 * @return True if the quantity is greater than zero, otherwise false.
	 */
	public boolean hasQuantity() {
		return (this.quantity > 0);
	}

	/**
	 * Checks if the buying cost is greater than zero.
	 * @return True if the buying cost is greater than zero, otherwise false.
	 */
	public boolean hasBuyingCost() {
		return (this.buyingCost > 0);
	}

	/**
	 * Displays information about the item.
	 */
	public void aboutItem() {

		System.out.println("stage4.TicketRelated.stage4.FoodRelated.Item name is " + this.itemName + " with id no " + this.itemId);
		System.out.println("The quantity available in the inventory is " + this.quantity);
		System.out.println("The price of buying a single quantity unit from suppliers is " + this.buyingCost);
	}

	/**
	 * method to compare 2 stage4.TicketRelated.stage4.FoodRelated.Item objects using the menu id
	 * @param otherItem the object to be compared.
	 */
	@Override
	public int compareTo(Item otherItem) {
		return Integer.compare(this.itemId, otherItem.getItemId());
	}

	/**
	 * Returns string representation of item with the name, quantity, and cost per unit from supplier
	 * @return item string
	 */
	@Override
	public String toString() {
		String str = "";
		str = str + "item name: " + this.itemName;
		str = str + "\n\tcurrent quantity in inventory: " + this.quantity + " unit(s)";
		str = str + "\n\tcost per unit to buy from supplier: $" + this.buyingCost;
		return str;
	}

}
