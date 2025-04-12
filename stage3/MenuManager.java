import java.util.ArrayList;

public class MenuManager {

    // Initializes menu list
    private static final ArrayList<Food> menuList = new ArrayList<>();

    /**
     * Constructs MenuManager class
     */

    public MenuManager() {}

    /**
     * Gets the menu list of available food items.
     * @return the list of available food items
     */

    public static ArrayList<Food> getMenuList() {
        return menuList;
    }

    /**
     * Checks if menu list contains an input food
     * @param id of menu item in list
     * @return true / false
     */

    public static boolean contains(byte id) {

        for (Food food : menuList) {
            if (food.getMenuId() == id) {
                return true;
            }
        }
        return false;
   }

    /**
     * Checks if there are any food items in the menu.
     * @return true if there are items in the menu, false otherwise
     */

    public static boolean hasMenu() {
        return !(menuList.isEmpty());
    }

    /**
     * Adds a food item to the menu list.
     * @param menuItem the food item to be added to the menu
     */

    public static void addMenu(Food menuItem) {
        menuList.add(menuItem);
    }

    /**
     * Removes a food item from the menu list based on its menu ID.
     * @param menuId the menu ID of the item to be removed
     */

    public static void removeMenu(byte menuId) {

        if (hasMenu()) {

            boolean found = false;

            // iterate through menu list and check if the menu id is found
            // if yes, remove from menu list
            for(int i=0; i<menuList.size(); i++) {
                if (menuList.get(i).getMenuId()==menuId) {
                    menuList.remove(i);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("The item is not found in the menu!");
            }

        } else {
            System.out.println("There is no item in the menu!");
        }

    }

}
