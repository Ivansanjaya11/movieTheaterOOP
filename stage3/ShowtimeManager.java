import java.util.ArrayList;
import java.util.Iterator;

/** This class manages multiple showtimes within the theater
 * @author Logan Cordova
 */

public class ShowtimeManager {

    // Initializes Array List of Movie Showtimes
    private static final ArrayList<Showtime> showtimes = new ArrayList<>();

    /**
     * Constructs ShowtimeManager object
     */

    public ShowtimeManager() {}

    /**
     * Ensures a movie screen has set showtimes
     * @return ture / false
     */

    public static boolean hasShowtimes() {

        return !showtimes.isEmpty();
    }

    /**
     * Checks if selected showtime ID exists
     * @param id of showtime
     * @return true / false
     */

    public static boolean contains(byte id) {

        for (Showtime showtime : showtimes) {
            if (showtime.getShowtimeID() == id) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns list of showtimes for a movie
     * @return list of showtimes available
     */

    public static ArrayList<Showtime> getShowtimes() {
        return showtimes;
    }

    /**
     * Adds showtime to list
     * @param showtime a showtime to be added
     */

    public static void addShowtime(Showtime showtime) {
        showtimes.add(showtime);
    }

    /**
     * Removes showtime from list using showtime ID
     * @param index the index of the showtime to be removed
     */

    public static void removeShowtime(int index) {

        showtimes.remove(index);
        System.out.println("Showtime " + index + " removed successfully.");
    }

    /**
     * Checks if screen ID exists in scheduled showtime
     * @param screenID checks screen ID
     * @return True if screen ID exists, else: false
     */

    public static boolean hasScreenID(byte screenID) {

        for (Showtime showtime : showtimes) {
            if (showtime.getScreen().getScreenID() == screenID) {
                return true;
            }
        }
        return false;
    }

    /**
     * Displays all scheduled showtimes
     */

    public static void showAllShowtimeSchedule() {

        for (Showtime showtime : showtimes) {
            System.out.println("Showtime ID: " + showtime.getShowtimeID() + ", Movie: " +
                    showtime.getMovie().getTitle() + "Start time: " + showtime.getStartTime() +
                    "End time: " + showtime.getEndTime());
        }
    }
}
