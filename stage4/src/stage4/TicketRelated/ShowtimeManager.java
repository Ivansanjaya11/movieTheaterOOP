package stage4.TicketRelated;

import stage4.AnalyticsAndFiles.FilesUpdateManager;
import stage4.util.Color;
import stage4.util.LogPrinter;
import stage4.util.LogType;
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
                    
                    System.out.println(line.split(";")[1].trim());

                    byte showtimeId = Byte.parseByte(showtimeInfo[0].trim());
                    byte movieId = Byte.parseByte(showtimeInfo[1].trim());
                    byte screenId = Byte.parseByte(showtimeInfo[2].trim());
                    byte hour = Byte.parseByte(showtimeInfo[3].trim());
                    byte minute = Byte.parseByte(showtimeInfo[4].trim());

                    Movie movie = MovieManager.searchMovie(movieId);
                    Screen screen = new Screen(ScreenManager.searchScreen(screenId));

                    SeatingArrangement seatings = new SeatingArrangement(screenId);

                    int rows = seatings.getRowCapacity();
                    int cols = seatings.getColCapacity();
                                        
                    for (int i=0; i<rows; i++) {
                        String[] aRow = seatInfo[i].split(",");
                        for (int j=0; j<cols; j++) {
                            if (aRow[j].equals("1")) {
                                seatings.setSeatStatus(i, j);
                            }
                        }
                    }

                    screen.setSeating(seatings);
                    
                    if (movie != null && screen != null) {
                        Showtime showtime = new Showtime(showtimeId, movie, screen, LocalTime.of(hour, minute));
                        showtimes.add(showtime);

                        LogPrinter.println(Color.GREEN, Color.GREEN, LogType.NEW_SHOWTIME,
                                "showtime #" + showtime.getShowtimeID() + " added from the database!");
                        //System.out.println("showtime #" + showtime.getShowtimeID() + " added from the database!");
                    }
                }
            } catch (IOException e) {

                LogPrinter.println(Color.RED, Color.RED, LogType.ERROR, e.getMessage());
                //System.err.println(e.getMessage());
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

            LogPrinter.println(Color.GREEN, Color.GREEN, LogType.NEW_SHOWTIME, "showtime #" + showtime.getShowtimeID() + " has been added!");
            //System.out.println("showtime #" + showtime.getShowtimeID() + " has been added!");
            FilesUpdateManager.updateShowtimeDataFile(new ArrayList<>(showtimes));
        } else {
            LogPrinter.println(Color.WHITE, Color.WHITE, LogType.EXIST_SHOWTIME, "showtime #" + showtime.getShowtimeID() + " already exists!");
            //System.out.println("showtime #" + showtime.getShowtimeID() + " already exists!");
        }
    }

    /**
     * Removes showtime from list using showtime ID
     * @param index the index of the showtime to be removed
     */

    public static void removeShowtime(int index) {
        if (hasShowtimes()) {
            Showtime showtimeToBeRemoved = showtimes.get(index);
            showtimes.remove(index);
            FilesUpdateManager.updateShowtimeDataFile(new ArrayList<>(showtimes));

            LogPrinter.println(Color.CYAN, Color.CYAN, LogType.REMOVE_SHOWTIME,
                    "Showtime #" + showtimeToBeRemoved.getShowtimeID() + " has been removed!");

            //System.out.println("Showtime " + showtimeToBeRemoved.getShowtimeID() + " has been removed!");
        } else {
            LogPrinter.println(Color.WHITE, Color.WHITE, LogType.NOT_EXIST_SHOWTIME, "showtime list is empty!");

        }
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
        LogPrinter.println(Color.MAGENTA, Color.MAGENTA, LogType.UPDATE_SHOWTIME, "Showtime #" + showtime.getShowtimeID() + " updated!");
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

    public static Showtime searchShowtime(byte showtimeId) {
        for (Showtime showtime : showtimes) {
            if (showtime.getShowtimeID() == showtimeId) {
                LogPrinter.println(Color.WHITE, Color.WHITE, LogType.EXIST_SHOWTIME, "Showtime #" + showtimeId + " found!");
                return showtime;
            }
        }

        LogPrinter.println(Color.WHITE, Color.WHITE, LogType.NOT_EXIST_SHOWTIME, "showtime not found!");
        //System.out.println("showtime not found!");
        return null;
    }

}
