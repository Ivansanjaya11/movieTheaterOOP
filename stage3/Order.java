import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class Order {
    protected static Scanner input;

    private Order(){

    }

    static {
        input = new Scanner(System.in);
    }

    public static byte[] takeTicketOrder() {

    }

    public static void reviewTicketOrder() {

    }

    public static TreeMap<Food, Byte> takeFoodOrder() {
        TreeMap<Food, Byte> orderedFood = new TreeMap<>();

        ArrayList<Food> menuList = MenuManager.getMenuList();
        do {
            System.out.println("Choose:");
            System.out.println("1. Add order");
            System.out.println("2. Remove order");
            byte addOrRemove = input.nextByte();

            // add order
            if (addOrRemove==1) {
                // ask the user to choose from a list of food menu
                System.out.println("Choose from the following menu: ");
                for (Food food : menuList) {
                    System.out.print(food.getMenuId() + ". ");
                    System.out.print(food.getMenuName() + ": $");
                    System.out.println(food.getPrice());
                }
                byte menuOption = input.nextByte();
                if (menuOption >= 1 && menuOption <= menuList.size()) {

                    // ask for order quantity
                    System.out.print("How many do you want? ");
                    byte quantity = input.nextByte();
                    if (quantity > 0) {

                        // set the ordered food and quantity to a tuple and store to array list of ordered food
                        orderedFood.put(menuList.get(menuOption-1), quantity);

                        // ask if user still wants to order
                        System.out.print("Do you still want to order more? (y/n)");
                        char option1 = input.next().charAt(0);

                        // if no, then review order, if confirmed, then break out of do-while loop
                        // if yes, exits all if statements and iterate from the beginning again
                        if (String.valueOf(option1).equalsIgnoreCase("n")) {
                            boolean isCorrect = reviewFoodOrder(orderedFood);
                            if (isCorrect) {
                                break;
                            }
                        }
                    } else {
                        System.out.println("Invalid quantity!");
                    }
                } else {
                    System.out.println("There is no such item in the menu!");
                }

                // remove order
            } else {
                if (!orderedFood.isEmpty()) {
                    System.out.print("Choose which one to remove: ");
                    byte j = 1;

                    // list all ordered food to choose which to remove from order
                    for (Food aFood : orderedFood.keySet()) {
                        System.out.print(j + ". ");
                        System.out.print(aFood.getMenuName() + ": ");
                        System.out.println(orderedFood.get(aFood));
                    }

                    byte removeOption = input.nextByte();
                    if (removeOption >=1 && removeOption <= orderedFood.size()) {

                        // remove the order
                        orderedFood.remove(MenuManager.getMenu(removeOption));

                        // ask if the user still wants to order
                        System.out.print("Do you still want to order more? (y/n)");
                        char option2 = input.next().charAt(0);

                        // if no, then review order, if confirmed, then break out of do-while loop
                        // if yes, exits all if statements and iterate from the beginning again
                        if (String.valueOf(option2).equalsIgnoreCase("n")) {
                            boolean isCorrect = reviewFoodOrder(orderedFood);
                            if (isCorrect) {
                                break;
                            }
                        }
                    } else {
                        System.out.println("There is no such item in your order!");
                    }
                } else {
                    System.out.println("You haven't ordered anything yet!");
                }
            }
        } while (true);

        return orderedFood;
    }

    /**
     * Reviews the customer's order to confirm if it is correct.
     *
     * @return true if the order is correct, false otherwise
     */
    private static boolean reviewFoodOrder(TreeMap<Food, Byte> orderedFood) {
        // print out the ordered food one by one
        byte i = 1;
        for (Food aFood : orderedFood.keySet()) {
            System.out.print(i + ". ");
            System.out.print(aFood.getMenuName() + ": ");
            System.out.println(orderedFood.get(aFood));
        }

        // ask the user if the order is correct
        System.out.print("Is this correct? (y/n)");
        char option = input.next().charAt(0);

        // if yes then return true, otherwise, false
        if (String.valueOf(option).equalsIgnoreCase("y")) {
            return true;
        }
        return false;
    }
}
