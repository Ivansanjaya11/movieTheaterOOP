import util.PrettyPrinter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Prompt {

    // Initializes Scanner for user input
    private static Scanner input = new Scanner(System.in);

    private Prompt() {}

    /**
     * Prompts user (staff) to enter the date: start time and end time
     * @param staff
     * @return analytics for report
     */

    public static AnalyticsReporter askForAnalyticsReportTime(Staff staff) {

        System.out.println("Enter start time:");
        LocalDate startReport = Prompt.askForDate();

        System.out.println("Enter end time:");
        LocalDate endReport = Prompt.askForDate();

        staff.setAnalytics(new AnalyticsReporter(startReport, endReport));

        AnalyticsReporter analytics = (AnalyticsReporter) staff.getAnalytics();
        analytics.setTimePeriod(startReport, endReport);
        return analytics;
    }


    /**
     * Prompts user (staff) to enter the date: start time and end time
     * @param staff
     * @return analytics for exportation
     */

    public static AnalyticsExporter askForAnalyticsExportTime(Staff staff) {

        System.out.println("Enter start time:");
        LocalDate startReport = Prompt.askForDate();

        System.out.println("Enter end time:");
        LocalDate endReport = Prompt.askForDate();

        staff.setAnalytics(new AnalyticsExporter(startReport, endReport));

        AnalyticsExporter analytics = (AnalyticsExporter) staff.getAnalytics();
        analytics.setTimePeriod(startReport, endReport);
        return analytics;
    }

    /**
     * Prompts user to sign in for Food Staff duties
     * @return staff information and duties
     */

    public static Staff askForStaff() {

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

    public static Customer askForCustomer() {

        System.out.print("Enter customer's name: ");
        String name = input.nextLine();

        return new Customer(name);
    }

    /**
     * Prompts users to select a movie to watch
     * @return movies to be selected from
     */

    public static Movie askForMovie() {

        System.out.println("Which movie do you want: ");
        byte index;

        // Provides movie selection options to user
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

    public static Screen askForScreen() {

        System.out.println("Which screen do you want: ");
        byte index;

        // Provides screen selection options to user
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

    public static LocalTime askForTime() {

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
     * Prompts user to enter the date
     * @return current local date
     */

    public static LocalDate askForDate() {

        do {
            try {
                System.out.print("\tEnter the day:");
                int day = input.nextInt();
                input.nextLine();

                System.out.print("\tEnter the month:");
                int month = input.nextInt();
                input.nextLine();

                System.out.print("\tEnter the year:");
                int year = input.nextInt();
                input.nextLine();

                return LocalDate.of(year, month, day);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (true);
    }

    /**
     * Prompts user to enter staff role
     * @return if staff is ticket staff or food staff
     */

    public static String askStaffRole(){

        System.out.println("Choose staff role:");
        System.out.println("1. Ticket staff");
        System.out.println("2. Food staff");

        byte option = input.nextByte();
        input.nextLine();

        // Type of staff member
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
     * Prompts user to select food item from menu
     * @return food, if food exists within menu list
     */

    public static Food askForFood() {

        System.out.println("Choose which food:");

        byte index;

        ArrayList<Food> menuList = MenuManager.getMenuList();

        for (int i=1; i<=menuList.size(); i++) {
            Food food = menuList.get(i-1);
            System.out.println(i + ". " + food.getMenuName());
        }

        index = input.nextByte();
        index -=1;
        input.nextLine();

        if (index >= 0 && index < menuList.size()) {
            return menuList.get(index);
        }

        System.out.println("Food does not exist!");
        return null;
    }

    /**
     * Determines if item needed for recipe, required to make food, exists in item list
     * @param food
     * @return message if item exists in item list or not
     */

    public static Item askForItemRecipe(Food food) {

        TreeMap<Item, Byte> recipeItemList = food.getRecipe();

        byte index;
        byte idx = 1;

        for (Map.Entry<Item, Byte> entry : recipeItemList.entrySet()) {
            Item item = entry.getKey();
            byte qty = entry.getValue();
            System.out.println(idx + ". " + item.getItemName() + "; requiring " + qty + " unit to make a single " + food.getMenuName());
            idx++;
        }

        index = input.nextByte();
        index -=1;
        input.nextLine();

        idx = 0;

        if (index >= 0 && index < recipeItemList.size()) {
            for (Map.Entry<Item, Byte> entry : recipeItemList.entrySet()) {
                if (index == idx) {
                    return entry.getKey();
                }
                idx++;
            }
        }

        System.out.println("Item does not exist in the recipe!");
        return null;
    }

    /**
     * Checks if item exists in item list
     * @return message if item exists or not
     */

    public static Item askForItemRecipe() {

        byte index;

        ArrayList<Item> itemList = Inventory.getItemList();

        for (int i=1; i<=itemList.size(); i++) {
            System.out.println(i + ". " + itemList.get(i-1).getItemName());
        }

        index = input.nextByte();
        index -=1;
        input.nextLine();

        if (index >= 0 && index < itemList.size()) {
            return itemList.get(index);
        }

        System.out.println("Item does not exist!");
        return null;
    }
}
