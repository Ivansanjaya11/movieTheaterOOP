import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Scanner;
import java.util.ArrayList;
import javafx.util.Pair;
import java.time.LocalDateTime;
import util.Path;
import util.DateAndPaymentTracker;

/*
The FoodPayment class, however, is managing multiple aspects,
including menu handling, order processing, and inventory updates.
This is not correct.
It would be best to separate these responsibilities into distinct classes,
such as MenuManager for managing menu items,
an Order class for processing food orders,
and an event-driven mechanism to update inventory rather than handling it directly in FoodPayment.
 */



public class FoodPayment extends Payment {
	private ArrayList<Pair<Food, Byte>> orderedFood;
	private Scanner input;

	/**
	 * Constructor for the FoodPayment class.
	 * Initializes the ordered food list and scanner.
	 *
	 * @param customer the customer making the payment
	 */
	public FoodPayment(Customer customer) {
		super(customer);
		this.orderedFood = new ArrayList<Pair<Food, Byte>>();
		input = new Scanner(System.in);
	}

	/**
	 * Sets the total payment amount based on the ordered food items.
	 */
	@Override
	private void setPaymentAmount() {
		short total = 0;
		// add up the total with the total price of each food menu
		for (Pair<Food, Byte> anOrder : orderedFood) {
			total += (anOrder.getKey().getPrice() * anOrder.getValue());
		}
		super.setPaymentAmount(total);
	}

	/**
	 * Checks if there is an order placed by the customer.
	 *
	 * @return true if the customer has placed an order, false otherwise
	 */
	public boolean hasOrder() {
		return !orderedFood.isEmpty();
	}

	/**
	 * Allows the customer to choose food items, either adding or removing orders.
	 */
	public void chooseFood() {
		ArrayList<Food> menuList = MenuManager.getMenuList();
		do {
			System.out.println("Choose:");
			System.out.println("1. Add order");
			System.out.println("2. Remove order");
			byte addOrRemove = input.nextByte();

			// add order
			if (addOrRemove==1) {
				// ask the user to choose from a list of food menu
				System.out.println("Choose from the following menu: ");
				for (Food food : menuList) {
					System.out.print(food.getMenuId() + ". ");
					System.out.print(food.getMenuName() + ": $");
					System.out.println(food.getPrice());
				}
				byte menuOption = input.nextByte();
				if (menuOption >= 1 && menuOption <= menuList.size()) {

					// ask for order quantity
					System.out.print("How many do you want? ");
					byte quantity = input.nextByte();
					if (quantity > 0) {

						// set the ordered food and quantity to a tuple and store to array list of ordered food
						Pair<Food, Byte> anOrder = new Pair<>(menuList.get(menuOption-1), quantity);
						orderedFood.add(anOrder);

						// ask if user still wants to order
						System.out.print("Do you still want to order more? (y/n)");
						char option1 = input.next().charAt(0);

						// if no, then review order, if confirmed, then break out of do-while loop
						// if yes, exits all if statements and iterate from the beginning again
						if (String.valueOf(option1).equalsIgnoreCase("n")) {
							boolean isCorrect = this.reviewOrder();
							if (isCorrect) {
								break;
							}
						}
					} else {
						System.out.println("Invalid quantity!");
					}
				} else {
					System.out.println("There is no such item in the menu!");
				}

			// remove order
			} else {
				if (!orderedFood.isEmpty()) {
					System.out.print("Choose which one to remove: ");
					byte j = 1;

					// list all ordered food to choose which to remove from order
					for (Pair<Food, Byte> anOrder : orderedFood) {
						System.out.print(j + ". ");
						System.out.print(anOrder.getKey().getMenuName() + ": ");
						System.out.println(anOrder.getValue());
					}
					byte removeOption = input.nextByte();
					if (removeOption >=1 && removeOption <= orderedFood.size()) {

						// remove the order
						orderedFood.remove(removeOption-1);

						// ask if the user still wants to order
						System.out.print("Do you still want to order more? (y/n)");
						char option2 = input.next().charAt(0);

						// if no, then review order, if confirmed, then break out of do-while loop
						// if yes, exits all if statements and iterate from the beginning again
						if (String.valueOf(option2).equalsIgnoreCase("n")) {
							boolean isCorrect = this.reviewOrder();
							if (isCorrect) {
								break;
							}
						}
					} else {
						System.out.println("There is no such item in your order!");
					}
				} else {
					System.out.println("You haven't ordered anything yet!");
				}
			}
		} while (true);

		this.setPaymentAmount();

		do {
			// ask for payment method
			System.out.println("How would you like to pay?");
			System.out.println("1. With card");
			System.out.println("2. With cash");
			byte paymentOption = input.nextByte();
			if (paymentOption>0 && paymentOption<=2) {
				if (paymentOption==1) {
					super.setPaymentType("card");
				} else {
					super.setPaymentType("cash");
				}
				break;
			}
			System.out.println("Invalid input!");
		} while (true);

		// process the payment
		if (super.hasPaymentType() && super.hasPaymentAmount()) {
			if (super.getPaymentType().equalsIgnoreCase("card")) {
				super.processPaymentWithCard();
			} else {
				super.processPaymentWithCash();
			}
		}

		// generate the receipt for the order
		String paymentId = ReceiptGenerator.generateFoodReceipt(orderedFood, super.getCustomer().getName(), super.getPaymentType(), super.getPaymentAmount());

		super.setPaymentId(paymentId);

		// updates the food sales report file with the new transaction
		FilesUpdateManager.updateFoodSalesFile(super.getPaymentId(), super.getPaymentAmount(), orderedFood);
	}




	/**
	 * Reviews the customer's order to confirm if it is correct.
	 *
	 * @return true if the order is correct, false otherwise
	 */
	private boolean reviewOrder() {
		// print out the ordered food one by one
		byte i = 1;
		for (Pair<Food, Byte> anOrder : orderedFood) {
			System.out.print(i + ". ");
			System.out.print(anOrder.getKey().getMenuName() + ": ");
			System.out.println(anOrder.getValue());
		}

		// ask the user if the order is correct
		System.out.print("Is this correct? (y/n)");
		char option = input.next().charAt(0);

		// if yes then return true, otherwise, false
		if (String.valueOf(option).equalsIgnoreCase("y")) {
			return true;
		}
		return false;
	}
}
