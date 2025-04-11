import util.PrettyPrinter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu {

    // Initializes scanner and menu width
    private static Scanner input = new Scanner(System.in);
    private static short menuWidth = 100;

    /**
     * Constructs main menu class
     */

    private MainMenu() {}

    /**
     * Method creating Food Staff, workers information
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
        MenuManager.addMenu(burger);
        MenuManager.addMenu(fanta);
        MenuManager.addMenu(hotDog);
        MenuManager.addMenu(pizza);
        MenuManager.addMenu(popcorn);
        MenuManager.addMenu(pepsi);
        MenuManager.addMenu(coke);
    }

    /**
     * Propts user to sign in for Food Staff duties
     * @return staff information and duties
     */

    private static Staff askForStaff() {

        System.out.print("LOG IN");

        PrettyPrinter.printDashLine((short) 50);

        // Asks for staff ID
        do {
            System.out.print("Enter staff ID: ");
            byte id = input.nextByte();
            input.nextLine();

            // Asks for staff name
            System.out.print("Enter name: ");
            String name = input.nextLine();

            // Gets staff name and ID
            for (Staff staff : StaffManager.getStaffs()) {
                if (staff.getEmployeeId()==id && staff.getEmployeeName().equalsIgnoreCase(name)) {
                    return staff;
                }
            }

            // Invalid Staff ID or name input
            System.out.println("Invalid! You are not our staff!");
        } while (true);
    }

    /**
     * Prompts user for their customer name
     * @return customer name
     */

    private static Customer askForCustomer() {

        System.out.print("Enter customer's name: ");
        String name = input.nextLine();

        return new Customer(name);
    }

    /**
     * Allows for the addition or removal of a movie screen
     */

    private static void addOrRemoveScreen() {

        boolean stillContinue = true;

        do {
            System.out.println("Choose:");

            PrettyPrinter.printDashLine(menuWidth);

            System.out.println("1. Add screen");
            System.out.println("2. Remove screen");
            System.out.println("3. Return");

            byte option = input.nextByte();
            input.nextLine();

            switch (option) {
                case 1:
                    addScreenMenu();
                    break;
                case 2:
                    removeScreenMenu();
                    break;
                default:
                    stillContinue = false;
                    break;
            }

        } while (stillContinue);
    }

    /**
     * Allows for the selection of and removal of an input movie screen from menu list
     */

    private static void removeScreenMenu() {
        if (!ScreenManager.hasScreens()) {
            System.out.println("No screen available!");
            return ;
        }

        System.out.println("Which screen do you want to remove: ");
        byte index;

        for (int i=1; i<=ScreenManager.getScreens().size(); i++) {
            System.out.println(i + ". " + ScreenManager.getScreens().get(i-1).getScreenID());
        }

        index = input.nextByte();
        index -=1;
        input.nextLine();

        if (index >= 0 && index < ScreenManager.getScreens().size()) {
            ScreenManager.removeScreen(index);
        } else {
            System.out.println("Screen does not exist!");
        }
    }

    /**
     * Allows for movie screen to be added to menu list
     */

    private static void addScreenMenu() {
        System.out.print("Enter screen id: ");
        byte id = input.nextByte();
        input.nextLine();
        System.out.print("Enter screen type: (normal/imax) ");
        String type = input.nextLine();

        if (!ScreenManager.contains(id)) {
            ScreenManager.addScreen(new Screen(id, type));
        } else {
            System.out.println("Screen with id " + id + " already exists");
        }
    }

    /**
     * Allows for movies to be added or removed from menu list
     */

    private static void addOrRemoveMovie() {

        boolean stillContinue = true;

        do {
            System.out.println("Choose:");
            PrettyPrinter.printDashLine(menuWidth);
            System.out.println("1. Add movie");
            System.out.println("2. Remove movie");
            System.out.println("3. Return");
            byte option = input.nextByte();
            input.nextLine();
            switch (option) {
                case 1:
                    addMovieMenu();
                    break;
                case 2:
                    removeMovieMenu();
                    break;
                default:
                    stillContinue = false;
                    break;
            }
        } while (stillContinue);
    }

    /**
     * Remvoes movie from movie menu list
     */

    private static void removeMovieMenu() {

        if (!MovieManager.hasMovies()) {
            System.out.println("No movie available!");
            return ;
        }

        System.out.print("Which movie do you want to remove: ");
        byte index;

        for (int i=1; i<=MovieManager.getMovies().size(); i++) {
            System.out.println(i + ". " + MovieManager.getMovies().get(i-1).getTitle());
        }

        index = input.nextByte();
        index -=1;
        input.nextLine();

        if (index >=0 && index < MovieManager.getMovies().size()) {
            MovieManager.removeMovie(index);
        } else {
            System.out.println("Movie does not exist!");
        }
    }

    /**
     * Allows for movie to be added to movie menu list
     */

    private static void addMovieMenu() {

        System.out.print("Enter movie id: ");

        byte id = input.nextByte();
        input.nextLine();

        System.out.print("Enter movie title: ");
        String title = input.nextLine();

        System.out.print("Enter movie genre: ");
        String genre = input.nextLine();

        System.out.print("Enter duration in minutes: ");
        short duration = input.nextShort();

        if (!MovieManager.contains(id)) {
            MovieManager.addMovie(new Movie(id, title, genre, duration));
        } else {
            System.out.println("Movie with id " + id + " already exists");
        }
    }

    /**
     * Prompts users to select a movie to watch
     * @return movies to be selected from
     */

    private static Movie askForMovie() {

        System.out.println("Which movie do you want: ");
        byte index;

        for (int i=1; i<=MovieManager.getMovies().size(); i++) {
            System.out.println(i + ". " + MovieManager.getMovies().get(i-1).getTitle());
        }

        index = input.nextByte();
        index -=1;
        input.nextLine();

        if (index >=0 && index < MovieManager.getMovies().size()) {
            return MovieManager.getMovies().get(index);
        }

        System.out.println("Movie does not exist!");
        return null;
    }

    /**
     * Prompts users to select a screen to view the selected movie
     * @return screens to be selected from
     */

    private static Screen askForScreen() {

        System.out.print("Which screen do you want: ");
        byte index;

        for (int i=1; i<=ScreenManager.getScreens().size(); i++) {
            System.out.println(i + ". " + ScreenManager.getScreens().get(i-1).getScreenID());
        }

        index = input.nextByte();
        index -=1;
        input.nextLine();

        if (index >= 0 && index < ScreenManager.getScreens().size()) {
            return ScreenManager.getScreens().get(index);
        }

        System.out.println("Screen does not exist!");
        return null;
    }

    /**
     * Prompts user to enter current local time
     * @return hour and minute
     */

    private static LocalTime askForTime() {

        try {
            System.out.print("Enter the hour:");
            int hour = input.nextInt();
            input.nextLine();

            System.out.print("Enter the minute:");
            int minute = input.nextInt();
            input.nextLine();

            return LocalTime.of(hour, minute);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    /**
     * Provides showtime menu for movie, screen, and time
     */

    private static void addShowtimeMenu() {

        System.out.print("Enter showtime id: ");

        byte id = input.nextByte();
        input.nextLine();

        Movie movie = askForMovie();
        Screen screen = askForScreen();
        LocalTime time = askForTime();

        if (!ShowtimeManager.contains(id)) {
            ShowtimeManager.addShowtime(new Showtime(id, movie, screen, time));
        } else {
            System.out.println("Showtime with id " + id + " already exists");
        }
    }

    /**
     * Removes showtime from menu
     */

    private static void removeShowtimeMenu() {

        if (!ShowtimeManager.hasShowtimes()) {
            System.out.println("No showtime available!");
            return ;
        }

        System.out.print("Which showtime do you want to remove: ");
        byte index;

        for (int i=1; i<=ShowtimeManager.getShowtimes().size(); i++) {
            Showtime showtime = ShowtimeManager.getShowtimes().get(i-1);
            Movie movie = showtime.getMovie();
            Screen screen = showtime.getScreen();

            System.out.println(i + ". " + movie.getTitle());
            System.out.println("\t" + screen.getScreenType() + " screen");
            System.out.println("\tStarts at " + showtime.getStartTime());
        }

        index = input.nextByte();
        index -=1;
        input.nextLine();

        if (index >=0 && index < ShowtimeManager.getShowtimes().size()) {
            ShowtimeManager.removeShowtime(index);
        } else {
            System.out.println("Movie does not exist!");
        }
    }

    /**
     * Allows for the addition or removal of a movie showtime
     */

    private static void addOrRemoveShowtime() {

        boolean stillContinue = true;

        do {
            System.out.println("Choose:");
            PrettyPrinter.printDashLine(menuWidth);
            System.out.println("1. Add showtime");
            System.out.println("2. Remove showtime");
            System.out.println("3. Return");
            byte option = input.nextByte();
            input.nextLine();
            switch (option) {
                case 1:
                    addShowtimeMenu();
                    break;
                case 2:
                    removeShowtimeMenu();
                    break;
                default:
                    stillContinue = false;
                    break;
            }
        } while (stillContinue);
    }

    /**
     * Prompts user to enter the date
     * @return current local date
     */

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

    /**
     * Allows for items used within the theater to be purchased in a chosen quantity
     */

    public static void addItemMenu() {

        System.out.print("Enter item id: ");

        byte id = input.nextByte();
        input.nextLine();

        System.out.print("Enter item name: ");
        String name = input.nextLine();

        System.out.print("Enter initial quantity: ");
        short quantity = input.nextShort();
        input.nextLine();

        System.out.print("Enter buying cost from supplier: ");
        short buyingCost = input.nextShort();
        input.nextLine();

        if (!Inventory.contains(id)) {
            Inventory.addItem(new Item(id, name, quantity, buyingCost));
        } else {
            System.out.println("Item with id " + id + " already exists");
        }
    }

    /**
     * Allows for the removal of items within the theater
     */

    public static void removeItemMenu() {

        InventoryManager.getInventory();

        if (!Inventory.hasItems()) {
            System.out.println("No item available!");
            return ;
        }

        System.out.println("Which item do you want to remove: ");
        byte index;

        for (int i=1; i<=Inventory.getItemList().size(); i++) {
            System.out.println(i + ". " + Inventory.getItemList().get(i-1).getItemName());
        }

        index = input.nextByte();
        index -=1;
        input.nextLine();

        if (index >=0 && index < Inventory.getItemList().size()) {
            byte id = Inventory.getItemList().get(index).getItemId();
            Inventory.removeItem(id);
        } else {
            System.out.println("Movie does not exist!");
        }
    }

    /**
     * Allows for the addition or removal of movie theater items
     */

    public static void addOrRemoveItem() {

        boolean stillContinue = true;

        do {
            System.out.println("Choose:");

            PrettyPrinter.printDashLine(menuWidth);

            System.out.println("1. Add item");
            System.out.println("2. Remove item");
            System.out.println("3. Return");

            byte option = input.nextByte();
            input.nextLine();

            switch (option) {
                case 1:
                    addItemMenu();
                    break;
                case 2:
                    removeItemMenu();
                    break;
                default:
                    stillContinue = false;
                    break;
            }

        } while (stillContinue);
    }

    /**
     * Removes selected food item
     */

    public static void addOrRemoveFood() {

        boolean stillContinue = true;

        do {
            System.out.println("Choose:");
            PrettyPrinter.printDashLine(menuWidth);
            System.out.println("1. Add food");
            System.out.println("2. Remove food");
            System.out.println("3. Return");
            byte option = input.nextByte();
            input.nextLine();
            switch (option) {
                case 1:
                    addFoodMenu();
                    break;
                case 2:
                    removeFoodMenu();
                    break;
                default:
                    stillContinue = false;
                    break;
            }
        } while (stillContinue);
    }

    /**
     * Removes food item from food menu
     */

    private static void removeFoodMenu() {

        if (!MenuManager.hasMenu()) {
            System.out.println("No Food available!");
            return ;
        }

        System.out.println("Which food do you want to remove: ");
        byte index;

        for (int i=1; i<=MenuManager.getMenuList().size(); i++) {
            System.out.println(i + ". " + MenuManager.getMenuList().get(i-1).getMenuName());
        }

        index = input.nextByte();
        input.nextLine();
        index -=1;

        if (index >=0 && index < MenuManager.getMenuList().size()) {
            byte id = MenuManager.getMenuList().get(index).getMenuId();
            MenuManager.removeMenu(id);
        } else {
            System.out.println("Movie does not exist!");
        }
    }

    /**
     * Adds food item to food menu
     */

    private static void addFoodMenu() {

        System.out.print("Enter food id: ");
        byte id = input.nextByte();
        input.nextLine();

        System.out.print("Enter food name: ");
        String name = input.nextLine();

        System.out.print("Enter the price: ");
        byte price = input.nextByte();
        input.nextLine();

        if (!MenuManager.contains(id)) {
            MenuManager.addMenu(new Food(id, name, price));
        } else {
            System.out.println("Showtime with id " + id + " already exists");
        }
    }

    /**
     * Prompts user to enter staff role
     * @return if staff is ticket staff or food staff
     */

    private static String askStaffRole(){

        System.out.println("Choose staff role:");
        System.out.println("1. Ticket staff");
        System.out.println("2. Food staff");

        byte option = input.nextByte();
        input.nextLine();

        if (option > 0 && option < 3) {
            if (option == 1) {
                return "ticket";
            } else {
                return "food";
            }
        }
        return "Invalid";
    }

    /**
     * Adds staff to staff menu list
     */

    private static void addStaffMenu() {

        System.out.print("Enter staff id: ");
        byte id = input.nextByte();
        input.nextLine();

        System.out.print("Enter staff name: ");
        String name = input.nextLine();

        System.out.print("Enter hourly rate: ");
        byte rate = input.nextByte();
        input.nextLine();

        System.out.print("Enter schedule (HH:mm-HH:mm): ");
        String schedule = input.nextLine();

        String role = askStaffRole();

        if (!StaffManager.contains(id)) {
            if (role.equals("ticket")) {
                StaffManager.addStaff(new TicketStaff(name, id, rate, schedule));
            } else if (role.equals("food")) {
                StaffManager.addStaff(new FoodStaff(name, id, rate, schedule));
            } else {
                System.out.println("Invalid role");
            }
        } else {
            System.out.println("Item with id " + id + " already exists");
        }
    }

    /**
     * Removes staff from staff menu list
     */

    private static void removeStaffMenu() {

        if (!StaffManager.hasStaffs()) {
            System.out.println("No staff available!");
            return ;
        }

        System.out.println("Which staff do you want to fire: ");
        byte index;

        for (int i=1; i<=StaffManager.getStaffs().size(); i++) {
            System.out.println(i + ". " + StaffManager.getStaffs().get(i-1).getEmployeeName());
        }

        index = input.nextByte();
        input.nextLine();
        index -=1;

        if (index >=0 && index < StaffManager.getStaffs().size()) {
            StaffManager.removeStaff(index);
        } else {
            System.out.println("Staff does not exist!");
        }
    }

    /**
     * Allows for the addition or removal of staff member from staff manu list
     */

    private static void addOrRemoveStaff() {

        boolean stillContinue = true;

        do {
            System.out.println("Choose:");
            PrettyPrinter.printDashLine(menuWidth);

            System.out.println("1. Add staff");
            System.out.println("2. Remove staff");
            System.out.println("3. Return");
            byte option = input.nextByte();
            input.nextLine();

            switch (option) {
                case 1:
                    addStaffMenu();
                    break;
                case 2:
                    removeStaffMenu();
                    break;
                default:
                    stillContinue = false;
                    break;
            }
        } while (stillContinue);
    }


    /**
     * Prints menu for user to select from
     */

    public static void showMenu() {

        createObjects();

        boolean stillContinue = true;

        Staff staff = askForStaff();

        System.out.println("MAIN MENU");

        do {
            // Menu shown to users
            PrettyPrinter.printDashLine(menuWidth);
            System.out.println("Choose from the following:");
            System.out.println("1.  Order movie ticket");
            System.out.println("2.  Order food/drink");
            System.out.println("3.  Show report");
            System.out.println("4.  export report");
            System.out.println("5.  Add/remove movie");
            System.out.println("6.  Add/remove screen");
            System.out.println("7.  Add/remove showtime");
            System.out.println("8.  Add/remove food");
            System.out.println("9.  Add/remove item");
            System.out.println("10. Add/remove staff");
            System.out.println("11. Exit the program");

            byte option = input.nextByte();
            input.nextLine();

            switch (option) {
                // Ticket staff attempting to perform a job they are not assigned
                case 1:
                    if (staff instanceof TicketStaff) {
                        TicketStaff ticketStaff = (TicketStaff) staff;
                        Customer ticketCustomer = askForCustomer();
                        ticketStaff.addNewTicketPayment(ticketCustomer);
                    } else {
                        System.out.println("Invalid! You are working at the food stand!");
                    }

                    break;
                // Food staff attempting to perform a job they are not assigned
                case 2:
                    if (staff instanceof  FoodStaff) {
                        FoodStaff foodStaff = (FoodStaff) staff;
                        Customer foodCustomer = askForCustomer();
                        foodStaff.addNewFoodPayment(foodCustomer);
                    } else {
                        System.out.println("Invalid! You are working at the ticket booth!");
                    }

                    break;
                // Generates report for date
                case 3:
                    System.out.print("Enter start time:");
                    LocalDate startReport = askForDate();

                    System.out.print("Enter end time:");
                    LocalDate endReport = askForDate();

                    staff.getAnalytics().setTimePeriod(startReport, endReport);
                    staff.getAnalytics().generateReport();

                    break;
                // Exports report for date
                case 4:
                    System.out.print("Enter start time:");
                    LocalDate startExport = askForDate();

                    System.out.print("Enter end time:");
                    LocalDate endExport = askForDate();

                    staff.getAnalytics().setTimePeriod(startExport, endExport);
                    staff.getAnalytics().exportReport();

                    break;
                case 5:
                    if (staff instanceof TicketStaff) {
                        addOrRemoveMovie();
                    } else {
                        System.out.println("Invalid! You are working at the food stand!");
                    }

                    break;
                case 6:
                    if (staff instanceof TicketStaff) {
                        addOrRemoveScreen();
                    } else {
                        System.out.println("Invalid! You are working at the food stand!");
                    }

                    break;
                case 7:
                    if (staff instanceof TicketStaff) {
                        addOrRemoveShowtime();
                    } else {
                        System.out.println("Invalid! You are working at the food stand!");
                    }

                    break;
                case 8:
                    if (staff instanceof FoodStaff) {
                        addOrRemoveFood();
                    } else {
                        System.out.println("Invalid! You are working at the food stand!");
                    }

                    break;
                case 9:
                    if (staff instanceof FoodStaff) {
                        addOrRemoveItem();
                    } else {
                        System.out.println("Invalid! You are working at the food stand!");
                    }

                    break;
                case 10:
                    addOrRemoveStaff();
                    break;
                // If the user chooses to no longer continue
                default:
                    stillContinue = false;
                    System.out.println("Exiting the program...");


                    break;
            }

            PrettyPrinter.printDashLine(menuWidth);
        } while(stillContinue);

    }
}
