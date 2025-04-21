package stage4.TicketRelated;

import stage4.AnalyticsAndFiles.FilesUpdateManager;
import stage4.util.Path;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;

/** This class manages multiple showtimes within the theater
 * @author Logan Cordova
 */

public class ShowtimeManager {

    private static final ArrayList<Showtime> showtimes = new ArrayList<>();

    private static final File showtimeFile = new File(Path.SHOWTIME_DATA_PATH);

    /**
     * Constructs stage4.TicketRelated.ShowtimeManager object
     */
    private ShowtimeManager() {}

    static {
        if (showtimeFile.length() != 0) {

            try (BufferedReader reader = new BufferedReader(new FileReader(Path.SHOWTIME_DATA_PATH))) {
                String line;

                while ((line = reader.readLine()) != null) {
                    String[] showtimeInfo = line.split(";")[0].trim().split(",");
                    String[] seatInfo = line.split(";")[1].trim().split("/");

                    byte showtimeId = Byte.parseByte(showtimeInfo[0].trim());
                    byte movieId = Byte.parseByte(showtimeInfo[1].trim());
                    byte screenId = Byte.parseByte(showtimeInfo[2].trim());
                    byte hour = Byte.parseByte(showtimeInfo[3].trim());
                    byte minute = Byte.parseByte(showtimeInfo[4].trim());

                    Movie movie = MovieManager.searchMovie(movieId);
                    Screen screen = ScreenManager.searchScreen(screenId);

                    SeatingArrangement seatings = new SeatingArrangement();

                    int rows = seatings.getRowCapacity();
                    int cols = seatings.getColCapacity();

                    for (int i=0; i<rows; i++) {
                        String[] aRow = seatInfo[i].split(",");
                        for (int j=0; i<cols; i++) {
                            if (aRow[j].equals("1")) {
                                seatings.setSeatStatus(i, j);
                            }
                        }
                    }

                    screen.setSeating(seatings);

                    if (movie != null && screen != null) {
                        Showtime showtime = new Showtime(showtimeId, movie, screen, LocalTime.of(hour, minute));
                        showtimes.add(showtime);
                        System.out.println("showtime #" + showtime.getShowtimeID() + " added from the database!");
                    } else {
                        System.out.println("movie or screen not properly set up!");
                    }
                }
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }

        }
    }

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
        return new ArrayList<>(showtimes);
    }

    /**
     * Adds showtime to list
     * @param showtime a showtime to be added
     */
    public static void addShowtime(Showtime showtime) {
        if (!contains(showtime.getShowtimeID())) {
            showtimes.add(showtime);
            System.out.println("showtime #" + showtime.getShowtimeID() + " has been added!");
            FilesUpdateManager.updateShowtimeDataFile(new ArrayList<>(showtimes));
        } else {
            System.out.println("showtime #" + showtime.getShowtimeID() + " already exists!");
        }
    }

    /**
     * Removes showtime from list using showtime ID
     * @param index the index of the showtime to be removed
     */

    public static void removeShowtime(int index) {
        Showtime showtimeToBeRemoved = showtimes.get(index);
        showtimes.remove(index);
        FilesUpdateManager.updateShowtimeDataFile(new ArrayList<>(showtimes));
        System.out.println("stage4.TicketRelated.Showtime " + showtimeToBeRemoved.getShowtimeID() + " has been removed!");
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

    public static void updateShowtime(byte index, Showtime showtime) {
        showtimes.set(index, showtime);
    }

    /**
     * Displays all scheduled showtimes
     */
    public static void showAllShowtimeSchedule() {
        for (Showtime showtime : showtimes) {
            System.out.println("stage4.TicketRelated.stage4.TicketRelated.stage4.TicketRelated.Showtime ID: " + showtime.getShowtimeID() + ", stage4.TicketRelated.Movie: " +
                    showtime.getMovie().getTitle() + "Start time: " + showtime.getStartTime() +
                    "End time: " + showtime.getEndTime());
        }
    }

    public static Showtime searchShowtime(byte showtimeId) {
        for (Showtime showtime : showtimes) {
            if (showtime.getShowtimeID() == showtimeId) {
                return showtime;
            }
        }

        System.out.println("showtime not found!");
        return null;
    }

}
