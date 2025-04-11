import java.util.Scanner;

public class SubSubMenuFood {
    private static final Scanner input = new Scanner(System.in);

    /**
     * Adds food item to food menu
     */

    public static void addFoodMenu() {

        // Food staff duties when adding food items to the menu
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
     * Removes food item from food menu
     */

    public static void removeFoodMenu() {

        // Food staff duties for removing food items from the menu
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
     * Allows for items used within the theater to be purchased in a chosen quantity
     */

    public static void addItemMenu() {

        // Prompts user to enter item information to be added to menu
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
        // Checks if list has the input item
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
}
