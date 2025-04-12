import util.PrettyPrinter;

import java.util.Scanner;

public class SubMenu {

    // Initializes scanner for user input and menu width
    private static final Scanner input = new Scanner(System.in);
    private static final short menuWidth = 100;

    private SubMenu() {}


    /**
     * Allows for the addition or removal of a movie screen
     */

    public static void addOrRemoveOrDisplayOrUpdateScreen() {

        boolean stillContinue = true;

        do {
            System.out.println("Choose:");

            PrettyPrinter.printDashLine(menuWidth);

            System.out.println("1. Add screen");
            System.out.println("2. Remove screen");
            System.out.println("3. Display screen");
            System.out.println("4. Update screen");
            System.out.println("5. Return");

            byte option = input.nextByte();
            input.nextLine();

            switch (option) {
                case 1:
                    SubSubMenuTicket.addScreenMenu();
                    break;
                case 2:
                    SubSubMenuTicket.removeScreenMenu();
                    break;
                case 3:
                    SubSubMenuTicket.displayScreen();
                    break;
                case 4:
                    SubSubMenuTicket.updateScreenMenu();
                    break;
                default:
                    stillContinue = false;
                    break;
            }

        } while (stillContinue);
    }


    /**
     * Allows for movies to be added or removed from menu list
     */

    public static void addOrRemoveOrDisplayOrUpdateMovie() {

        boolean stillContinue = true;

        do {
            System.out.println("Choose:");
            PrettyPrinter.printDashLine(menuWidth);
            System.out.println("1. Add movie");
            System.out.println("2. Remove movie");
            System.out.println("3. Display movie");
            System.out.println("4. Update movie");
            System.out.println("5. Return");
            byte option = input.nextByte();
            input.nextLine();
            switch (option) {
                case 1:
                    SubSubMenuTicket.addMovieMenu();
                    break;
                case 2:
                    SubSubMenuTicket.removeMovieMenu();
                    break;
                case 3:
                    SubSubMenuTicket.displayMovie();
                    break;
                case 4:
                    SubSubMenuTicket.updateMovieMenu();
                    break;
                default:
                    stillContinue = false;
                    break;
            }
        } while (stillContinue);
    }




    /**
     * Allows for the addition or removal of a movie showtime
     */

    public static void addOrRemoveOrDisplayOrUpdateShowtime() {

        boolean stillContinue = true;

        do {
            System.out.println("Choose:");
            PrettyPrinter.printDashLine(menuWidth);
            System.out.println("1. Add showtime");
            System.out.println("2. Remove showtime");
            System.out.println("3. Display showtime");
            System.out.println("4. Update showtime");
            System.out.println("5. Return");
            byte option = input.nextByte();
            input.nextLine();
            switch (option) {
                case 1:
                    SubSubMenuTicket.addShowtimeMenu();
                    break;
                case 2:
                    SubSubMenuTicket.removeShowtimeMenu();
                    break;
                case 3:
                    SubSubMenuTicket.displayShowtime();
                    break;
                case 4:
                    SubSubMenuTicket.updateShowtimeMenu();
                    break;
                default:
                    stillContinue = false;
                    break;
            }
        } while (stillContinue);
    }

    /**
     * Adds, Removes, or Displays recipe based on user selection
     */

    public static void addOrRemoveOrDisplayOrUpdateRecipe() {

        boolean stillContinue = true;

        do {
            System.out.println("Choose:");

            PrettyPrinter.printDashLine(menuWidth);

            System.out.println("1. Add recipe");
            System.out.println("2. Remove recipe");
            System.out.println("3. Display recipe");
            System.out.println("4. Update recipe quantity");
            System.out.println("5. Return");

            byte option = input.nextByte();
            input.nextLine();

            switch (option) {
                // Adds recipe to menu
                case 1:
                    SubSubMenuFood.addRecipeMenu();
                    break;
                // Removes recipe from menu
                case 2:
                    SubSubMenuFood.removeRecipeMenu();
                    break;
                // Displays menu recipes
                case 3:
                    SubSubMenuFood.displayRecipe();
                    break;
                case 4:
                    SubSubMenuFood.updateRecipeMenu();
                    break;
                default:
                    stillContinue = false;
                    break;
            }
        } while (stillContinue);
    }

    /**
     * Allows for the addition or removal of movie theater items
     */

    public static void addOrRemoveOrDisplayOrUpdateItem() {

        boolean stillContinue = true;

        do {
            System.out.println("Choose:");

            PrettyPrinter.printDashLine(menuWidth);

            System.out.println("1. Add item");
            System.out.println("2. Remove item");
            System.out.println("3. Display item");
            System.out.println("4. Update item");
            System.out.println("5. Return");

            byte option = input.nextByte();
            input.nextLine();

            switch (option) {
                case 1:
                    SubSubMenuFood.addItemMenu();
                    break;
                case 2:
                    SubSubMenuFood.removeItemMenu();
                    break;
                case 3:
                    SubSubMenuFood.displayItem();
                    break;
                case 4:
                    SubSubMenuFood.updateItemMenu();
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

    public static void addOrRemoveOrDisplayOrUpdateFood() {

        boolean stillContinue = true;

        do {
            //Provides the user with options to add or remove food items from menu or return
            System.out.println("Choose:");
            PrettyPrinter.printDashLine(menuWidth);
            System.out.println("1. Add food");
            System.out.println("2. Remove food");
            System.out.println("3. Display food");
            System.out.println("4. Update food");
            System.out.println("5. Return");
            byte option = input.nextByte();
            input.nextLine();
            switch (option) {
                case 1:
                    SubSubMenuFood.addFoodMenu();
                    break;
                case 2:
                    SubSubMenuFood.removeFoodMenu();
                    break;
                case 3:
                    SubSubMenuFood.displayFood();
                    break;
                case 4:
                    SubSubMenuFood.updateFoodMenu();
                    break;
                default:
                    stillContinue = false;
                    break;
            }
        } while (stillContinue);
    }

    /**
     * Allows for the addition or removal of staff member from staff manu list
     */

    public static void addOrRemoveOrDisplayOrUpdateStaff() {

        boolean stillContinue = true;

        // Provides options to the user while they are still selecting
        do {
            System.out.println("Choose:");
            PrettyPrinter.printDashLine(menuWidth);

            System.out.println("1. Add staff");
            System.out.println("2. Remove staff");
            System.out.println("3. Display staff");
            System.out.println("4. Update staff");
            System.out.println("5. Return");
            byte option = input.nextByte();
            input.nextLine();

            switch (option) {
                case 1:
                    SubSubMenuStaff.addStaffMenu();
                    break;
                case 2:
                    SubSubMenuStaff.removeStaffMenu();
                    break;
                case 3:
                    SubSubMenuStaff.displayStaff();
                    break;
                case 4:
                    SubSubMenuStaff.updateStaffMenu();
                    break;
                default:
                    stillContinue = false;
                    break;
            }
        } while (stillContinue);
    }
}
