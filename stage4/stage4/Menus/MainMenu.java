package stage4.Menus;

import stage4.*;
import stage4.FoodRelated.Food;
import stage4.FoodRelated.Item;
import stage4.FoodRelated.MenuManager;
import stage4.TicketRelated.Movie;
import stage4.TicketRelated.MovieManager;
import stage4.TicketRelated.Screen;
import stage4.TicketRelated.ScreenManager;
import stage4.TicketRelated.Showtime;
import stage4.TicketRelated.ShowtimeManager;
import stage4.util.Color;
import stage4.util.LogPrinter;
import stage4.util.LogType;
import stage4.util.PrettyPrinter;

import java.time.LocalTime;
import java.util.Scanner;

public class MainMenu {

    private static final Scanner input = new Scanner(System.in);
    private static final short menuWidth = 100;

    /**
     * Constructs main menu class
     */
    private MainMenu() {}

    /**
     * Method creating dummy information (because there's no data persistence in the system yet)
     */
    private static void createObjects() {

        // Creating food staffs
        FoodStaff foodStaff1 = new FoodStaff("John", (byte) 1, (byte) 16, "09:00-16:00");
        FoodStaff foodStaff2 = new FoodStaff("Logan", (byte) 2, (byte) 16, "09:00-16:00");
        FoodStaff foodStaff3 = new FoodStaff("Tim", (byte) 3, (byte) 16, "11:00-18:00");

        // Adds food staff
        StaffManager.addStaff(foodStaff1);
        StaffManager.addStaff(foodStaff2);
        StaffManager.addStaff(foodStaff3);

        // Creating ticket staffs
        TicketStaff ticketStaff1 = new TicketStaff("Edward", (byte) 4, (byte) 16, "08:00-18:00");
        TicketStaff ticketStaff2 = new TicketStaff("Michelle", (byte) 5, (byte) 16, "11:00-17:00");
        TicketStaff ticketStaff3 = new TicketStaff("Jack", (byte) 6, (byte) 15, "10:00-19:00");

        //Adds ticket staff
        StaffManager.addStaff(ticketStaff1);
        StaffManager.addStaff(ticketStaff2);
        StaffManager.addStaff(ticketStaff3);

        // create movies
        Movie movie1 = new Movie((byte) 1, "Star Wars", "Science Fiction", (short) 124);
        Movie movie2 = new Movie((byte) 2, "Back To The Future", "Science Fiction", (short) 116);
        Movie movie3 = new Movie((byte) 3, "Jaws", "Thriller", (short) 130);
        Movie movie4 = new Movie((byte) 4, "Lord Of The Rings", "Fantasy", (short) 201);
        Movie movie5 = new Movie((byte) 5, "28 Days Later", "Thriller", (short) 113);
        Movie movie6 = new Movie((byte) 6, "The Mummy", "Action", (short) 124);


        // add movies to cinema
        MovieManager.addMovie(movie1);
        MovieManager.addMovie(movie2);
        MovieManager.addMovie(movie3);
        MovieManager.addMovie(movie4);
        MovieManager.addMovie(movie5);
        MovieManager.addMovie(movie6);

        // add screen
        Screen screen1 = new Screen((byte) 1, "imax");
        Screen screen2 = new Screen((byte)  2, "imax");
        Screen screen3 = new Screen((byte) 3, "normal");
        Screen screen4 = new Screen((byte) 4, "normal");
        Screen screen5 = new Screen((byte) 5, "normal");
        Screen screen6 = new Screen((byte) 6, "normal");

        ScreenManager.addScreen(screen1);
        ScreenManager.addScreen(screen2);
        ScreenManager.addScreen(screen3);
        ScreenManager.addScreen(screen4);
        ScreenManager.addScreen(screen5);
        ScreenManager.addScreen(screen6);

        // add showtime
        Showtime showtime1 = new Showtime((byte) 1, movie1, screen1, LocalTime.of(10, 0));
        Showtime showtime2 = new Showtime((byte) 2, movie1, screen1, LocalTime.of(15, 0));
        Showtime showtime3 = new Showtime((byte) 3, movie2, screen2, LocalTime.of(12, 0));
        Showtime showtime4 = new Showtime((byte) 4, movie3, screen3, LocalTime.of(13, 0));
        Showtime showtime5 = new Showtime((byte) 5, movie3, screen4, LocalTime.of(10, 0));
        Showtime showtime6 = new Showtime((byte) 6, movie3, screen4, LocalTime.of(15, 0));
        Showtime showtime7 = new Showtime((byte) 7, movie4, screen5, LocalTime.of(11, 0));
        Showtime showtime8 = new Showtime((byte) 8, movie5, screen6, LocalTime.of(10, 0));
        Showtime showtime9 = new Showtime((byte) 9, movie6, screen6, LocalTime.of(13, 0));
        Showtime showtime10 = new Showtime((byte) 10, movie6, screen6, LocalTime.of(16, 0));

        // register showtimes
        ShowtimeManager.addShowtime(showtime1);
        ShowtimeManager.addShowtime(showtime2);
        ShowtimeManager.addShowtime(showtime3);
        ShowtimeManager.addShowtime(showtime4);
        ShowtimeManager.addShowtime(showtime5);
        ShowtimeManager.addShowtime(showtime6);
        ShowtimeManager.addShowtime(showtime7);
        ShowtimeManager.addShowtime(showtime8);
        ShowtimeManager.addShowtime(showtime9);
        ShowtimeManager.addShowtime(showtime10);

        // create items
        Item buns = new Item((byte) 1, "buns", (short) 17, (byte) 1);
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
        MenuManager.addMenu(burger);
        MenuManager.addMenu(fanta);
        MenuManager.addMenu(hotDog);
        MenuManager.addMenu(pizza);
        MenuManager.addMenu(popcorn);
        MenuManager.addMenu(pepsi);
        MenuManager.addMenu(coke);
    }



    /**
     * Prints menu for user to select from
     */
    public static void showMenu() {

        //createObjects(); // create dummy information (because no data persistence yet)

        boolean stillContinue = true;

        Staff staff = Prompt.askForStaff();

        LogPrinter.println(Color.YELLOW, Color.YELLOW, LogType.SYSTEM, "Starting the system...");

        System.out.println("MAIN MENU");

        do {
            // Menu shown to users
            PrettyPrinter.printDashLine(menuWidth);
            System.out.println("Choose from the following:");
            System.out.println("1.  Order movie ticket");
            System.out.println("2.  Order food/drink");
            System.out.println("3.  Show report");
            System.out.println("4.  export report");
            System.out.println("5.  Add/remove/display/update/search movie");
            System.out.println("6.  Add/remove/display/update/search screen");
            System.out.println("7.  Add/remove/display/update/search showtime");
            System.out.println("8.  Add/remove/display/update/search food");
            System.out.println("9.  Add/remove/display/update/search item");
            System.out.println("10. Add/remove/display/update/search staff");
            System.out.println("11. Add/remove/display/update recipe");
            System.out.println("12. Exit the program");

            byte option = input.nextByte();
            input.nextLine();

            switch (option) {
                // Ticket staff attempting to perform a job they are not assigned
                case 1:
                    if (staff instanceof TicketStaff) {
                        TicketStaff ticketStaff = (TicketStaff) staff;
                        Customer ticketCustomer = Prompt.askForCustomer();
                        ticketStaff.addNewTicketPayment(ticketCustomer);
                    } else {
                        LogPrinter.println(Color.RED, Color.RED, LogType.INVALID, "You are not working at the ticket stand!");
                        //System.out.println("Invalid! You are working at the food stand!");
                    }

                    break;
                // stage4.TicketRelated.stage4.FoodRelated.Food staff attempting to perform a job they are not assigned
                case 2:
                    if (staff instanceof FoodStaff) {
                        FoodStaff foodStaff = (FoodStaff) staff;
                        Customer foodCustomer = Prompt.askForCustomer();
                        foodStaff.addNewFoodPayment(foodCustomer);
                    } else {
                        LogPrinter.println(Color.RED, Color.RED, LogType.INVALID, "You are not working at the food stand!");
                        //System.out.println("Invalid! You are working at the ticket booth!");
                    }

                    break;
                // Generates report for date
                case 3:
                    SubMenuAnalytics.generateReport(staff);

                    break;
                // Exports report for date
                case 4:
                    SubMenuAnalytics.exportReport(staff);

                    break;
                // Ensure food stand staff are working where assigned
                case 5:
                    if (staff instanceof TicketStaff) {
                        SubMenu.addOrRemoveOrDisplayOrUpdateOrSearchMovie();
                    } else {
                        LogPrinter.println(Color.RED, Color.RED, LogType.INVALID, "You are not working at the ticket stand!");
                        //System.out.println("Invalid! You are working at the food stand!");
                    }

                    break;
                // Ensure food stand staff are working where assigned
                case 6:
                    if (staff instanceof TicketStaff) {
                        SubMenu.addOrRemoveOrDisplayOrUpdateOrSearchScreen();
                    } else {
                        LogPrinter.println(Color.RED, Color.RED, LogType.INVALID, "You are not working at the ticket stand!");
                        //System.out.println("Invalid! You are working at the food stand!");
                    }

                    break;
                // Ensure food stand staff are working where assigned
                case 7:
                    if (staff instanceof TicketStaff) {
                        SubMenu.addOrRemoveOrDisplayOrUpdateOrSearchShowtime();
                    } else {
                        LogPrinter.println(Color.RED, Color.RED, LogType.INVALID, "You are not working at the ticket stand!");
                        //System.out.println("Invalid! You are working at the food stand!");
                    }

                    break;
                // Ensure food stand staff are working where assigned
                case 8:
                    if (staff instanceof FoodStaff) {
                        SubMenu.addOrRemoveOrDisplayOrUpdateOrSearchFood();
                    } else {
                        LogPrinter.println(Color.RED, Color.RED, LogType.INVALID, "You are not working at the food stand!");
                        //System.out.println("Invalid! You are working at the ticket stand!");
                    }

                    break;
                // Ensure food stand staff are working where assigned
                case 9:
                    if (staff instanceof FoodStaff) {
                        SubMenu.addOrRemoveOrDisplayOrUpdateOrSearchItem();
                    } else {
                        LogPrinter.println(Color.RED, Color.RED, LogType.INVALID, "You are not working at the food stand!");
                        //System.out.println("Invalid! You are working at the ticket stand!");
                    }

                    break;
                // Allows for the addition, removal, display, and update of staff members
                case 10:
                    SubMenu.addOrRemoveOrDisplayOrUpdateOrSearchStaff();

                    break;
                // Allows for the addition, removal, or display of item recipes
                case 11:
                    if (staff instanceof  FoodStaff) {
                        SubMenu.addOrRemoveOrDisplayOrUpdateRecipe();
                    } else {
                        LogPrinter.println(Color.RED, Color.RED, LogType.INVALID, "You are not working at the food stand!");
                        //System.out.println("Invalid! You are working at the ticket stand!");
                    }

                    break;
                // If the user chooses to no longer continue
                case 12:
                    stillContinue = false;
                    LogPrinter.println(Color.YELLOW, Color.YELLOW, LogType.SYSTEM, "Exiting the program...");
                    break;
                default:
                    LogPrinter.println(Color.RED, Color.RED, LogType.INVALID, "Invalid choice!");
                    break;
            }

            PrettyPrinter.printDashLine(menuWidth);

        } while(stillContinue);

    }
}
