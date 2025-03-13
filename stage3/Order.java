import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Scanner;

public class Order {
    private static Scanner input;

    private Order(){

    }

    static {
        input = new Scanner(System.in);
    }

    public static void takeTicketOrder() {

    }

    public static void reviewTicketOrder() {

    }

    public static ArrayList<Pair<Food, Byte>> takeFoodOrder() {
        ArrayList<Pair<Food, Byte>> orderedFood = new ArrayList<>();

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
                        Pair<Food, Byte> anOrder = new Pair<>(menuList.get(menuOption-1), quantity);
                        orderedFood.add(anOrder);

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
                    for (Pair<Food, Byte> anOrder : orderedFood) {
                        System.out.print(j + ". ");
                        System.out.print(anOrder.getKey().getMenuName() + ": ");
                        System.out.println(anOrder.getValue());
                    }
                    byte removeOption = input.nextByte();
                    if (removeOption >=1 && removeOption <= orderedFood.size()) {

                        // remove the order
                        orderedFood.remove(removeOption-1);

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
    private static boolean reviewFoodOrder(ArrayList<Pair<Food, Byte>> orderedFood) {
        // print out the ordered food one by one
        byte i = 1;
        for (Pair<Food, Byte> anOrder : orderedFood) {
            System.out.print(i + ". ");
            System.out.print(anOrder.getKey().getMenuName() + ": ");
            System.out.println(anOrder.getValue());
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
