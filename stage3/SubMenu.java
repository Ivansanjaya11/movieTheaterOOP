import util.PrettyPrinter;

import java.util.Scanner;

public class SubMenu {
    // Initializes scanner and menu width
    private static final Scanner input = new Scanner(System.in);
    private static final short menuWidth = 100;

    private SubMenu() {}


    /**
     * Allows for the addition or removal of a movie screen
     */

    public static void addOrRemoveScreen() {

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
                    SubSubMenuTicket.addScreenMenu();
                    break;
                case 2:
                    SubSubMenuTicket.removeScreenMenu();
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

    public static void addOrRemoveMovie() {

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
                    SubSubMenuTicket.addMovieMenu();
                    break;
                case 2:
                    SubSubMenuTicket.removeMovieMenu();
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

    public static void addOrRemoveShowtime() {

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
                    SubSubMenuTicket.addShowtimeMenu();
                    break;
                case 2:
                    SubSubMenuTicket.removeShowtimeMenu();
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
                    SubSubMenuFood.addItemMenu();
                    break;
                case 2:
                    SubSubMenuFood.removeItemMenu();
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
            //Provides the user with options to add or remove food items from menu or return
            System.out.println("Choose:");
            PrettyPrinter.printDashLine(menuWidth);
            System.out.println("1. Add food");
            System.out.println("2. Remove food");
            System.out.println("3. Return");
            byte option = input.nextByte();
            input.nextLine();
            switch (option) {
                case 1:
                    SubSubMenuFood.addFoodMenu();
                    break;
                case 2:
                    SubSubMenuFood.removeFoodMenu();
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

    public static void addOrRemoveStaff() {

        boolean stillContinue = true;

        // Provides options to the user while they are still selecting
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
                    SubSubMenuStaff.addStaffMenu();
                    break;
                case 2:
                    SubSubMenuStaff.removeStaffMenu();
                    break;
                default:
                    stillContinue = false;
                    break;
            }
        } while (stillContinue);
    }
}
