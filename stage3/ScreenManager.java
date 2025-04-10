import java.util.ArrayList;

public class ScreenManager {
    private static final ArrayList<Screen> screens = new ArrayList<>();

    public ScreenManager() {}

    public static boolean hasScreens() {
        return !screens.isEmpty();
    }

    public static boolean contains(byte id) {
        for (Screen screen : screens) {
            if (screen.getScreenID() == id) {
                return true;
            }
        }
        return false;
    }

    public static ArrayList<Screen> getScreens() {
        return screens;
    }

    public static void addScreen(Screen screen) {
        screens.add(screen);
    }

    public static void removeScreen(byte idx) {
        screens.remove(idx);
        System.out.println("Screen has been removed successfully.");
    }
}
