import java.util.*;

public class OrderFood extends Order {

    /**
     * Method that prompts and records user food order
     * @param detail of user food order
     * @return details about user food order
     */

    public static DetailFoodBought takeFoodOrder(DetailFoodBought detail) {

        do {
            System.out.println("Choose:");
            System.out.println("1. Add order");
            System.out.println("2. Remove order");
            byte addOrRemove = input.nextByte();

            // add order
            if (addOrRemove==1) {
                // ask the user to choose from a list of food menu
                detail = showFoodOptionToAdd(detail);

                // ask if user still wants to order
                boolean stillContinue = askStillContinue();

                if (!stillContinue) {
                    boolean isCorrect = reviewFoodOrder(detail);
                    if (isCorrect) {
                        break;
                    }
                }

                // remove order
            } else {
                // remove the order
                detail = showFoodOptionToRemove(detail);

                // ask if the user still wants to order
                boolean stillContinue = askStillContinue();

                if (!stillContinue) {
                    boolean isCorrect = reviewFoodOrder(detail);
                    if (isCorrect) {
                        break;
                    }
                }

            }
        } while (true);

        if (detail.isEmpty()) {
            return null;
        }

        return detail;
    }

    /**
     * Reviews the customer's order to confirm if it is correct.
     *
     * @return true if the order is correct, false otherwise
     */

    private static boolean reviewFoodOrder(DetailFoodBought detail) {

        TreeMap<Food, Byte> orderedFood = detail.getOrderedFood();

        // print out the ordered food one by one
        byte i = 1;
        for (Food aFood : orderedFood.keySet()) {
            System.out.print(i + ". ");
            System.out.print(aFood.getMenuName() + ": ");
            System.out.println(orderedFood.get(aFood));
            i++;
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

    /**
     * Prompts user to add more food to their order
     * @param detail of food being purchased
     * @return menu idem ID, Name, and Price
     */

    private static DetailFoodBought showFoodOptionToAdd(DetailFoodBought detail) {

        ArrayList<Food> menuList = MenuManager.getMenuList();

        System.out.println("Choose from the following menu: ");

        for (Food food : menuList) {
            System.out.print(food.getMenuId() + ". ");
            System.out.print(food.getMenuName() + ": $");
            System.out.println(food.getPrice());
        }
        byte menuOption = input.nextByte();

        Food chosenFood = null;

        if (menuOption >= 1 && menuOption <= menuList.size()) {
            for (Food aFood : menuList) {
                if (aFood.getMenuId() == menuOption) {
                    chosenFood = aFood;
                }
            }

            byte quantity = askQuantityToAdd();

            if (detail.isExist(chosenFood)) {
                quantity += detail.getOrderedFood().get(chosenFood);
            }

            detail.addFood(chosenFood, quantity);

            return detail;
        } else {
            System.out.println("There is no such item in the menu!");
        }
        return null;
    }

    /**
     * Allows users to remove food items from their order
     * @param detail of current food order
     * @return removed food item(s)
     */

    private static DetailFoodBought showFoodOptionToRemove(DetailFoodBought detail) {

        TreeMap<Food, Byte> orderedFood = detail.getOrderedFood();


        if (!orderedFood.isEmpty()) {
            System.out.println("Choose which one to remove: ");
            byte j = 1;

            // list all ordered food to choose which to remove from order
            for (Food aFood : orderedFood.keySet()) {
                System.out.print(j + ". ");
                System.out.print(aFood.getMenuName() + ": ");
                System.out.println(orderedFood.get(aFood));
                j++;
            }

            byte removeOption = input.nextByte();

            if (removeOption >= 1 && removeOption <= orderedFood.size()) {

                byte idx = 0;
                Map.Entry<Food, Byte> foodToRemove = null;
                Iterator<Map.Entry<Food, Byte>> iter = orderedFood.entrySet().iterator();

                while (idx < removeOption) {
                    foodToRemove = iter.next();
                    idx++;
                }

                detail.removeFood(foodToRemove.getKey());
            } else {
                System.out.println("There is no such item in your order!");
            }
        } else {
            System.out.println("You haven't ordered anything yet!");
        }

        return detail;
    }


    /**
     * Asks user the quantity of the food item they would like to purchase
     * @return quantity of selected food item
     */

    private static byte askQuantityToAdd() {

        System.out.print("How many do you want? ");
        byte quantity = input.nextByte();
        if (quantity > 0) {
            return quantity;
        }
        return -1;
    }

}
