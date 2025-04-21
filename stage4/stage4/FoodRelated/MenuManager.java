package stage4.FoodRelated;

import stage4.AnalyticsAndFiles.FilesUpdateManager;
import stage4.util.Path;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;

public class MenuManager {

    private static final ArrayList<Food> menuList = new ArrayList<>();

    private static final File foodFile = new File(Path.FOOD_DATA_PATH);

    /**
     * Constructs stage4.TicketRelated.stage4.FoodRelated.MenuManager class
     */
    private MenuManager() {}

    static {
        if (foodFile.length() != 0) {
            try (BufferedReader reader = new BufferedReader(new FileReader(Path.FOOD_DATA_PATH))) {
                String line;

                while ((line = reader.readLine()) != null) {

                    String foodInfo = line.split(";")[0].trim();
                    String recipeInfo = line.split(";")[1].trim();

                    byte foodId = Byte.parseByte(foodInfo.split(",")[0]);
                    String foodName = foodInfo.split(",")[1];
                    byte price = Byte.parseByte(foodInfo.split(",")[2]);

                    Food food = new Food(foodId, foodName, price);

                    TreeMap<Item, Byte> recipe = new TreeMap<>();

                    String[] recipeList = recipeInfo.split(",");

                    for (String aRecipe : recipeList) {
                        byte itemId = Byte.parseByte(aRecipe.split("/")[0]);
                        byte qty = Byte.parseByte(aRecipe.split("/")[1]);

                        if (Inventory.contains(itemId)) {
                            Item anItem = Inventory.getItem(itemId);
                            recipe.put(anItem, qty);
                        }
                    }
                    food.setRecipe(recipe);

                    menuList.add(food);

                    System.out.println(food.getMenuName() + " has been added from the database!");
                }

            } catch (IOException e) {
                System.err.println(e.getMessage());
            }

        }

    }

    /**
     * Gets the menu list of available food items.
     * @return the list of available food items
     */
    public static ArrayList<Food> getMenuList() {
        return new ArrayList<>(menuList);
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
        if (!contains(menuItem.getMenuId())) {
            menuList.add(menuItem);
            System.out.println(menuItem.getMenuName() + " has been added!");
            FilesUpdateManager.updateFoodDataFile(new ArrayList<>(menuList));
        } else {
            System.out.println("stage4.TicketRelated.stage4.FoodRelated.Food " + menuItem.getMenuName() + " already exists!");
        }
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
                    FilesUpdateManager.updateFoodDataFile(new ArrayList<>(menuList));
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

    /**
     * updates the food in the list of food
     * @param index the position of the food in the list
     * @param food the new food object to replace the old one
     */
    public static void updateMenu(byte index, Food food) {
        menuList.set(index, food);
    }

    public static Food searchMenu(byte foodId) {
        for (Food food : menuList) {
            if (food.getMenuId() == foodId) {
                return food;
            }
        }

        System.out.println("food/drink not found");
        return null;
    }

}
