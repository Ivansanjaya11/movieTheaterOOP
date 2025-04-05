import java.util.ArrayList;

public class MenuManager {
    private static MenuManager menuManager;
    private static ArrayList<Food> menuList = new ArrayList<>();

    private MenuManager() {}

    public static MenuManager getInstance() {
        if (menuManager == null) {
            menuManager = new MenuManager();
        }
        return menuManager;
    }

    /**
     * Gets the menu list of available food items.
     *
     * @return the list of available food items
     */
    public static ArrayList<Food> getMenuList() {
        return menuList;
    }

    /**
     * method to get the Food object with a certain id
     */
    public static Food getMenu(byte id) {
        for (Food aFood : menuList) {
            if (aFood.getMenuId() == id) {
                return aFood;
            }
        }
        return null;
    }


    /**
     * Sets the menu list of available food items.
     *
     * @param newMenuList the new list of available food items
     */
    public static void setMenuList(ArrayList<Food> newMenuList) {
        menuList = newMenuList;
    }

    /**
     * Checks if there are any food items in the menu.
     *
     * @return true if there are items in the menu, false otherwise
     */
    public static boolean hasMenu() {
        return !(menuList.size()==0);
    }

    /**
     * Adds a food item to the menu list.
     *
     * @param menuItem the food item to be added to the menu
     */
    public static void addMenu(Food menuItem) {
        menuList.add(menuItem);
    }

    /**
     * Removes a food item from the menu list based on its menu ID.
     *
     * @param menuId the menu ID of the item to be removed
     */
    public static void removeMenu(byte menuId) {
        try {
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
                throw new IndexOutOfBoundsException("There is no item in the menu!");
            }
        } catch (IndexOutOfBoundsException e) {
            System.err.println(e.getMessage());
        }
    }
}
