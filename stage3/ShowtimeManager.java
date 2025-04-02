import java.util.ArrayList;
import java.util.Iterator;

/** This class manages multiple showtimes within the theater
 * @author Logan Cordova
 */

public class ShowtimeManager {

    private ArrayList<Showtime> showtimes;

    /**
     * Constructs ShowtimeManager object
     */
    public ShowtimeManager() {
        this.showtimes = new ArrayList<>();
    }

    /**
     * Adds showtime to list
     * @param showtime
     */
    public void addShowtime(Showtime showtime) {
        showtimes.add(showtime);
    }

    /**
     * Removes showtime from list using showtime ID
     * @param showtimeID
     */
    public void removeShowtime(int showtimeID) {
        Iterator<Showtime> iterator = showtimes.iterator();

        while (iterator.hasNext()); {
            Showtime showtime = iterator.next();
            if (showtime.getShowtimeID() == showtimeID) {
                System.out.println("Showtime " + showtimeID + " removed successfully.");
                return;
            }
        }
        System.out.println("Showtime with ID " + showtimeID + " was not found.");

    }

    /**
     * Checks if screen ID exists in scheduled showtime
     * @param screenID - checks screen ID
     * @return - True if screen ID exists, else: false
     */
    public boolean hasScreenID(byte screenID) {
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
    public void showAllShowtimeSchedule() {
        for (Showtime showtime : showtimes) {
            System.out.println("Showtime ID: " + showtime.getShowtimeID() + ", Movie: " +
                    showtime.getMovie().getTitle() + "Start time: " + showtime.getStartTime() +
                    "End time: " + showtime.getEndTime());
        }
    }
}
