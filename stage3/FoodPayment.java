import java.util.Scanner;
import java.util.TreeMap;

public class FoodPayment extends Payment {
	private TreeMap<Food, Byte> orderedFood;
	private static Scanner input;

	/**
	 * Constructor for the FoodPayment class.
	 * Initializes the ordered food list and scanner.
	 *
	 * @param customer the customer making the payment
	 */
	public FoodPayment(Customer customer) {
		super(customer);
		this.orderedFood = new TreeMap<>();
	}

	static {
		input = new Scanner(System.in);
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
		this.orderedFood = Order.takeFoodOrder();

		this.setPaymentAmount();

		do {
			// ask for payment method
			System.out.println("How would you like to pay?");
			System.out.println("1. With card");
			System.out.println("2. With cash");
			byte paymentOption = input.nextByte();
			if (paymentOption>0 && paymentOption<=2) {
				if (paymentOption==1) {
					//super.setPaymentType("card");
					processPaymentWithCard();
				} else {
					//super.setPaymentType("cash");
					processPaymentWithCash();
				}
				break;
			}
			System.out.println("Invalid input!");
		} while (true);

		// generate the receipt for the order
		String paymentId = ReceiptGenerator.generateFoodReceipt(this.orderedFood, super.getCustomer().getName(), super.getPaymentType(), super.getPaymentAmount());

		super.setPaymentId(paymentId);

		// updates the food sales report file with the new transaction
		FilesUpdateManager.updateFoodSalesFile(super.getPaymentId(), super.getPaymentAmount(), this.orderedFood);
	}
}
