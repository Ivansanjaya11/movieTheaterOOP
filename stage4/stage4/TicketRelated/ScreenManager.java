package stage4.TicketRelated;

import stage4.AnalyticsAndFiles.FilesUpdateManager;
import stage4.util.Path;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ScreenManager {

    private static final ArrayList<Screen> screens = new ArrayList<>();

    private static final File screenFile = new File(Path.SCREEN_DATA_PATH);

    /**
     * Constructs stage4.TicketRelated.ScreenManager class
     */
    private ScreenManager() {}

    static {
        if (screenFile.length() != 0) {

            try (BufferedReader reader = new BufferedReader(new FileReader(Path.SCREEN_DATA_PATH))) {
                String line;

                while ((line = reader.readLine()) != null) {
                    String[] screenInfo = line.split(",");

                    byte screenId = Byte.parseByte(screenInfo[0].trim());
                    String screenType = screenInfo[1].trim();

                    screens.add(new Screen(screenId, screenType));
                    System.out.println("screen #" + screenId + " of type '" + screenType + "' added from database!");
                }
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }

        }
    }

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
        return new ArrayList<>(screens);
    }

    /**
     * Adds movie screen to list
     * @param screen to be added
     */
    public static void addScreen(Screen screen) {
        if (!contains(screen.getScreenID())) {
            screens.add(screen);
            System.out.println("screen #" + screen.getScreenID() + " of type '" + screen.getScreenType() + "' has been added!");
            FilesUpdateManager.updateScreenDataFile(new ArrayList<>(screens));
        } else {
            System.out.println("screen #" + screen.getScreenID() + " already exists!");
        }
    }

    /**
     * Removes screen from list
     * @param idx to be removed
     */
    public static void removeScreen(byte idx) {
        Screen screenToBeRemoved = screens.get(idx);
        screens.remove(idx);
        FilesUpdateManager.updateScreenDataFile(new ArrayList<>(screens));
        System.out.println("screen #" + screenToBeRemoved.getScreenID() + " has been removed!");
    }

    /**
     * updates the screen in the list of screen
     * @param index the position of the screen in the list
     * @param screen the new screen to replace the old one
     */
    public static void updateScreen(byte index, Screen screen) {
        screens.set(index, screen);
    }

    public static Screen searchScreen(byte screenId) {
        for (Screen screen : screens) {
            if (screen.getScreenID() == screenId) {
                return screen;
            }
        }

        System.out.println("screen not found!");
        return null;
    }

}
