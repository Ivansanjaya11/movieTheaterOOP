import java.util.ArrayList;

public class ScreenManager {

    // Initializes list for movie screens
    private static ArrayList<Screen> screens = new ArrayList<>();

    /**
     * Constructs ScreenManager clss
     */

    public ScreenManager() {}

    /**
     * Ensures the movie screen list has screens
     * @return true / false
     */

    public static boolean hasScreens() {

        return !screens.isEmpty();
    }

    /**
     * Checks if an input screen ID matches a screen ID in the list
     * @param id of movie screen
     * @return ture / false
     */

    public static boolean contains(byte id) {

        for (Screen screen : screens) {
            if (screen.getScreenID() == id) {
                return true;
            }
        }
        return false;
    }

    /**
     * Gets screens from screen list
     * @return screens
     */

    public static ArrayList<Screen> getScreens() {

        return screens;
    }

    /**
     * Adds movie screen to list
     * @param screen to be added
     */

    public static void addScreen(Screen screen) {

        screens.add(screen);
    }

    /**
     * Removes screen from list
     * @param idx to be removed
     */

    public static void removeScreen(byte idx) {

        screens.remove(idx);
        System.out.println("Screen has been removed successfully.");
    }
}
