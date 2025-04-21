package stage4.OrdersAndPayment;

import stage4.AnalyticsAndFiles.FilesUpdateManager;
import stage4.Customer;
import stage4.FoodRelated.Food;

import java.util.Scanner;
import java.util.TreeMap;

public class FoodPayment extends Payment {

	private TreeMap<Food, Byte> orderedFood;
	private static final Scanner input = new Scanner(System.in);

	/**
	 * Constructor for the stage4.TicketRelated.stage4.Orders.FoodPayment class.
	 * Initializes the ordered food list and scanner.
	 * @param customer the customer making the payment
	 */
	public FoodPayment(Customer customer) {
		super(customer);
		this.orderedFood = new TreeMap<>();
	}

	/**
	 * Sets the total payment amount based on the ordered food items.
	 */
	@Override
	public void setPaymentAmount() {

		short total = 0;
		// add up the total with the total price of each food menu
		for (Food aFood : this.orderedFood.keySet()) {

			total += (aFood.getPrice() * this.orderedFood.get(aFood));
		}

		this.paymentAmount = total;
	}

	/**
	 * Checks if there is an order placed by the customer.
	 * @return true if the customer has placed an order, false otherwise
	 */
	public boolean hasOrder() {
		return !orderedFood.isEmpty();
	}

	/**
	 * Allows the customer to choose food items, either adding or removing orders.
	 */
	public boolean chooseFood() {

		DetailFoodBought detail = new DetailFoodBought();
		detail = OrderFood.takeFoodOrder(detail);
		this.orderedFood = detail.getOrderedFood();

		if (detail.isEmpty()) {
			System.out.println("Transaction cancelled!");
			return false;
		}

		this.setPaymentAmount();

		detail.setPaymentAmount(this.getPaymentAmount());

		do {
			// ask for payment method
			System.out.println("How would you like to pay?");
			System.out.println("1. With card");
			System.out.println("2. With cash");

			byte paymentOption = input.nextByte();

			if (paymentOption>0 && paymentOption<=2) {
				if (paymentOption==1) {
					detail.setPaymentType("card");
					processPaymentWithCard();
				} else {
					detail.setPaymentType("cash");
					processPaymentWithCash();
				}
				break;
			}

			System.out.println("Invalid input!");
		} while (true);

		detail.setCustomer(this.getCustomer());

		// generate the receipt for the order
		String paymentId = ReceiptGenerator.generateFoodReceipt(detail);

		super.setPaymentId(paymentId);

		// updates the food sales report file with the new transaction
		FilesUpdateManager.updateFoodSalesFile(super.getPaymentId(), detail);

		return true;
	}
}
