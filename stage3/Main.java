import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;


public class Main {
	public static void main(String[] args) {
		// Creating food staffs
		FoodStaff foodStaff1 = new FoodStaff("Emma", (byte) 1, (byte) 16, "08:00-15:00");
		FoodStaff foodStaff2 = new FoodStaff("John", (byte) 2, (byte) 16, "09:00-16:00");
		FoodStaff foodStaff3 = new FoodStaff("Tim", (byte) 3, (byte) 16, "11:00-18:00");

		ArrayList<FoodStaff> foodStaffs = new ArrayList<>();
		foodStaffs.add(foodStaff1);
		foodStaffs.add(foodStaff2);
		foodStaffs.add(foodStaff3);

		// Creating ticket staffs
		TicketStaff ticketStaff1 = new TicketStaff("Edward", (byte) 4, (byte) 16, "08:00-18:00");
		TicketStaff ticketStaff2 = new TicketStaff("Michelle", (byte) 5, (byte) 16, "11:00-17:00");
		TicketStaff ticketStaff3 = new TicketStaff("Jack", (byte) 6, (byte) 15, "10:00-19:00");

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

		// create movies
		Movie movie1 = new Movie((byte) 1, "Star Wars", "Science Fiction", (short) 124);
		Movie movie2 = new Movie((byte) 2, "Back To The Future", "Science Fiction", (short) 116);
		Movie movie3 = new Movie((byte) 3, "Jaws", "Thriller", (short) 130);
		Movie movie4 = new Movie((byte) 4, "Lord Of The Rings", "Fantasy", (short) 201);
		Movie movie5 = new Movie((byte) 5, "28 Days Later", "Thriller", (short) 113);
		Movie movie6 = new Movie((byte) 6, "The Mummy", "Action", (short) 124);


		// add movies to cinema
		ticketStaff1.getMovieManager().addMovie(movie1);
		ticketStaff2.getMovieManager().addMovie(movie2);
		ticketStaff3.getMovieManager().addMovie(movie3);
		ticketStaff1.getMovieManager().addMovie(movie4);
		ticketStaff2.getMovieManager().addMovie(movie5);
		ticketStaff3.getMovieManager().addMovie(movie6);

		// add screen
		Screen screen1 = new Screen((byte) 1, "imax");
		Screen screen2 = new Screen((byte)  2, "imax");
		Screen screen3 = new Screen((byte) 3, "normal");
		Screen screen4 = new Screen((byte) 4, "normal");
		Screen screen5 = new Screen((byte) 5, "normal");
		Screen screen6 = new Screen((byte) 6, "normal");

		// add showtime
		Showtime showtime1 = new Showtime(1, movie1, screen1, LocalTime.of(10, 0));
		Showtime showtime2 = new Showtime(2, movie1, screen1, LocalTime.of(15, 0));
		Showtime showtime3 = new Showtime(3, movie2, screen2, LocalTime.of(12, 0));
		Showtime showtime4 = new Showtime(4, movie3, screen3, LocalTime.of(13, 0));
		Showtime showtime5 = new Showtime(5, movie3, screen4, LocalTime.of(10, 0));
		Showtime showtime6 = new Showtime(6, movie3, screen4, LocalTime.of(15, 0));
		Showtime showtime7 = new Showtime(7, movie4, screen5, LocalTime.of(11, 0));
		Showtime showtime8 = new Showtime(8, movie5, screen6, LocalTime.of(10, 0));
		Showtime showtime9 = new Showtime(9, movie6, screen6, LocalTime.of(13, 0));
		Showtime showtime10 = new Showtime(10, movie6, screen6, LocalTime.of(16, 0));

		// register showtimes
		ticketStaff1.getShowtimeManager().addShowtime(showtime1);
		ticketStaff2.getShowtimeManager().addShowtime(showtime2);
		ticketStaff3.getShowtimeManager().addShowtime(showtime3);
		ticketStaff2.getShowtimeManager().addShowtime(showtime4);
		ticketStaff3.getShowtimeManager().addShowtime(showtime5);
		ticketStaff1.getShowtimeManager().addShowtime(showtime6);
		ticketStaff2.getShowtimeManager().addShowtime(showtime7);
		ticketStaff1.getShowtimeManager().addShowtime(showtime8);
		ticketStaff2.getShowtimeManager().addShowtime(showtime9);
		ticketStaff3.getShowtimeManager().addShowtime(showtime10);

		// create items
		Item buns = new Item((byte) 1, "buns", (short) 16, (byte) 1);
		Item tomato = new Item((byte) 2, "tomato", (short) 34, (byte) 1);
		Item cheese = new Item((byte) 3, "cheese", (short) 23, (byte) 2);
		Item meat = new Item((byte) 4, "meat", (short) 46, (byte) 4);
		Item sausage = new Item((byte) 5, "sausage", (short) 51, (byte) 3);
		Item soda = new Item((byte) 6, "soda", (short) 99, (byte) 2);
		Item dough = new Item((byte) 7, "dough", (short) 76, (byte) 3);
		Item corn = new Item((byte) 8, "corn", (short) 99, (byte) 1);

		// create foods
		Food burger = new Food((byte) 1, "Burger", (byte) 11);
		Food fanta = new Food((byte) 2, "Fanta", (byte) 3);
		Food hotDog = new Food((byte)3, "Hot Dog", (byte) 3);
		Food pizza = new Food((byte) 4, "Pizza", (byte) 10);
		Food popcorn = new Food((byte) 5, "Popcorn", (byte) 4);
		Food pepsi = new Food((byte) 6, "Pepsi", (byte) 3);
		Food coke = new Food((byte) 7, "Coke", (byte) 3);

		// register all recipe and items to Food and inventory (to inventory is automatic)
		burger.addRecipe(buns, (byte) 2);
		burger.addRecipe(tomato, (byte) 1);
		burger.addRecipe(cheese, (byte) 1);
		burger.addRecipe(meat, (byte) 1);

		fanta.addRecipe(soda, (byte) 1);
		pepsi.addRecipe(soda, (byte) 1);
		coke.addRecipe(soda, (byte) 1);

		hotDog.addRecipe(buns, (byte) 2);
		hotDog.addRecipe(sausage, (byte) 1);

		pizza.addRecipe(dough, (byte) 2);
		pizza.addRecipe(meat, (byte) 1);
		pizza.addRecipe(cheese, (byte) 1);

		popcorn.addRecipe(corn, (byte) 3);

		// add food to menu
		foodStaff1.getMenuManager().addMenu(burger);
		foodStaff2.getMenuManager().addMenu(fanta);
		foodStaff3.getMenuManager().addMenu(hotDog);
		foodStaff1.getMenuManager().addMenu(pizza);
		foodStaff2.getMenuManager().addMenu(popcorn);
		foodStaff2.getMenuManager().addMenu(pepsi);
		foodStaff3.getMenuManager().addMenu(coke);



		// customers buying from food stand
		//foodStaff1.addNewFoodPayment(customer3);
		//foodStaff3.addNewFoodPayment(customer2);
		/*foodStaff2.addNewFoodPayment(customer1);
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
		foodStaff2.addNewFoodPayment(customer14);*/

		// customers buying ticket from ticket booth
		//ticketStaff1.addNewTicketPayment(customer2);
		//ticketStaff3.addNewTicketPayment(customer3);
		/*ticketStaff2.addNewTicketPayment(customer1);
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
		ticketStaff2.addNewTicketPayment(customer4);*/

		// add analytics
		//foodStaff1.getAnalytics().setTimePeriod(LocalDate.of(2024, 10, 26));
		//foodStaff1.getAnalytics().generateReport();

		ticketStaff3.getAnalytics().setTimePeriod(LocalDate.of(2025, 1, 13));
		ticketStaff3.getAnalytics().exportReport();

		//foodStaff2.getAnalytics().setTimePeriod(LocalDate.of(2024, 8, 22), LocalDate.of(2025, 1, 15));
		//foodStaff2.getAnalytics().generateReport();

		//ticketStaff1.getAnalytics().setTimePeriod(LocalDate.of(2023, 1, 13));
		//ticketStaff1.getAnalytics().exportReport();
	}
}
