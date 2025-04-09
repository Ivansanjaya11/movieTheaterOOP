import util.PrettyPrinter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu {
    private static Scanner input = new Scanner(System.in);
    private static ArrayList<Staff> staffs = new ArrayList<>();

    private MainMenu() {}

    private static void createObjects() {
        // Creating food staffs
        FoodStaff foodStaff1 = new FoodStaff("John", (byte) 1, (byte) 16, "09:00-16:00");
        FoodStaff foodStaff2 = new FoodStaff("Logan", (byte) 2, (byte) 16, "09:00-16:00");
        FoodStaff foodStaff3 = new FoodStaff("Tim", (byte) 3, (byte) 16, "11:00-18:00");

        staffs.add(foodStaff1);
        staffs.add(foodStaff2);
        staffs.add(foodStaff3);

        // Creating ticket staffs
        TicketStaff ticketStaff1 = new TicketStaff("Edward", (byte) 4, (byte) 16, "08:00-18:00");
        TicketStaff ticketStaff2 = new TicketStaff("Michelle", (byte) 5, (byte) 16, "11:00-17:00");
        TicketStaff ticketStaff3 = new TicketStaff("Jack", (byte) 6, (byte) 15, "10:00-19:00");

        staffs.add(ticketStaff1);
        staffs.add(ticketStaff2);
        staffs.add(ticketStaff3);

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
        ticketStaff1.getShowtimeManager().addShowtime(showtime4);
        ticketStaff2.getShowtimeManager().addShowtime(showtime5);
        ticketStaff3.getShowtimeManager().addShowtime(showtime6);
        ticketStaff1.getShowtimeManager().addShowtime(showtime7);
        ticketStaff2.getShowtimeManager().addShowtime(showtime8);
        ticketStaff3.getShowtimeManager().addShowtime(showtime9);
        ticketStaff1.getShowtimeManager().addShowtime(showtime10);

        // create items
        Item buns = new Item((byte) 1, "buns", (short) 18, (byte) 1);
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
        foodStaff3.getMenuManager().addMenu(pepsi);
        foodStaff1.getMenuManager().addMenu(coke);
    }

    private static Staff askForStaff() {
        System.out.print("LOG IN");
        PrettyPrinter.printDashLine((short) 50);

        do {
            System.out.print("Enter staff ID: ");
            byte id = input.nextByte();
            input.nextLine();

            System.out.print("Enter name: ");
            String name = input.nextLine();

            for (Staff staff : staffs) {
                if (staff.getEmployeeId()==id && staff.getEmployeeName().equalsIgnoreCase(name)) {
                    return staff;
                }
            }

            System.out.println("Invalid! You are not our staff!");
        } while (true);
    }

    private static Customer askForCustomer() {
        System.out.print("Enter customer's name: ");
        String name = input.nextLine();

        return new Customer(name);
    }

    private static LocalDate askForDate() {
        do {
            try {
                System.out.print("Enter the day:");
                int day = input.nextInt();
                input.nextLine();

                System.out.print("Enter the month:");
                int month = input.nextInt();
                input.nextLine();

                System.out.print("Enter the year:");
                int year = input.nextInt();
                input.nextLine();

                return LocalDate.of(year, month, day);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (true);
    }

    public static void showMenu() {
        createObjects();

        boolean stillContinue = true;

        Staff staff = askForStaff();

        System.out.print("MAIN MENU");

        do {
            PrettyPrinter.printDashLine((short) 50);
            System.out.println("Choose from the following:");
            System.out.println("1. Order movie ticket");
            System.out.println("2. Order food/drink");
            System.out.println("3. Show report");
            System.out.println("4. export report");
            System.out.println("5. Exit the program");

            byte option = input.nextByte();
            input.nextLine();

            switch (option) {
                case 1:
                    if (staff instanceof TicketStaff) {
                        TicketStaff ticketStaff = (TicketStaff) staff;
                        Customer ticketCustomer = askForCustomer();
                        ticketStaff.addNewTicketPayment(ticketCustomer);
                    } else {
                        System.out.println("Invalid! You are working at the food stand!");
                    }
                    break;
                case 2:
                    if (staff instanceof  FoodStaff) {
                        FoodStaff foodStaff = (FoodStaff) staff;
                        Customer foodCustomer = askForCustomer();
                        foodStaff.addNewFoodPayment(foodCustomer);
                    } else {
                        System.out.println("Invalid! You are working at the ticket booth!");
                    }
                    break;
                case 3:
                    System.out.print("Enter start time:");
                    LocalDate startReport = askForDate();
                    System.out.print("Enter end time:");
                    LocalDate endReport = askForDate();
                    staff.getAnalytics().setTimePeriod(startReport, endReport);
                    staff.getAnalytics().generateReport();
                    break;
                case 4:
                    System.out.print("Enter start time:");
                    LocalDate startExport = askForDate();
                    System.out.print("Enter end time:");
                    LocalDate endExport = askForDate();
                    staff.getAnalytics().setTimePeriod(startExport, endExport);
                    staff.getAnalytics().exportReport();
                    break;
                case 5:
                    stillContinue = false;
                    break;
            }

        } while(stillContinue);

    }

}
