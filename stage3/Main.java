import java.time.LocalDate;
import java.util.ArrayList;


public class Main {
	public void main(String[] args) {
		// Creating food staffs
		FoodStaff foodStaff1 = new FoodStaff("Emma", (byte) 1, (byte) 16, "8am-3pm");
		FoodStaff foodStaff2 = new FoodStaff("John", (byte) 2, (byte) 16, "9am-4pm");
		FoodStaff foodStaff3 = new FoodStaff("Tim", (byte) 3, (byte) 16, "11 am-6pm");

		ArrayList<FoodStaff> foodStaffs = new ArrayList<>();
		foodStaffs.add(foodStaff1);
		foodStaffs.add(foodStaff2);
		foodStaffs.add(foodStaff3);

		// Creating ticket staffs
		TicketStaff ticketStaff1 = new TicketStaff("Edward", (byte) 4, (byte) 16, "8am-6pm");
		TicketStaff ticketStaff2 = new TicketStaff("Michelle", (byte) 5, (byte) 16, "11am-5pm");
		TicketStaff ticketStaff3 = new TicketStaff("Jack", (byte) 6, (byte) 15, "10am-7pm");

		ArrayList<TicketStaff> ticketStaffs = new ArrayList<>();
		ticketStaffs.add(ticketStaff1);
		ticketStaffs.add(ticketStaff2);
		ticketStaffs.add(ticketStaff3);

		// add customers
		Customer customer1 = new Customer("Ivan");
		Customer customer2 = new Customer("Logan");
		Customer customer3 = new Customer("Heather");
		Customer customer4 = new Customer("Cloud");
		Customer customer5 = new Customer("Zack");
		Customer customer6 = new Customer("Carolina");
		Customer customer7 = new Customer("Yuna");
		Customer customer8 = new Customer("Dixon");
		Customer customer9 = new Customer("Christ");
		Customer customer10 = new Customer("Felix");
		Customer customer11 = new Customer("Luna");
		Customer customer12 = new Customer("Cid");
		Customer customer13 = new Customer("Vincent");
		Customer customer14 = new Customer("Cecil");
		Customer customer15 = new Customer("Clive");
		Customer customer16 = new Customer("Rydia");

		// add movies to cinema
		ticketStaff1.getMovieManager().addMovie(new Movie((byte) 1, "Star Wars: The Empire Strikes Back", "Science Fiction", (short) 124));
		ticketStaff2.getMovieManager().addMovie(new Movie((byte) 2, "Back To The Future", "Science Fiction", (short) 116));
		ticketStaff3.getMovieManager().addMovie(new Movie((byte) 3, "Jaws", "Thriller", (short) 130));
		ticketStaff1.getMovieManager().addMovie(new Movie((byte) 4, "The Lord Of The Rings: The Return Of The King", "Fantasy", (short) 201));
		ticketStaff2.getMovieManager().addMovie(new Movie((byte) 5, "28 Days Later", "Thriller", (short) 113));
		ticketStaff3.getMovieManager().addMovie(new Movie((byte) 6, "The Mummy", "Action", (short) 124));

		// add food to menu
		foodStaff1.getMenuManager().addMenu(1, "Cheeseburger", 8);
		foodStaff2.getMenuManager().addMenu(2, "Dr. Pepper", 3);
		foodStaff3.getMenuManager().addMenu(3, "Hot Dog", 3);
		foodStaff1.getMenuManager().addMenu(4, "Pizza", 10);
		foodStaff2.getMenuManager().addMenu(5, "Popcorn", 4);
		foodStaff3.getMenuManager().addMenu(6, "Nachos", 5);
		foodStaff1.getMenuManager().addMenu(7, "Cookies", 2);
		foodStaff2.getMenuManager().addMenu(8, "Pepsi", 3);
		foodStaff3.getMenuManager().addMenu(9, "Coca-cola", 3);

		// customers buying from food stand
		foodStaff1.addNewFoodPayment(customer3);
		foodStaff3.addNewFoodPayment(customer2);
		foodStaff2.addNewFoodPayment(customer1);
		foodStaff2.addNewFoodPayment(customer6);
		foodStaff1.addNewFoodPayment(customer13);
		foodStaff3.addNewFoodPayment(customer12);
		foodStaff2.addNewFoodPayment(customer11);
		foodStaff2.addNewFoodPayment(customer16);
		foodStaff1.addNewFoodPayment(customer5);
		foodStaff3.addNewFoodPayment(customer7);
		foodStaff2.addNewFoodPayment(customer8);
		foodStaff2.addNewFoodPayment(customer9);
		foodStaff1.addNewFoodPayment(customer10);
		foodStaff3.addNewFoodPayment(customer15);
		foodStaff2.addNewFoodPayment(customer14);

		// customers buying ticket from ticket booth
		ticketStaff1.addNewTicketPayment(customer2);
		ticketStaff3.addNewTicketPayment(customer3);
		ticketStaff2.addNewTicketPayment(customer1);
		ticketStaff2.addNewTicketPayment(customer6);
		ticketStaff1.addNewTicketPayment(customer10);
		ticketStaff2.addNewTicketPayment(customer14);
		ticketStaff3.addNewTicketPayment(customer11);
		ticketStaff2.addNewTicketPayment(customer13);
		ticketStaff2.addNewTicketPayment(customer15);
		ticketStaff3.addNewTicketPayment(customer9);
		ticketStaff2.addNewTicketPayment(customer16);
		ticketStaff2.addNewTicketPayment(customer8);
		ticketStaff2.addNewTicketPayment(customer7);
		ticketStaff1.addNewTicketPayment(customer12);
		ticketStaff3.addNewTicketPayment(customer5);
		ticketStaff2.addNewTicketPayment(customer4);

		// add analytics
		foodStaff1.getAnalytics().setTimePeriod(LocalDate.of(2024, 10, 26));
		foodStaff1.getAnalytics().generateReport();

		ticketStaff3.getAnalytics.setTimePeriod(LocalDate.of(2025, 1, 13));
		ticketStaff3.getAnalytics().exportReport();

		foodStaff2.getAnalytics().setTimePeriod(LocalDate.of(2024, 8, 22), LocalDate.of(2025, 1, 15));
		foodStaff2.getAnalytics().generateReport();

		ticketStaff1.getAnalytics.setTimePeriod(LocalDate.of(2023, 1, 13));
		ticketStaff1.getAnalytics().exportReport();
	}
}
