import java.util.*;

public class Order {
    protected static Scanner input = new Scanner(System.in);

    private Order() {}

    private static Showtime showTicketOptionToAdd() {

    }

    private static byte askTicketQuantityToAdd(Showtime showtime) {

    }

    private static byte[] updateNumTickets(Showtime showtime, byte quantity) {

    }

    private static byte[] showOptionToRemove(byte[] orderedTicket) {

    }

    private static boolean reviewTicketOrder(Showtime showtime, byte[] orderedTicket) {

    }

    public static byte[] takeTicketOrder() {
        byte[] orderedTicket = new byte[2];

        Showtime showtime = null;

        do {
            System.out.println("Choose:");
            System.out.println("1. Add order");
            System.out.println("2. Remove order");
            byte addOrRemove = input.nextByte();

            if (addOrRemove == 1) {
                showtime = showTicketOptionToAdd();
                byte quantity = askTicketQuantityToAdd(showtime);
                orderedTicket = updateNumTickets(showtime, quantity);

                boolean stillContinue = askStillContinue();

                if (!stillContinue) {
                    boolean isCorrect = reviewTicketOrder(showtime, orderedTicket);
                    if (isCorrect) {
                        break;
                    }
                }
            } else {
                orderedTicket = showOptionToRemove(orderedTicket);
                boolean stillContinue = askStillContinue();

                if (!stillContinue) {
                    boolean isCorrect = reviewTicketOrder(showtime, orderedTicket);
                    if (isCorrect) {
                        break;
                    }
                }
            }
        } while(true);

        return orderedTicket;
    }

    public static void reviewTicketOrder() {

    }




    private static Food showOptionToAdd(ArrayList<Food> menuList) {
        System.out.println("Choose from the following menu: ");
        for (Food food : menuList) {
            System.out.print(food.getMenuId() + ". ");
            System.out.print(food.getMenuName() + ": $");
            System.out.println(food.getPrice());
        }
        byte menuOption = input.nextByte();
        if (menuOption >= 1 && menuOption <= menuList.size()) {
            for (Food aFood : menuList) {
                if (aFood.getMenuId() == menuOption) {
                    return aFood;
                }
            }
        } else {
            System.out.println("There is no such item in the menu!");
        }
        return null;
    } byte

    private static byte askQuantityToAdd() {
        System.out.print("How many do you want? ");
        byte quantity = input.nextByte();
        if (quantity > 0) {
            return quantity;
        }
        return -1;
    }

    private static TreeMap<Food, Byte> showOptionToRemove(TreeMap<Food, Byte> orderedFood) {
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
            if (removeOption >= 1 && removeOption <= orderedFood.size()) {

                byte idx = 1;
                Map.Entry<Food, Byte> foodToRemove = null;
                Iterator<Map.Entry<Food, Byte>> iter = orderedFood.entrySet().iterator();

                while (idx < removeOption) {
                    foodToRemove = iter.next();
                }

                orderedFood.remove(foodToRemove.getKey());
            } else {
                System.out.println("There is no such item in your order!");
            }
        } else {
            System.out.println("You haven't ordered anything yet!");
        }

        return orderedFood;
    }

    private static boolean askStillContinue() {
        System.out.print("Do you still want to order more? (y/n)");
        char option1 = input.next().charAt(0);

        // if no, then review order, if confirmed, then break out of do-while loop
        // if yes, exits all if statements and iterate from the beginning again
        if (String.valueOf(option1).equalsIgnoreCase("n")) {
            return false;
        }
        return true;
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
                Food aFood = showOptionToAdd(menuList);

                // ask for order quantity
                byte quantity = askQuantityToAdd();

                // set the ordered food and quantity to a tree map and store to array list of ordered food
                orderedFood.put(aFood, quantity);

                // ask if user still wants to order
                boolean stillContinue = askStillContinue();

                if (!stillContinue) {
                    boolean isCorrect = reviewFoodOrder(orderedFood);
                    if (isCorrect) {
                        break;
                    }
                }

            // remove order
            } else {
                // remove the order
                orderedFood = showOptionToRemove(orderedFood);

                // ask if the user still wants to order
                boolean stillContinue = askStillContinue();

                if (!stillContinue) {
                    boolean isCorrect = reviewFoodOrder(orderedFood);
                    if (isCorrect) {
                        break;
                    }
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
